/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.web;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jvp.obj.video.lookupBean;
import jvp.obj.video.videoBean;
import jvp.obj.video.videoObj;
import org.primefaces.event.FileUploadEvent;

/**
 * server.xml
 * getvideoObj()getvideoObj()
 * @author i
 */
public class videoMgrObj implements Serializable{

    /**
     * @return the spinneyhill
     */
    
    private int videoType = 101,picked;
    private List<videoBean> list;
    private List<lookupBean> lookup;
    private videoBean videoBean;
    private videoObj videoObj;
    private uploadImages uploadImages;
    private String path = "";
    public String 
            videoCntrEditing = "pgVideo/videoViewPgEditing.xhtml",
            videoCntr    = "pgVideo/videoViewPg.xhtml";
            
    private final mgrVideoProductionInterface iface;
    
    public videoMgrObj(mgrVideoProductionInterface iface){
        //String str = (new SimpleDateFormat().);
        
        this.iface = iface;
        path = getvideoObj().getPath(iface.getObj())+iface.getNewPath();
    }
    
    private videoObj getvideoObj(){
        if (videoObj == null){
            videoObj = new videoObj();
            
        }
        return videoObj;
    }
    public void uploadFile(FileUploadEvent event){
        if (uploadImages == null) {
            uploadImages = new uploadImages(path,"img");
            System.out.println("path ="+path);
            new File(path).mkdirs();
        }
        try {
            String str = uploadImages.uploadFile(event);
            str = str.substring(str.indexOf("jvp"));
            this.getVideoBean().setImageName(str);
            getvideoObj().update(videoBean, iface.getObj());
            iface.forward();
        } catch (IOException ex) {
            Logger.getLogger(videoMgrObj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public void selectChng2(){
        
        for (videoBean x: list){
            if (x.getVideoId() == picked){
                 videoBean = x;
                 break;
            }
        }
        iface.forward();
      
    }
    public void cleanup(){
        if (list != null) list.clear();
        //list = null;
        videoBean = new videoBean();
    }
    public void switchVideo(int type,String html){
        videoType = type;
        genList();
        
        iface.forwardCntr(iface.isLogin() ? videoCntrEditing : videoCntr);
    }
    public void switchVideo(int type){
        videoType = type;
        genList();
        
        iface.forwardCntr(iface.isLogin() ? videoCntrEditing : videoCntr);
    }
    public List<videoBean> getList() {
        if (list == null) genList();
        return list;
    }
    public videoBean getVideoBean() {
        if (videoBean == null) genList();
        return videoBean;
    }
    private synchronized void genList(){
        if (list != null) list.clear();
        picked = 0;
        list = (new videoObj()).getVideoBeanList(videoType, iface.getObj());
        if (list != null && list.size() > 0){
            videoBean = list.get(0);
        } else {
            if (list == null) list = new ArrayList<videoBean>();
            videoBean = new videoBean();
            
        }
    }

    /**
     * @return the picked
     */
    public int getPicked() {
        return picked;
    }

    /**
     * @param picked the picked to set
     */
    public void setPicked(int picked) {
        this.picked = picked;
    }

    /**
     * @return the lookup
     */
    public List<lookupBean> getLookup() {
        if (lookup == null){
            lookup = new ArrayList<lookupBean>();
            lookup.add(new lookupBean(-11,"Flash (Youtube)"));
            lookup.add(new lookupBean(-12,"Quicktime (Vimeo)"));
        }
        return lookup;
    }
}

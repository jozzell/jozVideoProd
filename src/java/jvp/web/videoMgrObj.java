/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jvp.obj.video.videoBean;
import jvp.obj.video.videoObj;
import org.primefaces.component.media.player.FlashPlayer;

/**
 *
 * @author i
 */
public class videoMgrObj implements Serializable{

    /**
     * @return the spinneyhill
     */
    
    private int videoType = 101,picked;
    private List<videoBean> list;
    private videoBean videoBean;
    
    public static final String 
            videoCntr    = "./pgVideo/videoViewPg.xhtml";
            
    private mgrVideoProductionInterface iface;
    
    public videoMgrObj(mgrVideoProductionInterface iface){
        this.iface = iface;
    }
    public void selectChng2(){
        System.err.println(" -> "+FlashPlayer.FLASH);
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
        list = null;
        videoBean = null;
    }
    public void switchVideo(int type){
        videoType = type;
        genList();
        iface.forwardCntr(videoCntr);
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
}

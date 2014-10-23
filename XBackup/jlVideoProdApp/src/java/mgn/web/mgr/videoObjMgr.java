/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.web.mgr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jvp.obj.video.videoBean;
import jvp.obj.video.videoObj;

/**
 *
 * @author lmeans
 */
public class videoObjMgr implements mgnInterface,  Serializable{
    public static final String URL = "./video/youtube.xhtml";
    private List<videoBean> videoList = null;
    private mgnMgrObjInterface iface;
    private int videoType = 100, sysId, picked = -1;
    private videoBean bean = null;
    
    public videoObjMgr(mgnMgrObjInterface i) {
        iface = i;
    }
    @Override
    public String getURL() {
        return URL;
    }

    @Override
    public void cleanup() {
        if (videoList != null) videoList.clear();
        videoList = null;
        bean = null;
        
    }
    
    public void setVideoType(int type, int sysId) {
        this.videoType = type;
        this.sysId = sysId;
        videoList = null;
        bean = null;
    }

    public void pickListChng2() {
        for (videoBean list : getVideoList()) {
            if (list.getVideoId() == picked) {
                bean = list;
            }
        }
        iface.forward();
        
        
    }

    public videoBean getVideoBean() {
        if (bean == null) {
            bean = getVideoList().get(0);
        }
        return bean;
    }

    public List<videoBean> getVideoList() {
        if (videoList == null) {
            videoList = videoObj.getVideoBeanList(videoType, iface.getObj());
            if (videoList == null || videoList.isEmpty()) {
                videoList = new ArrayList<videoBean>();
                videoList.add(new videoBean());
            }
        }
        return videoList;
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

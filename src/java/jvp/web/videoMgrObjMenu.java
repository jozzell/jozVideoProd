/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.web;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class videoMgrObjMenu implements Serializable{
    videoMgrObjMenuInterface iface;
   
    public videoMgrObjMenu(videoMgrObjMenuInterface i){
        iface = i;
    }
    
    // ==============================
    public void setHearAndNow(){
        iface.getVideoMgrObj().switchVideo(107);
    }
    public void setShirley(){
        iface.getVideoMgrObj().switchVideo(108);
    }
    // ==============================
   
    public void setVideoSports(){
        iface.getVideoMgrObj().switchVideo(102);
    }
    public void setVideoSportsGame(){
        iface.getVideoMgrObj().switchVideo(106);
    }
    // ==============================
    public void setEvents(){
        iface.getVideoMgrObj().switchVideo(101);
    }
     public void setVideoSweet16(){
        iface.getVideoMgrObj().switchVideo(100);
    }
    public void setEventsRedCarpet(){
        iface.getVideoMgrObj().switchVideo(105);
    }
    // ==============================
    public void setCommunityPicnic(){
        iface.getVideoMgrObj().switchVideo(103);
    }
    public void setCommunityAwardCeremony(){
        iface.getVideoMgrObj().switchVideo(104);
    }
    // ==============================
    public void setMsRucker(){
        iface.getVideoMgrObj().switchVideo(201);
    }
    public void setMrClean(){
        iface.getVideoMgrObj().switchVideo(200);
    }
    public void set22nd(){
        iface.getVideoMgrObj().switchVideo(203);
    }
    public void setAnaysha(){
        iface.getVideoMgrObj().switchVideo(202);
    }
    public void set23nd(){
        iface.getVideoMgrObj().switchVideo(204);
    }
    public void set24nd(){
        iface.getVideoMgrObj().switchVideo(205);
    }
    // ==============================
     public void setSpinMain(){
        iface.getVideoMgrObj().switchVideo(206);
    }
    public void setSpinBonus(){
        iface.getVideoMgrObj().switchVideo(208);
    }
    public void setLeone(){
        iface.getVideoMgrObj().switchVideo(207);
    }
    // ==============================
    public void setAdds(){
        iface.getVideoMgrObj().switchVideo(210);
    }
}

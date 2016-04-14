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
    // *********************************************
    public void setGospelBrw(){
        iface.setVideoSysId(-1);
    }
    public void setGospelHighlight(){
        iface.setVideoSysId(-2);
    }
    // ==============================
    public void setHearAndNow(){
        iface.setVideoType(107);
    }
    public void setShirley(){
        iface.setVideoType(108);
    }
    // ==============================
   
    public void setVideoSports(){
        iface.setVideoType(102);
    }
    public void setVideoSportsGame(){
        iface.setVideoType(106);
    }
    // ==============================
    public void setEvents(){
        iface.setVideoType(101);
    }
     public void setVideoSweet16(){
        iface.setVideoType(100);
    }
    public void setEventsRedCarpet(){
        iface.setVideoType(105);
    }
    // ==============================
    public void setCommunityPicnic(){
        iface.setVideoType(103);
    }
    public void setCommunityAwardCeremony(){
        iface.setVideoType(104);
    }
    // ==============================
    public void setMsRucker(){
        iface.setVideoType(201);
    }
    public void setMrClean(){
        iface.setVideoType(200);
    }
    public void set22nd(){
        iface.setVideoType(203);
    }
    public void setAnaysha(){
        iface.setVideoType(202);
    }
    public void set23nd(){
        iface.setVideoType(204);
    }
    public void set24nd(){
        iface.setVideoType(205);
    }
    // ==============================
     public void setSpinMain(){
        iface.setVideoType(206);
    }
    public void setSpinBonus(){
        iface.setVideoType(208);
    }
    public void setLeone(){
        iface.setVideoType(207);
    }
    // ==============================
    public void setAdds(){
        iface.setVideoType(210);
    }
}

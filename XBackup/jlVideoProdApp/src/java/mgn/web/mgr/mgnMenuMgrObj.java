/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.mgr;

import mgn.web.mgr.mgnInterface;
import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class mgnMenuMgrObj implements  Serializable{
    mgnMenuMgrObjInterface iface;
    mgnMgrObjInterface ifaceRoot;
    
    mgnInterface  currObj=null;
    public mgnMenuMgrObj(mgnMenuMgrObjInterface i,mgnMgrObjInterface r){
        iface = i;
        this.ifaceRoot = r;
    }    
    // ====================================================
    public void maintUser(){
        iface.getUsrObjMgr().setUserMaint();
        next(iface.getUsrObjMgr());
    }
    // ====================================================
    public void imagesSpinneyHill(){
        next(iface.getImage());
    }
    // ====================================================
    public void videoSpinneyHill(){ 
        
       iface.getVideo().setVideoType(104, -11);
       next( iface.getVideo());
       
    }
    public void videoOldTimersday(){ 
       iface.getVideo().setVideoType(100, -11);
       next( iface.getVideo());
       
    }
    public void videoWhiteAffair(){
       iface.getVideo().setVideoType(103, -11);
       next( iface.getVideo());
    }
    public void video50Plus(){
       iface.getVideo().setVideoType(101, -11);
       next( iface.getVideo());
    }
    public void videoOldTimerDayAct(){
       iface.getVideo().setVideoType(102, -11);
       next( iface.getVideo());
    }
    // ====================================================
    // =====================================================
    private void next(mgnInterface nextObj){
        if( currObj != null && !currObj.equals(nextObj)) {
            System.err.println("Cleanup: "+currObj.getURL());
            currObj.cleanup();
        }
        System.err.println("GoToUrl "+nextObj.getURL());
        currObj = nextObj;
        ifaceRoot.forwardCntr(currObj.getURL());
        
    }
}

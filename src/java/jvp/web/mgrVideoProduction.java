/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.web;

import cv.bisc.db.dbMgr;
import cv.bisc.db.dbMgrEnumType;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
@ManagedBean
@SessionScoped
public class mgrVideoProduction implements mgrVideoProductionInterface,videoMgrObjMenuInterface, Serializable {
    private videoMgrObj videoMgrObj;
    private videoMgrObjMenu videoMgrObjMenu;
    private boolean start = true;
   
    private String 
            prefix = "jozVideoPrd/",
            panelWest="./menu.xhtml",
            panelCenter= null;
    private dbMgr dbMgr;
    private int cnt;
    //private boolean ok = false;
    /**r
     * @return the videoMgrObj
     */
    public void refreshSession(){
        cnt++;
    }
    public int refreshSessionCnt(){
        return cnt;
    }
    public void setHome(){
           panelCenter = "./spinneyHill_Cover.xhtml";
       
    }
    public String getSpinnellHillImage(){
        return prefix+"spinneyHill_Cover.jpg";
    }
    public String getJvpInclude(){
        if (!start){
            return "jvp_include.xhtml";
        } else {
            return "jvp_include_start.xhtml";
        }
        //
        
    }
    public String getWebSiteName(){
        return prefix+"cooltext1674641146.png";
    }
    public String logout() throws IOException{
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath());
        return "";
    }
    @Override
    public videoMgrObj getVideoMgrObj() {
        if (videoMgrObj == null) videoMgrObj = new videoMgrObj(this);
        return videoMgrObj;
    }

   @Override
    public  dbMgrInterface getObj(){
        if (dbMgr == null){
            dbMgr = new dbMgr("jdbc/jvp", dbMgrEnumType.typeMySql.getType());
            
        }
        return dbMgr;
    }
    @Override
    public void forward() {
       
        prefix= "";
        start= false;
        (new factoryObj()).FacesContextForward(getRoot(), FacesContext.getCurrentInstance());
    }
    @Override
     public void forwardCntr(String center){
         panelCenter = center;
         forward();
     }
    public String getRoot(){
            return "jvp.xhtml"; //"jozVideoPrd/jvp.xhtml";
       
    }
    
    public videoMgrObjMenu getVideoMgrObjMenu() {
        if (videoMgrObjMenu == null) videoMgrObjMenu = new videoMgrObjMenu(this);
        return videoMgrObjMenu;
    }

    /**
     * @return the panelWest
     */
    public String getPanelWest() {
        return panelWest;
    }

    /**
     * @return the panelCenter
     */
    public String getPanelCenter() {
        if (panelCenter == null){
            setHome();
        }
        return panelCenter;
    }
}


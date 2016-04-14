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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jvp.obj.video.videoObj;
import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
@ManagedBean
@SessionScoped
public final class mgrVideoProduction implements mgrVideoProductionInterface,videoMgrObjMenuInterface, Serializable {
    private videoMgrObj videoMgrObj;
    private videoMgrObjMenu videoMgrObjMenu;
    private boolean start = true,login=true;
    
    private final String newPath = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
    private String 
            prefix = "jozVideoProd/",
            panelWest="./menu.xhtml",
            panelCenter= null;
    private dbMgr dbMgr;
    private int cnt;
   
    public mgrVideoProduction(){
         refreshSession();
    }
    public void refreshSession(){
       (new videoObj()).chConnect(this.getObj());
        cnt++;
    }
    public int refreshSessionCnt(){
        return cnt;
    }
    public void setHome(){
           panelCenter = "./spinneyHill_Cover.xhtml";
       
    }
    public String getSpinnellHillImage(){
        return "/jvp/spinneyHill_Cover.jpg";
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
        return "/jvp/cooltext1674641146.png";
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
       
        //prefix= "";
        start= false;
        (new factoryObj()).FacesContextForward("/jozVideoProd", FacesContext.getCurrentInstance());
    }
    @Override
     public void forwardCntr(String center){
         panelCenter = center;
         forward();
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

    /**
     * @return the login
     */
    @Override
    public boolean isLogin() {
        return login;
    }

    /**
     * @return the newPath
     */
    @Override
    public String getNewPath() {
        return "/"+newPath;
    }
}


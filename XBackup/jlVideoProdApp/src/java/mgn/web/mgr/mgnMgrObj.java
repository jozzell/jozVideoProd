package mgn.web.mgr;


import cv.bisc.db.dbMgr;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import jvp.web.factoryObj;
import mgn.obj.images.imageBean;
import mgn.obj.usr.userBean;
import mgn.obj.usr.userObj;
import mgn.web.mgr.calObjMgr;
import mgn.web.mgr.imageDisplayObjMgr;
import mgn.web.mgr.usrObjMgr;
import mgn.web.mgr.videoObjMgr;
import obj.db.v1.dbMgrInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
@ManagedBean
@SessionScoped
public class mgnMgrObj implements Serializable, mgnMgrObjInterface ,mgnMenuMgrObjInterface{
    // =================================================
    private String 
            panelSount = "XXX",
            panelWest = "./menu.xhtml",
            panelCenter = getCalObjMgr().getURL(); //";//videoObjMgr.URL;
    // =================================================
    private boolean reload_data = true;
    private List<String> images;
    private List<imageBean> bean;
    private dbMgr dbMgr;
    private usrObjMgr usrObjMgr;
    private imageDisplayObjMgr imageDisplay_V2;
    private videoObjMgr videoObjMgr_v2;
    private mgnMenuMgrObj mgnMenuMgrObj;
    private calObjMgr calObjMgr;
    private userBean user;
    public mgnMgrObj(){
        
    }
    
    public void newUserLogin(String Email){
        user = userObj.select(Email, dbMgr);
    }
    public String getImageNameXXX(){
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath("/spinneyhill"));
        result.mkdirs();
        System.err.println(result.getAbsolutePath());
        System.err.println(result.getPath());
        System.err.println(extContext.getRealPath("spinneyhill"));
        return result.getPath()+"/img1001.jpg";
    }
    public List<String> getImagesXXX(){
         ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
         File result = new File(extContext.getRealPath("image"));
         result = new File(extContext.getRealPath("/"));
        System.out.println("TESTing");
            images = new ArrayList<String>();
            //
            images.add("img001.jpg");
            images.add("img002.jpg");
            images.add("img003.jpg");
        return images;
    }

    /**
     * @return the bean
     */
    public List<imageBean> getBeanXXX() {
        bean = new ArrayList<imageBean>();
        bean.add(new imageBean("img001.jpg"));
        bean.add(new imageBean("img002.jpg"));
        bean.add(new imageBean("img003.jpg"));
        return bean;
    }

    @Override
    public  dbMgrInterface getObj(){
        if (dbMgr == null){
            dbMgr = new dbMgr("jdbc/mgn", dbMgr.typeMySql);
        }
        return dbMgr;
    }

    
    public imageDisplayObjMgr getMgrImage() {
        if ( imageDisplay_V2 == null) imageDisplay_V2 = new imageDisplayObjMgr(this);
        return imageDisplay_V2;
    }
    
    @Override
    public  boolean reloadData() {
        return reload_data;
    }

    /**
     * @return the panelLeft
     */
    public String getPanelWest() {
        return panelWest;
    }

    /**
     * @return the panelCenter
     */
    public String getPanelCenter() {
        return panelCenter;
    }
  
    @Override
    public void forward() {
        factoryObj.FacesContextForward("mgn.xhtml", FacesContext.getCurrentInstance());
    }
    @Override
     public void forwardCntr(String center){
         panelCenter = center;
         forward();
     }
    /**
     * @return the videoObjMgr
     */
    
   
    public videoObjMgr getMgrVideo() {
        if (videoObjMgr_v2 == null) videoObjMgr_v2 = new videoObjMgr(this);
        return videoObjMgr_v2;
    }

    /**
     * @return the mgnMenuMgrObj
     */
    public mgnMenuMgrObj getMgnMenuMgrObj() {
        if (mgnMenuMgrObj == null) mgnMenuMgrObj = new mgnMenuMgrObj(this,this);
        return mgnMenuMgrObj;
    }

    @Override
    public videoObjMgr getVideo() {
        return getMgrVideo();
    }

    @Override
    public imageDisplayObjMgr getImage() {
        return this.getMgrImage();
    }

    /**
     * @return the usrObjMgr
     */
    @Override
    public usrObjMgr getUsrObjMgr() {
        if (usrObjMgr == null) usrObjMgr = new usrObjMgr(this);
        return usrObjMgr;
    }

    /**
     * @return the user
     */
    @Override
    public userBean getUser() {
        if (user == null) {
            user = new userBean();
        }
        return user;
    }

    /**
     * @return the calObjMgr
     */
    public calObjMgr getCalObjMgr() {
        if (calObjMgr == null) calObjMgr = new calObjMgr(this);
        return calObjMgr;
    }
}

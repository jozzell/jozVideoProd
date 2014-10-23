/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.mgr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import mgn.obj.dept.deptObj;
import mgn.obj.lookup.mgnLookupBean;
import mgn.obj.lookupSys.mgnSysLookupObj;
import mgn.obj.usr.userBean;
import mgn.obj.usr.userObj;
import jvp.web.factoryObj;
import mgn.web.model.userBeanModel;

/**
 *
 * @author lmeans
 */
public class usrObjMgr implements Serializable, mgnInterface{
    private userBean userBean;
    private mgnMgrObjInterface iface;
    private List<mgnLookupBean> sysLookup;
    private List<String> dept;
    private String msg = null;
    private userBeanModel userBeanModel;
    private int picked=-20;
    private boolean maintScren = true;
    public static final String 
            //maintUserResetPasswordChgMe
            passwdChgme = "./maintenance/maintUserResetPasswordChgMe.xhtml",
            passwd = "./maintenance/maintUserResetPassword.xhtml",
            brwUser = "./maintenance/maintUserEditBrw.xhtml",
            adduser = "./maintenance/maintUserAdd.xhtml",
            edituser = "./maintenance/maintUserEdit.xhtml";
    public usrObjMgr(mgnMgrObjInterface i){
        iface = i;
    }
    // ========================================================
    @Override
    public String getURL() {
        return brwUser;
    }

    @Override
    public void cleanup() {
       userBean = null;
        if (sysLookup != null) sysLookup.clear();
        sysLookup = null;
        if (dept != null) dept.clear();
        dept = null;
        userBeanModel = null;
    }
    // ========================================================
    public void setUserMaint(){
        maintScren = true;
    }
    public void cancel(){
        userBeanModel = null;
        if (maintScren){
            iface.forwardCntr(brwUser);
        } else {
            
        }
        
    } 
    public void editUser(){
        userBean =  (userBean) factoryObj.accessBeanFromFacesContext(userBeanModel.modelName, FacesContext.getCurrentInstance());
        if (userBean == null){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Nothing Was Selected"));
        } else {
            
            dept = deptObj.getDept(userBean.getCustId(), iface.getObj());
            iface.forwardCntr(edituser);
        }
    }
    public void addUser(){
        userBean = new userBean();
        dept = null;
        iface.forwardCntr(adduser);
    }
    
    public void savePassword(){
      msg = chkPassword();
      if (msg != null){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", msg));
      } else {
          userObj.updatePassword(userBean.getCustId(), userBean.getUserPass(), iface.getObj());
          cancel();
      }
    }
    public void resetPassword(){
         userBean =  (userBean) factoryObj.accessBeanFromFacesContext(userBeanModel.modelName, FacesContext.getCurrentInstance());
        if (userBean == null){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Nothing Was Selected"));
        } else if (userBean.getCustId() == iface.getUser().getCustId()) {
            iface.forwardCntr(passwd);
        } else {
            userBean.setUserPass("changeme");
            userBean.setUserPassChk("changeme");
            iface.forwardCntr(passwdChgme);
        }
    }
    public  void save(){
        if (chkBean()) {
            
            userObj.update(userBean, iface.getObj());
            if (userBean.getCustId() == 0  ){
                userBean = userObj.select(userBean.getEMail(), iface.getObj());
                
            }
            int id = userBean.getCustId();
            deptObj.deleteUserDept(id, iface.getObj());
            for (String x :dept){
                deptObj.insertUserDept(id, Integer.parseInt(x), 0, iface.getObj());
            }
            cancel();
           
        }
    }
    public void deptChng2(){
        
        userBeanModel = null; // new userBeanModel(userObj.selectByDept(picked, iface.getObj()));
    }
    public String getMsgError(){
        return msg;
    }
    private boolean chkBean(){
      msg = chkFirstName();
      if (msg != null){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", msg));
      }
      
      return (msg == null);
    }
    private String chkPassword(){
            if (userBean.getUserPass()== null || userBean.getUserPass().trim().length() == 0) return "Missing Password";
            if (userBean.getUserPassChk()== null || userBean.getUserPassChk().trim().length() == 0) return "Password verification Failed";
            if (!userBean.getUserPassChk().equals(userBean.getUserPass())) return "Password verification Failed";
            return null;
      }
    private String chkFirstName(){
        if (userBean.getFirstName() == null || userBean.getFirstName().trim().length() == 0) return "Missing First Name";
        if (userBean.getLastName() == null || userBean.getLastName().trim().length() == 0) return "Missing Last Name";
        if ( getDept().size() <= 0) return "Missing Department Selection";
        
        if (userBean.getCustId() <= 0){
            if (userBean.getUserPass()== null || userBean.getUserPass().trim().length() == 0) return "Missing Password";
            if (userBean.getUserPassChk()== null || userBean.getUserPassChk().trim().length() == 0) return "Password verification Failed";
            if (!userBean.getUserPassChk().equals(userBean.getUserPass())) return "Password verification Failed";
            
            if (userBean.getEMail() == null || userBean.getEMail().trim().length() == 0) return "Missing E-Mail";
            if (userBean.getEMailChk() == null || userBean.getEMailChk().trim().length() == 0) return "E-Mail verification Failed";
            if (!userBean.getEMail().equals(userBean.getEMailChk()))return "E-Mail verification Failed";
            
            
            userBean x = userObj.select(userBean.getEMail(), iface.getObj());
            if (x == null || x.getCustId() == 0) {
                return null;
            } else {
                return "Warning, E-Mail all ready exist";
            }
        }
        
        return null;
    }
    /**
     * @return the userBean
     */
    public userBean getUserBean() {
        if (userBean == null) userBean = new userBean();
        return userBean;
    }

    /**
     * @return the sysLookup
     */
    public List<mgnLookupBean> getSysLookup() {
        if (sysLookup == null){
            sysLookup = mgnSysLookupObj.getSysLookupList(2, iface.getObj());
            //if (sysLookup.size() > 0) this.picked = sysLookup.get(0).getLookupId();
        }
        return sysLookup;
    }

    /**
     * @return the dept
     */
    public List<String> getDept() {
        if (dept == null || dept.isEmpty()) {
            dept = new ArrayList<String>();
            dept.add(""+picked);
        }
        return dept;
    }

    /**
     * @param dept the dept to set
     */
    public void setDept(List<String> dept) {
        this.dept = dept;
    }

    /**
     * @return the userBeanModel
     */
    public userBeanModel getUserBeanModel() {
        if (userBeanModel == null) {
            userBeanModel = new userBeanModel(userObj.selectByDept(picked, iface.getObj()));
        }
        return userBeanModel;
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

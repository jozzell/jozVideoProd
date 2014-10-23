/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.usr;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "userBean")
public class userBean  implements  Serializable{
         private int custId;
         private int accessLvl = -1;
         private String accessLvlDesc;
         private String firstName;
         private String lastName;
         private String addr1;
         private String addr2;
         private String city;
         private String state;
         private String hmPhone;
         private String wkPhone;
         private String wkExt;
         private String zip;
         private String EMail,EMailChk;
         private String userPass,userPassChk;
         private String subjectText;
         private String subjectTody;

    /**
     * @return the custId
     */
    
    
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * @return the accessLvl
     */
    public int getAccessLvl() {
        return accessLvl;
    }

    /**
     * @param accessLvl the accessLvl to set
     */
    public void setAccessLvl(int accessLvl) {
        this.accessLvl = accessLvl;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the addr1
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * @param addr1 the addr1 to set
     */
    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    /**
     * @return the addr2
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * @param addr2 the addr2 to set
     */
    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the hmPhone
     */
    public String getHmPhone() {
        return hmPhone;
    }

    /**
     * @param hmPhone the hmPhone to set
     */
    public void setHmPhone(String hmPhone) {
        this.hmPhone = hmPhone;
    }

    /**
     * @return the wkPhone
     */
    public String getWkPhone() {
        return wkPhone;
    }

    /**
     * @param wkPhone the wkPhone to set
     */
    public void setWkPhone(String wkPhone) {
        this.wkPhone = wkPhone;
    }

    /**
     * @return the wkExt
     */
    public String getWkExt() {
        return wkExt;
    }

    /**
     * @param wkExt the wkExt to set
     */
    public void setWkExt(String wkExt) {
        this.wkExt = wkExt;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

   

    /**
     * @return the userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass the userPass to set
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return the subjectText
     */
    public String getSubjectText() {
        return subjectText;
    }

    /**
     * @param subjectText the subjectText to set
     */
    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    /**
     * @return the subjectTody
     */
    public String getSubjectTody() {
        return subjectTody;
    }

    /**
     * @param subjectTody the subjectTody to set
     */
    public void setSubjectTody(String subjectTody) {
        this.subjectTody = subjectTody;
    }

    /**
     * @return the EMail
     */
    public String getEMail() {
        return EMail;
    }

    /**
     * @param EMail the EMail to set
     */
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    /**
     * @return the EMailChk
     */
    public String getEMailChk() {
        return EMailChk;
    }

    /**
     * @param EMailChk the EMailChk to set
     */
    public void setEMailChk(String EMailChk) {
        this.EMailChk = EMailChk;
    }

    /**
     * @return the userPassChk
     */
    public String getUserPassChk() {
        return userPassChk;
    }

    /**
     * @param userPassChk the userPassChk to set
     */
    public void setUserPassChk(String userPassChk) {
        this.userPassChk = userPassChk;
    }

    /**
     * @return the accessLvlDesc
     */
    public String getAccessLvlDesc() {
        return accessLvlDesc;
    }

    /**
     * @param accessLvlDesc the accessLvlDesc to set
     */
    public void setAccessLvlDesc(String accessLvlDesc) {
        this.accessLvlDesc = accessLvlDesc;
    }

    
}

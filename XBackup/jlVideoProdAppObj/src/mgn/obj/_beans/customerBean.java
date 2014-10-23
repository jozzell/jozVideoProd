/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj._beans;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class customerBean implements Serializable{

    private int custId;
    private String email_key;
    private String keyStr;
    private String firstName;
    private String lastName;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String hmPhone;
    private String wkPhone;
    private String wkExt;
    private String cell;
    private String zip;
    private String eMail;
    private int dbId;
    private String userName;
    private String userPass;
    private int vendorId;
    private int accessLevel=-99;
    private int sponsorLinkId;

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
     * @return the email_key
     */
    public String getEmail_key() {
        return email_key;
    }

    /**
     * @param email_key the email_key to set
     */
    public void setEmail_key(String email_key) {
        this.email_key = email_key;
    }

    /**
     * @return the keyStr
     */
    public String getKeyStr() {
        return keyStr;
    }

    /**
     * @param keyStr the keyStr to set
     */
    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
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
     * @return the cell
     */
    public String getCell() {
        return cell;
    }

    /**
     * @param cell the cell to set
     */
    public void setCell(String cell) {
        this.cell = cell;
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
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * @return the dbId
     */
    public int getDbId() {
        return dbId;
    }

    /**
     * @param dbId the dbId to set
     */
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the accessLevel
     */
    public int getAccessLevel() {
        return accessLevel;
    }

    /**
     * @param accessLevel the accessLevel to set
     */
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * @return the sponsorLinkId
     */
    public int getSponsorLinkId() {
        return sponsorLinkId;
    }

    /**
     * @param sponsorLinkId the sponsorLinkId to set
     */
    public void setSponsorLinkId(int sponsorLinkId) {
        this.sponsorLinkId = sponsorLinkId;
    }
}

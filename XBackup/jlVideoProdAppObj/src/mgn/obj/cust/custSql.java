/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

/**
 *
 * @author lmeans
 */
public class custSql {
  private static final String 
         sqlCust =
            " select cust_id ,email_key ,keyStr ,FIRST_NAME , LAST_NAME, ADDR1 , "
            + " ADDR2 , CITY, STATE,HM_PHONE , WK_PHONE , WK_EXT ,ZIP , "
            + " EMAIL ,dbId ,	user_name ,user_pass ,	vendor_id ,access_lvl  ,   SPONSOR_LINK_ID"
            + " From mgnCUSTOMER ";
    public static final String  
           
            sqlSelectCustChk =
            " select max(cust_id) from mgnCUSTOMER where EMAIL = ? ",
            sqlSelectByCustID =
            sqlCust +" where cust_id = ?",
            sqlUpdateCust =
            " update mgnCUSTOMER set "
            + " email_key =?,keyStr =? ,FIRST_NAME  =?, LAST_NAME =?, ADDR1 =? , "
            + " ADDR2  =?, CITY =?, STATE =?,HM_PHONE  =?, WK_PHONE  =?, WK_EXT  =?,ZIP  =?, "
            + " EMAIL  =?,dbId  =?,	user_name  =?,user_pass =? ,	vendor_id =? ,access_lvl =?  ,   SPONSOR_LINK_ID =? "
            + " where CUST_ID = ?",
            sqlInsertCust =
            " insert into mgn_user "
            + "    (FIRST_NAME , LAST_NAME, ADDR1 , "
            + " ADDR2 , CITY, STATE,HM_PHONE , WK_PHONE , WK_EXT ,ZIP , "
            + " EMAIL,	user_pass ,	access_lvl  ) "
            + "    values     (?,?,?,?,?,?,?,?,?,?,?,?,?)";
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cust;

import java.io.Serializable;
import java.sql.SQLException;
import mgn.obj._beans.customerBean;
import mgn.obj.mgrObj;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class custObj  implements Serializable{
    public static final Logger logger = (Logger) LoggerFactory.getLogger(custObj.class);
    
    public static int createUser(customerBean b, dbMgrInterface db) {
        b.seteMail(b.geteMail().toLowerCase());
        try {
            if (b.getCustId() == 0) {
                db.updateDatabase(custSql.sqlInsertCust, getObject(b, false));
                return getCustID(b.geteMail(),db);
            } else {
                db.updateDatabase(custSql.sqlUpdateCust, getObject(b, true));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b.getCustId();
    }
    public static int getCustID(String email,dbMgrInterface db){
        int i = -1;
        CachedRowSet r;
        try {
            r = db.getCachedRowSet(custSql.sqlSelectCustChk, new Object[]{email});
            while(r.next()){
                i = r.getInt(1);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return i;
    }
    public static customerBean getcustomerBean(int id,dbMgrInterface db){
        customerBean b = null;
        CachedRowSet r;
         try {
            r = db.getCachedRowSet(custSql.sqlSelectByCustID, new Object[]{id});
            while(r.next()){
                b = getcustomerBean(r);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private static customerBean getcustomerBean(CachedRowSet r){
        customerBean b = new customerBean();
        try {
            b.setCustId(r.getInt(1)); 
            b.setEmail_key(r.getString(2)); //email_key ,
            b.setKeyStr(r.getString(3));//keyStr ,
            b.setFirstName(r.getString(4)); //FIRST_NAME , 
            b.setLastName(r.getString(5)); //LAST_NAME, 
            b.setAddr1(r.getString(6));// ADDR1 , "
            b.setAddr2(r.getString(7)); //   + " ADDR2 , "
            b.setCity(r.getString(8));//            + "CITY, "
            b.setState(r.getString(9));    //        + "STATE,"
            b.setHmPhone(r.getString(10));    //        + "HM_PHONE , "
            b.setWkPhone(r.getString(11));          //  + "WK_PHONE , "
            b.setWkExt(r.getString(12));       //     + "WK_EXT ,"
            b.setZip(r.getString(13));  //          + "ZIP , "
            b.seteMail(r.getString(14));   // + " EMAIL ,"
            b.setDbId(r.getInt(15));       //     + "dbId ,	"
            b.setUserName(r.getString(16));  //          + "user_name ,"
            b.setAccessLevel(r.getInt(17));//u            + "user_pass ,	"
            b.setVendorId(r.getInt(18));  //          + "vendor_id ,"
            b.setAccessLevel(r.getInt(19));    //        + "access_lvl  ,   "
            b.setSponsorLinkId(r.getInt(20)); //           + "SPONSOR_LINK_ID
           
        } catch (SQLException ex) {
           logger.error(ex.toString());
        }
         return b;
    }
    public static Object[] getObject(customerBean b,boolean update){
        return new Object[]{
           
            b.getFirstName() , 
            b.getLastName(), 
            b.getAddr1() , 
            b.getAddr2() , 
            b.getCity(), 
            b.getState(),
            b.getHmPhone() , 
            b.getWkPhone() , 
            b.getWkExt() ,
            b.getZip() ,
             b.geteMail().toLowerCase() ,
            b.getUserPass() ,	
            b.getAccessLevel() ,   
           
            update ? b.getCustId() : null
        };
    }
}

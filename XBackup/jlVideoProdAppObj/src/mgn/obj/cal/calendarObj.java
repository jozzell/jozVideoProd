/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import cv.bisc.db.NULL_DATE;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class calendarObj implements Serializable{
    public static final Logger logger = (Logger) LoggerFactory.getLogger(calendarObj.class);
    
    public static void saveCalBean(calendarBean b,dbMgrInterface db){
        try {
            
            db.updateDatabase(
                    b.getCalId() == 0 ? calendarSql.calInsert : calendarSql.calUpdate, 
                    getObject(b));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    
    private static calendarBean getCalenderBean(CachedRowSet r){
        calendarBean b = null;
        try {
            b = new calendarBean();
            b.setCalId(r.getInt(1));
            b.setCalRollupId(r.getInt(2));
            b.setCalDesc(r.getString(3));
            b.setCalType(r.getInt(4));
            b.setStartDate(r.getDate(5));
            b.setEnddate(r.getDate(6));
            b.setUserId(r.getInt(7));
            b.setDeptId(r.getInt(8));
            b.setLookupId(r.getInt(9));
            b.setLookupFlag(r.getInt(10));
            b.setSubjectText(r.getString(11));
            b.setSubjectBody((String)r.getObject(12));
            
            
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private static Object[] getObject(calendarBean b){

            return new Object[]{
                b.getCalRollupId(),
                b.getCalDesc() == null ? "":b.getCalDesc(),
                b.getCalType(),
                b.getStartDate(),
                b.getEnddate(),
                b.getUserId(),
                b.getDeptId(),
                b.getLookupId(),
                b.getLookupFlag(),
                b.getSubjectText() == null ? "": b.getSubjectText(),
                b.getSubjectBody() == null ? "": b.getSubjectBody(),
                
                b.getCalId() <= 0 ? null :b.getCalId()
                  
            };
       
       
       
    }
    /// ============================================================
    
}

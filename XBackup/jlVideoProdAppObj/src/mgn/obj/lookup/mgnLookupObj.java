/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookup;


import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class mgnLookupObj implements Serializable{
    public static final Logger logger = (Logger) LoggerFactory.getLogger(mgnLookupObj.class);
    public static List<mgnLookupBean> getLookupList(int type,dbMgrInterface db){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(mgnLookupSql.sqlLookupByType, new Object[]{type});
            while(r.next()){
                list.add(getlookupBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return list;
    }
    public static mgnLookupBean getlookupBean(CachedRowSet r){
        mgnLookupBean b = new mgnLookupBean();
        try {
            b.setLookupId(r.getInt(1));
            b.setLookupRollupId(r.getInt(2));
            b.setLookupType(r.getInt(3));
            b.setLookupDesc(r.getString(4));
            b.setLookupFlag(r.getInt(5));
            b.setSubjectText(r.getString(6));
            b.setSubjectBody((String)r.getObject(7));
        } catch (SQLException ex) {
           logger.error(ex.toString());
        }
        
        return b;
    }
}

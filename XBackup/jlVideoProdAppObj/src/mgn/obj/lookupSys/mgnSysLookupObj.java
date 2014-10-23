/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookupSys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mgn.obj.lookup.mgnLookupBean;
import mgn.obj.lookup.mgnLookupObj;

import mgn.obj.lookup.mgnLookupSql;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class mgnSysLookupObj implements Serializable{
    public static final Logger logger = (Logger) LoggerFactory.getLogger(mgnSysLookupObj.class);
    public static List<mgnLookupBean> getSysLookupList(int type,dbMgrInterface db){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(mgnSysLookupSql.sqlSysLookupByType, new Object[]{type});
            while(r.next()){
                list.add(mgnLookupObj.getlookupBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return list;
    }
    
}

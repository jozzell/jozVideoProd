/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mgn.obj.lookup.mgnLookupBean;
import obj.db.v1.dbMgrInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class imgObj implements Serializable{
    public static final Logger logger = (Logger) LoggerFactory.getLogger(imgObj.class);
    
   
    public static List<mgnLookupBean> selectImageBatch(int id,dbMgrInterface db){
        return selectImageBatch(imgSql.sqlSelectImageBatchList,db, new Object[]{id});
    }
    public static List<mgnLookupBean> selectImageBatch(String sql,dbMgrInterface db,Object[] obj){
        List<mgnLookupBean> list = new ArrayList<mgnLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                mgnLookupBean l = new mgnLookupBean();
                l.setLookupId(r.getInt(1));
                l.setLookupDesc(r.getString(2));
                l.setSubjectBody(r.getString(3));
                l.setSubjectText(r.getString(4));
                l.setLookupRollupId(r.getInt(5));
                list.add(l);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
    }
    public static List<imgBean> selectImageList(dbMgrInterface db){
        return selectImageList(imgSql.sqlSelectImagesDefault,db,null);
    }
    public static List<imgBean> selectImageList(int dirId,dbMgrInterface db){
        return selectImageList(imgSql.sqlSelectImages,db,new Object[]{dirId});
    }
    public static List<imgBean> selectImageList(String sql,dbMgrInterface db,Object[] obj){
        List<imgBean> list = new ArrayList<imgBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                imgBean l = new imgBean();
                l.setFileId(r.getInt(1));
                l.setFileName(r.getString(2));
                l.setFileDesc(r.getString(3));
                l.setFileText((String)r.getObject(4));
                l.setFileType(r.getInt(5));
                l.setDirId(r.getInt(6));
                l.setDirName(r.getString(7));
                l.setSysDesc(r.getString(8));
                l.setRootPath(r.getString(9));
                
                list.add(l);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return list;
    }
}

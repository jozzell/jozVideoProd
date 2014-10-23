/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

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
public class videoObj {
    public static final Logger logger = (Logger) LoggerFactory.getLogger(videoObj.class);
    
    public static List<videoBean> getVideoBeanList(int type,dbMgrInterface db){
        return getVideoBeanList(videoSql.sqlSelectVideoByType,new Object[]{type},db);
    }
    private static List<videoBean> getVideoBeanList(String sql,Object[] obj,dbMgrInterface db){
        List<videoBean> l = new ArrayList<videoBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql, obj);
            while(r.next()){
                l.add(getVideoBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return l;
    }
    public static videoBean getVideoBean(CachedRowSet r){
        videoBean b = new videoBean();
        try {
            
            b.setVideoId(r.getInt(1));//video_id integer    NOT NULL   PRIMARY KEY AUTO_INCREMENT,
            b.setVideoType(r.getInt(2));	//video_type  integer,
            b.setVideoDesc(r.getString(3));//video_desc  VARCHAR(256),
            b.setVideoValue(r.getString(4));//video_value  VARCHAR(60),
            b.setVideoWidth(r.getInt(5));//        video_width
            b.setVideoHeight(r.getInt(6));//                    video_height integer,
               //b.setVideoPlayer(r.getString(7));//video_player
            b.setLookupId(r.getInt(8));
            b.setSysId(r.getInt(9));
            b.setLookupFlag(r.getInt(10));
            b.setSubjectText(r.getString(11));
            b.setSubjectBody((String)r.getObject(12));
            b.setDispyVideoType(r.getString(13));
            b.setRootURL(r.getString(14));
            b.setVideoPlayer(r.getString(15));
                
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
}
/*
static String 	FLASH 
static String 	PDF 
static String 	QUICKTIME 
static String 	REAL 
static String 	WINDOWS 

*/
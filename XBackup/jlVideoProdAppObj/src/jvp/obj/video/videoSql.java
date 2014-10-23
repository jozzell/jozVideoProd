/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

/**
 *
 * @author lmeans
 */
public class videoSql {
    private static final String sql =
    " SELECT  v.video_id,v.video_type,v.video_desc,v.video_value,v.video_width, "+
    " v.video_height,v.video_player,v.lookup_id,v.sys_id,v.lookup_flag,v.subject_text, "+
    " v.subject_body,l.sys_desc,l.subject_text,l.txt_col_01 "+
    " FROM jvp_video v,jvp_lookup_sys l "+
    " where l.sys_id = v.sys_id ";
    public static final String
            sqlSelectVideoByType = sql+" and v.video_type = ? order by v.lookup_flag desc,v.video_desc";
}

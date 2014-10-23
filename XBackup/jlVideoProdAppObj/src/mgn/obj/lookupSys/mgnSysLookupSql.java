/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.lookupSys;

/**
 *
 * @author lmeans
 */
public class mgnSysLookupSql {
    private static final String  sqlSys = 
            " SELECT s.sys_id,s.sys_rollup_id,s.sys_type,s.sys_desc,s.lookup_flag, "+
            " s.subject_text,s.subject_body "+
            " FROM mgn_lookup_sys s ";
    public static final String 
            sqlSysLookupByType = sqlSys+" where s.sys_type = ? order by upper(s.sys_desc)";
}

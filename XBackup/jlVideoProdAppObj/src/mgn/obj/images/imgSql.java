/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;

/**
 *
 * @author lmeans
 */
public class imgSql {
    private static final String
     sqlBatch =
             " SELECT l.lookup_id,l.lookup_desc,l.subject_text ,d.dir_name,d.dir_id "+
            " FROM mgn_lookup l,mgn_files_dir d "+
            " where l.lookup_id = d.dir_group ",
        
    sql =   " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id , "+
            " d.dir_name,s.sys_desc,s.subject_text path "+
            " FROM mgn_files f,mgn_files_dir d,mgn_lookup_sys s "+
            " where d.dir_id = f.dir_id and s.sys_id =  f.file_type ";
        
    public static final String
        sqlSelectImagesDefault = sql+" and f.file_id in (SELECT max(file_id) FROM mgn_files group by dir_id) order by 2 ",
        sqlSelectImages = sql +" and f.dir_id = ? ",
        sqlSelectImageBatchList = sqlBatch+
            " and l.lookup_type = -10 and lookup_id = ? ";
}
/*

 sqlX =    " SELECT f.file_id,f.file_name,f.file_desc,f.file_text,f.file_type,f.dir_id "+
            " FROM mgn_files f  ",

*/
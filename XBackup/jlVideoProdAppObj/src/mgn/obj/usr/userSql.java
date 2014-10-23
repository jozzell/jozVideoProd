/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.usr;

/**
 *
 * @author lmeans
 */
public class userSql {
    private static final String xyx_002 = "";
     private static final String
            sql =
           " select c.user_id,c.FIRST_NAME,c.LAST_NAME,c.ADDR1,c.ADDR2,c.CITY,c.STATE,c.HM_PHONE,c.WK_PHONE,c.WK_EXT, "+
           " c.ZIP,c.EMAIL,c.user_pass,c.subject_text,c.subject_body,c.access_lvl, "+
           " case c.access_lvl "+
            " when -1 then 'New User' "+
            " when 1 then 'Super User' "+
            " when 2 then 'Administrator' "+
             
            " when 9 then 'System Administrator' 	else 'Unknow' end "+
           " from mgn_user c  "
            ;
    public static final String
            select = sql+" order by c.LAST_NAME,c.FIRST_NAME",
            select_byDept = sql+" where c.user_id in (select x.user_id from mgn_user_dept x where c.user_id = x.user_id and dept_id = ?)",
            select_eMail = sql+" where c.EMAIL = ?",
            select_login = sql+" where c.EMAIL = ? and c.user_pass = ?",
            select_custID = sql+" where c.user_id = ?",
            
            insert = "INSERT INTO mgn_user ( "+
                "FIRST_NAME,LAST_NAME,ADDR1,ADDR2,CITY,STATE,HM_PHONE,WK_PHONE,WK_EXT, "+
                " ZIP,EMAIL,user_pass,subject_text,subject_body,access_lvl) "+
                " VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",            
             updatePassword = 
                " UPDATE mgn_user SET user_pass = ? WHERE user_id= ? ",
            update = 
            " UPDATE mgn_user SET FIRST_NAME = ?,LAST_NAME = ?,ADDR1 = ?,ADDR2 = ?, "+
            " CITY = ?,STATE = ?,HM_PHONE = ?,WK_PHONE = ?,WK_EXT =?,ZIP = ?, "+
            " subject_text = ?,subject_body = ?,access_lvl = ? WHERE user_id= ? ";


}

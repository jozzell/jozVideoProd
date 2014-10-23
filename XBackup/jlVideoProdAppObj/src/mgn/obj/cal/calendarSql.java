/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

/**
 *
 * @author lmeans
 */
public class calendarSql {
    private static String tes63t="skjdfksd",
            sqlSelect =
            " select c.cal_id,c.cal_rollup_id,c.cal_desc,c.cal_type,c.startDate,c.enddate,c.user_id, "+
            " c.dept_id, c.lookup_id,c.lookup_flag,c.subject_text,c.subject_body,moddate "+
            " from mgn_calendar c";
    public static String getCalSelectBydate(String dept){
        return sqlSelect+" where c.startDate >= ? and c.startDate <= ? and c.cal_type = ? and c.dept_id in ("+dept+")";
    }
    public static String getCalSelectBydateNext(String dept){
        return sqlSelect+" where c.startDate > ? and c.cal_type = ? and c.moddate >= ? and c.moddate <= ? and c.dept_id in ("+dept+")";
    }
    public static final String
    calSelectById = sqlSelect+" where c.cal_id= ?",
    calInsert =
           " INSERT INTO mgn_calendar "+
            " (cal_rollup_id,cal_desc,cal_type,startDate,enddate,user_id, "+
            " dept_id,lookup_id,lookup_flag,subject_text,subject_body) VALUES "+
            " (?,?,?,?,?,?,?,?,?,?,?)",
    calUpdate =
           " UPDATE mgn_calendar  SET, "+
            " cal_rollup_id = ?,cal_desc = ?,cal_type = ?, startDate = ?, "+
            " enddate = ?,user_id = ?,dept_id = ?,lookup_id = ?,lookup_flag = ?, "+
            " subject_text = ?,subject_body =  WHERE = cal_id = ? ",
            // ================================================================
    sqlCalSelect = 
    " select Cal_ID ,dept_id,CUST_ID ,	StartDate , enddate , 	short_desc, "+
	" contactName ,	Long_desc ,ADDR1 , ADDR2 ,  CITY , "+
        " STATE ,  ZIP ,  ZIP_PLUS , PHONE , FAX , "+
        " EMAIL ,	website ,access_lvl,access_dept  from  mgnCalendar "
            ;
    public static final String
      sqlCalInsert = 
          "  insert into  mgnCalendar (dept_id,CUST_ID ,	StartDate , enddate , 	short_desc, "+
	" contactName ,	Long_desc ,ADDR1 , ADDR2 ,  CITY ,STATE ,  ZIP ,  ZIP_PLUS , PHONE , FAX , "+
        " EMAIL ,website ,access_lvl,access_dept )" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
       sqlCalUpadte =
            " update mgnCalendar set "+
           " dept_id = ?,CUST_ID  = ?,	StartDate  = ?, enddate = ? , 	short_desc = ?, "+    
	" contactName  = ?,	Long_desc  = ?,ADDR1  = ?, ADDR2  = ?,  CITY  = ?,STATE  = ?,"+
         " ZIP  = ?,  ZIP_PLUS  = ?, PHONE  = ?, FAX  = ?, "+
        " EMAIL = ? ,website  = ?,access_lvl = ?,access_dept  = ? where Cal_ID = ?"
            ;
}

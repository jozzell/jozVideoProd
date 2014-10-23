/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.dept;

/**
 *
 * @author lmeans
 */
public class deptSql {

    public static final String 
            sqlDeptCustDel ="delete from mgn_user_dept where user_id = ?",
            sqlDeptCustInsert =" insert into mgn_user_dept (user_id ,dept_id,access_lvl ) values (?,?,?) ",
            sqlDeptCustSelect = "Select user_id ,dept_id,access_lvl from mgn_user_dept where user_id = ? ",
            
            sqlDeptCustUpdate =
            " update mgnCUSTOMERDept set access_lvl  = ? where CUST_ID = ? and Dept_ID = ? ",
            sqlDeptInsert =
            " insert into mgnDept "
            + " (CUST_ID,deptName ,deptDesc ,ADDR1,ADDR2,CITY,STATE ,ZIP ,ZIP_PLUS,PHONE,FAX,EMAIL,website ) "
            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?) ",
            sqlDeptUpdate =
            " update mgnDept set "
            + "  CUST_ID =?,deptName  =?,deptDesc  =?,ADDR1 =?,ADDR2 =?, "
            + " CITY =?,STATE  =?,ZIP  =?,ZIP_PLUS =?,PHONE =?,FAX =?,EMAIL =?,website =? "
            + " where Dept_ID = ? ";
}

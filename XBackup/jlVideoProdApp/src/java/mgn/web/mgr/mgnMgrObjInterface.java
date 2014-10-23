/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.mgr;
import mgn.obj.usr.userBean;
import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
public interface mgnMgrObjInterface {
    public abstract void forward();
    public abstract void forwardCntr(String center);
    public abstract dbMgrInterface getObj();
    public abstract boolean reloadData();
    public abstract userBean getUser();
}

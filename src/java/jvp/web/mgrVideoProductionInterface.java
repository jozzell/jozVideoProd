/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.web;

import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
public interface mgrVideoProductionInterface {
    public abstract void forward();
    public abstract void forwardCntr(String center);
    public abstract dbMgrInterface getObj();
}

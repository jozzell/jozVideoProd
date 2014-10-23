/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.mgr;

import java.io.Serializable;
import mgn.web.mgr.imageDisplayObjMgr;
import mgn.web.mgr.usrObjMgr;
import mgn.web.mgr.videoObjMgr;

/**
 *
 * @author lmeans
 */
public interface mgnMenuMgrObjInterface {
    public abstract videoObjMgr getVideo();
    public abstract imageDisplayObjMgr getImage();
    public abstract usrObjMgr getUsrObjMgr();
}

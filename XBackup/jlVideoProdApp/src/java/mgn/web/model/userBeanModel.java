/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import mgn.obj.usr.userBean;
import jvp.web.factoryObj;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author lmeans
 */
public class userBeanModel  extends ListDataModel<userBean> implements SelectableDataModel<userBean>, Serializable {
   public static final String modelName = "user-Bean-Model";
    public userBeanModel(){
        super();
    }
    public userBeanModel(List<userBean> list){
        super(list);
        
    }
    @Override
    public Object getRowKey(userBean t) {
        return t.getCustId();
    }

    @Override
    public userBean getRowData(String string) {
        long id = Long.parseLong(string);
        List<userBean> list = (List<userBean>) getWrappedData();  
        for (userBean list1 : list) {
           if (list1.getCustId() == id) {
               factoryObj.setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
               return list1;
           }
       }
        return null;
    }
    
}

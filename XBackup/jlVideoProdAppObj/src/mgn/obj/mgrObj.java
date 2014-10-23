/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class mgrObj implements Serializable{
    public static  String ck(String s) {
        return s == null ? "" : s;
    }
}

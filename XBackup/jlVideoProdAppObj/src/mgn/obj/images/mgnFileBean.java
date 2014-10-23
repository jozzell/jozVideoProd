/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "mgnFileBean")
public class mgnFileBean implements Serializable{
    private String file_name;
    private String file_desc;
    private String file_text;
    private int file_type;
    private int dir_id;

    /**
     * @return the file_name
     */
    public String getFile_name() {
        return file_name;
    }

    /**
     * @param file_name the file_name to set
     */
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    /**
     * @return the file_desc
     */
    public String getFile_desc() {
        return file_desc;
    }

    /**
     * @param file_desc the file_desc to set
     */
    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }

    /**
     * @return the file_text
     */
    public String getFile_text() {
        return file_text;
    }

    /**
     * @param file_text the file_text to set
     */
    public void setFile_text(String file_text) {
        this.file_text = file_text;
    }

    /**
     * @return the file_type
     */
    public int getFile_type() {
        return file_type;
    }

    /**
     * @param file_type the file_type to set
     */
    public void setFile_type(int file_type) {
        this.file_type = file_type;
    }

    /**
     * @return the dir_id
     */
    public int getDir_id() {
        return dir_id;
    }

    /**
     * @param dir_id the dir_id to set
     */
    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }
}

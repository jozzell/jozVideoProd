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
@ManagedBean(name = "imgBean")
public class imgBean   implements Serializable{
    private int fileId;
    private String fileName;
    private String fileDesc;
    private String fileText;
    private int fileType;
    private int dirId;
    private String dirName;
    private String sysDesc;
    private String rootPath;

    /**
     * @return the fileId
     */
    public int getFileId() {
        return fileId;
    }

    /**
     * @param fileId the fileId to set
     */
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileDesc
     */
    public String getFileDesc() {
        return fileDesc;
    }

    /**
     * @param fileDesc the fileDesc to set
     */
    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    /**
     * @return the fileText
     */
    public String getFileText() {
        return fileText;
    }

    /**
     * @param fileText the fileText to set
     */
    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

    /**
     * @return the fileType
     */
    public int getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    /**
     * @return the dirId
     */
    public int getDirId() {
        return dirId;
    }

    /**
     * @param dirId the dirId to set
     */
    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    /**
     * @return the dirDame
     */
    public String getDirName() {
        return dirName;
    }

    /**
     * @param dirDame the dirDame to set
     */
    public void setDirName(String dirDame) {
        this.dirName = dirDame;
    }

    /**
     * @return the sysDesc
     */
    public String getSysDesc() {
        return sysDesc;
    }

    /**
     * @param sysDesc the sysDesc to set
     */
    public void setSysDesc(String sysDesc) {
        this.sysDesc = sysDesc;
    }

    /**
     * @return the rootPath
     */
    public String getRootPath() {
        return rootPath;
    }

    /**
     * @param rootPath the rootPath to set
     */
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
    public String fileDirectory(){
        return rootPath+"/"+dirName+"/"+fileName;
    }
}

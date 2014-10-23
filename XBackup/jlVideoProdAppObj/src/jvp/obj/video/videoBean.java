package jvp.obj.video;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
@ManagedBean
public class videoBean  implements Serializable{
	private int videoId;
	private int videoType;
	private String videoDesc;
	private String videoValue;
	private int videoWidth;
	private int videoHeight;
	private String videoPlayer;
	private int lookupId;
	private int sysId;
	private int lookupFlag;
	private String subjectText;
	private String subjectBody; 
        private String dispyVideoType,rootURL;

       
    /**
     * @return the videoId
     */
    public videoBean(){
        
    }
    public String getVideoURL(){
           return rootURL+"/"+videoValue;
       }
    public int getVideoId() {
        return videoId;
    }

    /**
     * @param videoId the videoId to set
     */
    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    /**
     * @return the videoType
     */
    public int getVideoType() {
        return videoType;
    }

    /**
     * @param videoType the videoType to set
     */
    public void setVideoType(int videoType) {
        this.videoType = videoType;
    }

    /**
     * @return the videoDesc
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * @param videoDesc the videoDesc to set
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    /**
     * @return the video_value
     */
    public String getVideoValue() {
        return videoValue;
    }

    /**
     * @param video_value the video_value to set
     */
    public void setVideoValue(String video_value) {
        this.videoValue = video_value;
    }

    /**
     * @return the videoWidth
     */
    public int getVideoWidth() {
        return videoWidth;
    }

    /**
     * @param videoWidth the videoWidth to set
     */
    public void setVideoWidth(int videoWidth) {
        this.videoWidth = videoWidth;
    }

    /**
     * @return the videoHeight
     */
    public int getVideoHeight() {
        return videoHeight;
    }

    /**
     * @param videoHeight the videoHeight to set
     */
    public void setVideoHeight(int videoHeight) {
        this.videoHeight = videoHeight;
    }

    /**
     * @return the videoPlayer
     */
    public String getVideoPlayer() {
        return videoPlayer;
    }

    /**
     * @param videoPlayer the videoPlayer to set
     */
    public void setVideoPlayer(String videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    /**
     * @return the lookupId
     */
    public int getLookupId() {
        return lookupId;
    }

    /**
     * @param lookupId the lookupId to set
     */
    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
    }

    /**
     * @return the sysId
     */
    public int getSysId() {
        return sysId;
    }

    /**
     * @param sysId the sysId to set
     */
    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    /**
     * @return the lookupFlag
     */
    public int getLookupFlag() {
        return lookupFlag;
    }

    /**
     * @param lookupFlag the lookupFlag to set
     */
    public void setLookupFlag(int lookupFlag) {
        this.lookupFlag = lookupFlag;
    }

    /**
     * @return the subjectText
     */
    public String getSubjectText() {
        return subjectText;
    }

    /**
     * @param subjectText the subjectText to set
     */
    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    /**
     * @return the subjectBody
     */
    public String getSubjectBody() {
        return subjectBody;
    }

    /**
     * @param subjectBody the subjectBody to set
     */
    public void setSubjectBody(String subjectBody) {
        this.subjectBody = subjectBody;
    }

    /**
     * @return the dispyVideoType
     */
    public String getDispyVideoType() {
        return dispyVideoType;
    }

    /**
     * @param dispyVideoType the dispyVideoType to set
     */
    public void setDispyVideoType(String dispyVideoType) {
        this.dispyVideoType = dispyVideoType;
    }

    /**
     * @return the rootURL
     */
    public String getRootURL() {
        return rootURL;
    }

    /**
     * @param rootURL the rootURL to set
     */
    public void setRootURL(String rootURL) {
        this.rootURL = rootURL;
    }
}

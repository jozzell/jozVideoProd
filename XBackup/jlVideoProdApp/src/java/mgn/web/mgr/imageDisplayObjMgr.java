/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.web.mgr;


import mgn.obj.images.imgBean;
import mgn.obj.images.imgObj;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mgn.obj.lookup.mgnLookupBean;
import mgn.obj.lookup.mgnLookupObj;
import mgn.obj.lookup.mgnVar;



        
/**
 *
 * @author lmeans
 */

public class imageDisplayObjMgr implements Serializable, mgnInterface{
    private List<mgnLookupBean> batch,batchList;
    private List<imgBean> imngList;
    private int batchPicked,batchListPick;
    private mgnMgrObjInterface iface;
    public imageDisplayObjMgr(mgnMgrObjInterface i){
        iface = i;
    }
     @Override
    public String getURL() {
       return "./images/viewImages.xhtml";
    }

    @Override
    public void cleanup() {
        if (batch != null) batch.clear();
        if (batchList != null) batchList.clear();
        if (imngList != null) imngList.clear();
        batch = null;
        batchList = null;
        imngList = null;
    }

    public void viewImages(){
        if (batchListPick <= 0){
            imngList =  imgObj.selectImageList(iface.getObj());
        } else {
            imngList =  imgObj.selectImageList(batchListPick,iface.getObj());
        }
        iface.forward();
        
        
    }
    public void batchChng2(){ 
        batchList = imgObj.selectImageBatch(batchPicked, iface.getObj());
        
        //if (batchList == null || batchList.isEmpty()){
        //    imngList = null;
        //} else {
        //    int i = batchList.get(0).getLookupRollupId();
        //    imngList =  imgObj.selectImageList(i,iface.getObj());
        //    System.err.println(batchListPick+""+i);
       // }
       // System.err.println(batchListPick);
        
    }
    public List<mgnLookupBean> batch() {
        
        if (batch == null || iface.reloadData()){
            batch = mgnLookupObj.getLookupList(mgnVar.sysId_SpinneyHillImageBatch, iface.getObj());
        }
        return batch;
    }

    /**
     * @return the batchList
     */
    public List<mgnLookupBean> batchList() {
        if (batchList == null || batchList.isEmpty()) {
            batchList = new ArrayList<mgnLookupBean>();
        }
        return batchList;
    }
/**
     * @return the imngList
     */
    public List<imgBean> imgList() {
        if (imngList == null){
            imngList = imgObj.selectImageList(iface.getObj());
        }
        return imngList;
    }
    /**
     * @return the batchPicked
     */
    public int getBatchPicked() {
        return batchPicked;
    }

    /**
     * @param batchPicked the batchPicked to set
     */
    public void setBatchPicked(int batchPicked) {
        this.batchPicked = batchPicked;
    }

    /**
     * @return the batchListPick
     */
    public int getBatchListPick() {
        return batchListPick;
    }

    /**
     * @param batchListPick the batchListPick to set
     */
    public void setBatchListPick(int batchListPick) {
        this.batchListPick = batchListPick;
    }

   
    
}

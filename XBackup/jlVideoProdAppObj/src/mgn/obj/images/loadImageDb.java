/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.images;

import java.io.File;
import java.io.Serializable;
import obj.db.v1.dbMgrInterface;

/**
 *
 * @author lmeans
 */
public class loadImageDb implements Serializable{
    final String imgInsert = " INSERT INTO mgn_files (file_name,file_desc,file_text,file_type,dir_id) VALUES (?,?,?,?,?);";
    public void loadImages(dbMgrInterface db){
        
    }
    public void dirScan(String path,String dir,int dirID){
        //List<String> results = new ArrayList<String>();
        File[] files = new File(path+"/"+dir).listFiles();
        String sql = "";
        for (File file : files){
            System.err.println("INSERT INTO mgn_files (file_desc,file_name,file_type,dir_id) VALUES ('"+dir+"','"+file.getName()+"',"+-10+","+dirID+");");
            
            
            //results.add(file.getName());
        }
    }
    public static void main(String args[]){
        loadImageDb loadImageDb = new loadImageDb();
        for (int i  = 1; i <= 6; i++){
            loadImageDb.dirScan(
                "C:/_bisc/_javaApps/ManhassetGreatNeckObj/_Resoucse/images/manhassetgreatneck",
                "adult_learning_center_0"+i,
                i);
        }
        for (int i  = 1; i <= 4; i++){
            loadImageDb.dirScan(
                "C:/_bisc/_javaApps/ManhassetGreatNeckObj/_Resoucse/images/manhassetgreatneck",
                "learning_center_0"+i,
                i+6);
        }
        loadImageDb.dirScan(
                "C:/_bisc/_javaApps/ManhassetGreatNeckObj/_Resoucse/images/manhassetgreatneck",
                "OTD_2K7",
                11);
         loadImageDb.dirScan(
                "C:/_bisc/_javaApps/ManhassetGreatNeckObj/_Resoucse/images/manhassetgreatneck",
                "pond_view_homes_01",
                12);
    }
}

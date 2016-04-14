/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import obj.reusableObj;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author lmeans
 */
public class uploadImages {
    String path,prefix;
    int cnt=0;
    reusableObj     reusableObj = new  reusableObj();

    public uploadImages(String path,String prefix){
        new File(path).mkdirs();
        this.path = path;
        this.prefix = prefix;
    }
    public String uploadFile(FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
    }
     private String copyFile(String fileName, InputStream in) {
        String str = path+"/" + prefix+"_"+reusableObj.paddingString(""+(cnt++), 3, '0', true)+"_"+fileName;
        try {
            try ( 
                OutputStream out = new FileOutputStream(new File(str))) {
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.flush();
            }
        } catch (IOException e) {
            str = null;
            e.printStackTrace();
            
        }
        return str;
    }
}

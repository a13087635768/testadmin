package com.admin.menu.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadImgServlet extends ActionSupport {

	
	private File file;                        //得到上传的文件  
    private String fileFileName;              //得到文件的名称，写法是固定的  
    private String fileContentType;           //得到文件的类型  


    public String execute() throws IOException  {
    	boolean temp=false;
    	System.out.println(fileFileName);
    	System.out.println(fileContentType);
    	 String realPath = ServletActionContext.getServletContext().getRealPath("/image");
    	 System.out.println(realPath);
    	 String[] allowedType = { "image/bmp", "image/gif", "image/jpeg", "image/png" };
    	 for (String string : allowedType) {
    		 
    		 if(fileContentType.equals(string)){
    			 temp=true;
    		 }
		}
    	if(temp){
    		UUID randomUUID = UUID.randomUUID();
    		
    		String url=realPath+"/"+randomUUID+fileFileName;
    		File file2 = new File(url);
    		FileUtils.copyFile(file, file2);
    		ActionContext context = ActionContext.getContext();
    		HttpServletResponse response = (HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
    		PrintWriter out = response.getWriter();
            String imgUrl = "http://localhost:8080/testadmin/image/"+ randomUUID+fileFileName;

    		//String replace = url.replace("/","\\");
    		out.print(imgUrl);
    		out.flush();
            out.close();
    	}
    	 
    	 
    	return null;
    }


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
    
  
    
	
}

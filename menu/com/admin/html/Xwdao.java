package com.admin.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.CharBuffer;
/**
 *
 * @author SQ
 * 2016年12月19日
 * 下午3:44:05
 */
public class Xwdao {
	String path =this.getClass().getResource("/").getPath();
	
	/**
	 *  新建文件
	 * @param name
	 * @param value
	 * @return 执行结果
	 */
	public boolean insert(String name ,String value) {
		
		try {
		File f = new File(path+"//html");
			File file = new File(f,name);
			 FileOutputStream fileOutputStream = new FileOutputStream(file); 
			 Writer out = new OutputStreamWriter(fileOutputStream, "UTF-8");
			 //byte[] bs = value.getBytes();
			 out.write(value);
				file.createNewFile();
				out.flush();
				fileOutputStream.close();
				out.close();
				return true;
			} catch (Exception e) {
				System.out.println("文件写入异常");
				return false;
			}

		
	}
	
	/**
	 * 修改--清空原有的值
	 * @param name 
	 * @param value 
	 * @return 返回执行结果
	 */
	public boolean update(String name ,String value){
		
		if(delete(name)){
			insert(name, value);
			return true;
		}else{
			return false;
		}
	}
	 
	
	/**传入删除的栏目进行删除
	 * @param name 
	 * @return 执行结果
	 */
	public boolean delete(String name){
		if(judge(name)){
			File file = new File(path+"//html//"+name);
			return file.delete();
		}else{
			return false;
		}
		
	}
	
	/**
	 * 传入栏目进行查询
	 * @param name
	 * @return
	 */
	public String select(String name){
		File file = new File(path+"//html//"+name);
		FileInputStream FileInputStream=null;
		if(file.exists()){
			try {
				FileInputStream = new FileInputStream(file);
				InputStreamReader reader = new InputStreamReader(FileInputStream,"UTF-8"); //最后的"GBK"根据文件属性而定，如果不行，改成"UTF-8"试试
	            BufferedReader br = new BufferedReader(reader);
				//最终返回的的数据
				String value="";
				//记录需要转化为字符串的个数;
				String temp;
				//读取大小为60M
				 //byte[] cha=  new byte[60000000];
				 while ((temp = br.readLine()) != null) {
					 value=temp;
		            }
				 return value;
			} catch (Exception e) {
				System.out.println("文件查询失败");
				return null;
			}finally {
				
				try {
					FileInputStream.close();
				} catch (IOException e) {
					System.out.println("读取流关闭失败");
				}
			}
			
		}else{
			System.out.println("没找到文件");
			return null;
		}
		
	}
	
	/**
	 * 判断是否有该文件
	 * @param name
	 * @return 执行结果是否成功;
	 */
	public boolean judge(String name){
		File file = new File(path+"//html//"+name);
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}

}

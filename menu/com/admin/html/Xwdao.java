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
 * 2016��12��19��
 * ����3:44:05
 */
public class Xwdao {
	String path =this.getClass().getResource("/").getPath();
	
	/**
	 *  �½��ļ�
	 * @param name
	 * @param value
	 * @return ִ�н��
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
				System.out.println("�ļ�д���쳣");
				return false;
			}

		
	}
	
	/**
	 * �޸�--���ԭ�е�ֵ
	 * @param name 
	 * @param value 
	 * @return ����ִ�н��
	 */
	public boolean update(String name ,String value){
		
		if(delete(name)){
			insert(name, value);
			return true;
		}else{
			return false;
		}
	}
	 
	
	/**����ɾ������Ŀ����ɾ��
	 * @param name 
	 * @return ִ�н��
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
	 * ������Ŀ���в�ѯ
	 * @param name
	 * @return
	 */
	public String select(String name){
		File file = new File(path+"//html//"+name);
		FileInputStream FileInputStream=null;
		if(file.exists()){
			try {
				FileInputStream = new FileInputStream(file);
				InputStreamReader reader = new InputStreamReader(FileInputStream,"UTF-8"); //����"GBK"�����ļ����Զ�����������У��ĳ�"UTF-8"����
	            BufferedReader br = new BufferedReader(reader);
				//���շ��صĵ�����
				String value="";
				//��¼��Ҫת��Ϊ�ַ����ĸ���;
				String temp;
				//��ȡ��СΪ60M
				 //byte[] cha=  new byte[60000000];
				 while ((temp = br.readLine()) != null) {
					 value=temp;
		            }
				 return value;
			} catch (Exception e) {
				System.out.println("�ļ���ѯʧ��");
				return null;
			}finally {
				
				try {
					FileInputStream.close();
				} catch (IOException e) {
					System.out.println("��ȡ���ر�ʧ��");
				}
			}
			
		}else{
			System.out.println("û�ҵ��ļ�");
			return null;
		}
		
	}
	
	/**
	 * �ж��Ƿ��и��ļ�
	 * @param name
	 * @return ִ�н���Ƿ�ɹ�;
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

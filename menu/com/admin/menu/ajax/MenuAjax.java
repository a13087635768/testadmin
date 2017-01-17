package com.admin.menu.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.admin.menu.ajax.entity.AjaxColumeEntity;
import com.admin.menu.ajax.entity.AjaxMenuEntity;
import com.admin.menu.entity.TColume;
import com.admin.menu.entity.TMenu;
import com.admin.menu.entity.TSoncolume;
import com.admin.menu.service.ColumnService;
import com.admin.menu.service.MenuService;
import com.admin.menu.service.SoncolumnService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;


public class MenuAjax extends ActionSupport {
	//所需要的 service
	MenuService menuService;
	ColumnService columnService;
	SoncolumnService soncolumnService;
	
	//新闻获取的栏目名称
	String menu;
	String column;
	String soncolumn;
	String value;
	String root;
	String newvalue;
	
	public String insert(){
		
		
		
		return null;
	}
	/**
	 * @接收 menu 菜单名称
	 * 
	 * @author SQ
	 * @return 集体新闻文本获取
	 * @throws IOException 
	 */
	public String allmenu() throws IOException{
		List list  = new ArrayList();
		ActionContext context = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)context.get(ServletActionContext.HTTP_RESPONSE);
		response. setCharacterEncoding("UTF-8");
		TMenu findByName = menuService.findByName(menu);
		AjaxMenuEntity ajaxMenuEntity = new AjaxMenuEntity();
		AjaxColumeEntity ajaxColumeEntity = new AjaxColumeEntity();
		List tColumes = findByName.getTColumes();
		Iterator iterator = tColumes.iterator();
		while (iterator.hasNext()) {
			TColume colum = (TColume)iterator.next();
			List tSoncolumes = colum.getTSoncolumes();
			Iterator iterator2 = tSoncolumes.iterator();
			while(iterator2.hasNext()){
				TSoncolume soncolume = (TSoncolume)iterator2.next();
				ajaxColumeEntity.setName(soncolume.getSName());
				System.out.println(soncolume.getSName());
			}
			System.out.println(colum.getCName());
			ajaxMenuEntity.setName(colum.getCName());
			list.add(ajaxColumeEntity);
			ajaxMenuEntity.setList(list);
		}
		ArrayList arrayList = new ArrayList();
		arrayList.add(ajaxMenuEntity);
		JSONArray jsonArray = JSONArray.fromObject(arrayList);
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toString());
		out.flush();
		out.close();
		return null;
	}
	/**
	 * @栏目菜单操作
	 * @author SQ
	 * @参数 menu 删除栏目名称 |  column名称  | soncolumn  | root 删除栏目等级  2为column  3为soncloume菜单   1为menu
	 * @return null
	 */
	public String Onemenudelete(){
		if(root.equals("2")){
			TColume findByName = columnService.findByName(column);
			columnService.delete(findByName.getCId());
		}else if(root.equals("3")){
			TSoncolume findByName = soncolumnService.findByName(soncolumn);

			soncolumnService.delete(findByName.getSId());
		}else if(root.equals("1")){
			TMenu findByName = menuService.findByName(menu);
			List tColumes = findByName.getTColumes();
			if(tColumes.size()==0){
				menuService.delete(findByName.getMId());
			}else{
				System.out.println("请删除全部栏目后才能删除此选项");
			}
			
		}
		
		return null;
	}
	
	
	/**
	 * @作用  新增 栏目或者菜单
	 * @author SQ
	 * @参数 menu 名称 |  column名称  | soncolumn  |   root 删除栏目等级  2为column  3为soncloume菜单   1 为 menu
	 * @return null
	 */
	public String Onemenuinsert(){
		if(root.equals("1")){
			TMenu tMenu = new TMenu();
			tMenu.setMMenuname(menu);
			menuService.save(tMenu);
			
			
			
		}else if(root.equals("2")){
//			TMenu findByName = menuService.findByName(menu);
//			List tColumes = findByName.getTColumes();
//			TColume tColume = new TColume();
//			tColume.setCName(column);
//			tColumes.add(tColume);
//			findByName.setTColumes(tColumes);
//			menuService.save(findByName);
			
			
		//需要menu的name	
			TMenu findByName = menuService.findByName(menu);
			findByName.setTColumes(null);
			TColume tColume = new TColume();
			tColume.setCName(column);
			tColume.setTMenu(findByName);
			tColume.setTSoncolumes(null);
			columnService.save(tColume);
			
		}else if(root.equals("3")){
			//同上
			TColume findByName = columnService.findByName(column);
			findByName.setTSoncolumes(null);
			findByName.setTMenu(null);
			TSoncolume tSoncolume = new TSoncolume();
			tSoncolume.setSName(soncolumn);
			tSoncolume.setTColume(findByName);
			soncolumnService.save(tSoncolume);
	

//			TColume findByName = columnService.findByName(column);
//			List tSoncolumes = findByName.getTSoncolumes();
//			TSoncolume tSoncolume = new TSoncolume();
//			tSoncolume.setSName(soncolumn);
//			tSoncolumes.add(tSoncolume);
//			findByName.setTSoncolumes(tSoncolumes);
//			columnService.save(findByName);
//			TSoncolume findByName2 = soncolumnService.findByName(soncolumn);
//			soncolumnService.setindex("T_SONCOLUME", "S_ID", findByName2.getSId());
		}
		
		
		return null;
	}
	
	/**
	 * @author SQ
	 * @参数 menu 名称 |  column名称  | soncolumn  | newvalue 为 需要修改的值    root 删除栏目等级  2为column  3为soncloume菜单   1 为 menu
	 * 
	 * 
	 * @return null
	 */
	public String Onemenuupdate(){
		if(root.equals("1")){
			TMenu findByName = menuService.findByName(menu);
			menuService.update(findByName.getMMenuname(), newvalue);
			
		}else if(root.equals("2")){
			TColume findByName = columnService.findByName(column);
			String value = findByName.getCName();
			columnService.update(value, newvalue);

		}else if(root.equals("3")){
			TSoncolume findByName = soncolumnService.findByName(soncolumn);
			soncolumnService.update(findByName.getSName(), newvalue);
		}
		
		return null;
		
	}
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public ColumnService getColumnService() {
		return columnService;
	}
	public void setColumnService(ColumnService columnService) {
		this.columnService = columnService;
	}
	public SoncolumnService getSoncolumnService() {
		return soncolumnService;
	}
	public void setSoncolumnService(SoncolumnService soncolumnService) {
		this.soncolumnService = soncolumnService;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getSoncolumn() {
		return soncolumn;
	}
	public void setSoncolumn(String soncolumn) {
		this.soncolumn = soncolumn;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	
	
	
	


	
	
	
	
}

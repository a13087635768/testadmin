package com.admin.menu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * TColume entity. @author MyEclipse Persistence Tools
 */

public class TColume implements java.io.Serializable {

	// Fields

	private String CId;
	private TMenu TMenu;
	private String CName;
	private List TSoncolumes = new ArrayList();
	
	
	public TColume() {
	}


	public TColume(String cId, com.admin.menu.entity.TMenu tMenu, String cName, List tSoncolumes) {
		super();
		CId = cId;
		TMenu = tMenu;
		CName = cName;
		TSoncolumes = tSoncolumes;
	}


	public String getCId() {
		return CId;
	}


	public void setCId(String cId) {
		CId = cId;
	}


	public TMenu getTMenu() {
		return TMenu;
	}


	public void setTMenu(TMenu tMenu) {
		TMenu = tMenu;
	}


	public String getCName() {
		return CName;
	}


	public void setCName(String cName) {
		CName = cName;
	}


	public List getTSoncolumes() {
		return TSoncolumes;
	}


	public void setTSoncolumes(List tSoncolumes) {
		TSoncolumes = tSoncolumes;
	}


	
	
	
}
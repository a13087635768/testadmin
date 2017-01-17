package com.admin.menu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */

public class TMenu implements java.io.Serializable {

	// Fields

	private String MId;
	private String MMenuname;
	private List TColumes = new ArrayList();
	
	public TMenu() {	
		
	}

	public TMenu(String mId, String mMenuname, List tColumes) {
		MId = mId;
		MMenuname = mMenuname;
		TColumes = tColumes;
	}

	public String getMId() {
		return MId;
	}

	public void setMId(String mId) {
		MId = mId;
	}

	public String getMMenuname() {
		return MMenuname;
	}

	public void setMMenuname(String mMenuname) {
		MMenuname = mMenuname;
	}

	public List getTColumes() {
		return TColumes;
	}

	public void setTColumes(List tColumes) {
		TColumes = tColumes;
	}

	


}
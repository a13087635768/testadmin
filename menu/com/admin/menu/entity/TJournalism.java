package com.admin.menu.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TJournalism entity. @author MyEclipse Persistence Tools
 */

public class TJournalism implements java.io.Serializable {

	// Fields

	private String JId;
	private TSoncolume TSoncolume;
	private String JJournalism;
	private String JName;
	private String JTitle;
	private List TSoncolumes = new ArrayList();
	
	
	public TJournalism() {		super();
	}


	public TJournalism(String jId, com.admin.menu.entity.TSoncolume tSoncolume, String jJournalism, String jName,
			String jTitle, List tSoncolumes) {
		super();
		JId = jId;
		TSoncolume = tSoncolume;
		JJournalism = jJournalism;
		JName = jName;
		JTitle = jTitle;
		TSoncolumes = tSoncolumes;
	}


	public String getJId() {
		return JId;
	}


	public void setJId(String jId) {
		JId = jId;
	}


	public TSoncolume getTSoncolume() {
		return TSoncolume;
	}


	public void setTSoncolume(TSoncolume tSoncolume) {
		TSoncolume = tSoncolume;
	}


	public String getJJournalism() {
		return JJournalism;
	}


	public void setJJournalism(String jJournalism) {
		JJournalism = jJournalism;
	}


	public String getJName() {
		return JName;
	}


	public void setJName(String jName) {
		JName = jName;
	}


	public String getJTitle() {
		return JTitle;
	}


	public void setJTitle(String jTitle) {
		JTitle = jTitle;
	}


	public List getTSoncolumes() {
		return TSoncolumes;
	}


	public void setTSoncolumes(List tSoncolumes) {
		TSoncolumes = tSoncolumes;
	}

	
	
	
}
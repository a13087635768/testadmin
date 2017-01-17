package com.admin.menu.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TSoncolume entity. @author MyEclipse Persistence Tools
 */

public class TSoncolume implements java.io.Serializable {

	// Fields

	private String SId;
	private TColume TColume;
	private TJournalism TJournalism;
	private String SName;
	private List TJournalisms = new ArrayList();
	
	public TSoncolume() {

	}

	public TSoncolume(String sId, com.admin.menu.entity.TColume tColume, com.admin.menu.entity.TJournalism tJournalism,
			String sName, List tJournalisms) {
		super();
		SId = sId;
		TColume = tColume;
		TJournalism = tJournalism;
		SName = sName;
		TJournalisms = tJournalisms;
	}

	public String getSId() {
		return SId;
	}

	public void setSId(String sId) {
		SId = sId;
	}

	public TColume getTColume() {
		return TColume;
	}

	public void setTColume(TColume tColume) {
		TColume = tColume;
	}

	public TJournalism getTJournalism() {
		return TJournalism;
	}

	public void setTJournalism(TJournalism tJournalism) {
		TJournalism = tJournalism;
	}

	public String getSName() {
		return SName;
	}

	public void setSName(String sName) {
		SName = sName;
	}

	public List getTJournalisms() {
		return TJournalisms;
	}

	public void setTJournalisms(List tJournalisms) {
		TJournalisms = tJournalisms;
	}

	
	


}
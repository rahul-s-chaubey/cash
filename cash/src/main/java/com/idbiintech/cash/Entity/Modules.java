package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Modules {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="module_id")
	Integer MODULEID;
	
	@Column(name="module_name")
	String MODULENAME;
	
	@Column(name="isactive")
	String ISACTIVE;
	
	@Column(name="menu_id")
	String MENUID;
	
	@Column(name="module_path")
	String MODULEPATH;

	@Column(name="customer_id")
	Integer CUSTOMERID;

	public Integer getMODULEID() {
		return MODULEID;
	}

	public void setMODULEID(Integer mODULEID) {
		MODULEID = mODULEID;
	}

	public String getMODULENAME() {
		return MODULENAME;
	}

	public void setMODULENAME(String mODULENAME) {
		MODULENAME = mODULENAME;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	public String getMENUID() {
		return MENUID;
	}

	public void setMENUID(String mENUID) {
		MENUID = mENUID;
	}

	public String getMODULEPATH() {
		return MODULEPATH;
	}

	public void setMODULEPATH(String mODULEPATH) {
		MODULEPATH = mODULEPATH;
	}

	public Integer getCUSTOMERID() {
		return CUSTOMERID;
	}

	public void setCUSTOMERID(Integer cUSTOMERID) {
		CUSTOMERID = cUSTOMERID;
	}
	
	
}

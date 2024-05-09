package com.idbiintech.cash.DTO;

public class ModulesDTO {

	private long MODULEID;
	private String MODULENAME;
	private int ISACTIVE;
	private long MENUID;
	private String MODULEPATH;
	public Integer CUSTOMERID;
	public long getMODULEID() {
		return MODULEID;
	}
	public void setMODULEID(long mODULEID) {
		MODULEID = mODULEID;
	}
	public String getMODULENAME() {
		return MODULENAME;
	}
	public void setMODULENAME(String mODULENAME) {
		MODULENAME = mODULENAME;
	}
	public int getISACTIVE() {
		return ISACTIVE;
	}
	public void setISACTIVE(int iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}
	public long getMENUID() {
		return MENUID;
	}
	public void setMENUID(long mENUID) {
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

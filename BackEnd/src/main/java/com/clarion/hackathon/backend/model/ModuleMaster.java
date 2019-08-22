package com.clarion.hackathon.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModuleMaster {

	private String primaryKey1;
	private String primaryKey2;
	private String module_name;
	private String module_desc;
	
	private String  ObjectSearchKey;
	private String created_date;

	public String getPrimaryKey1() {
		return primaryKey1;
	}

	public void setPrimaryKey1(String primaryKey1) {
		this.primaryKey1 = primaryKey1;
	}


	public String getPrimaryKey2() {
		return primaryKey2;
	}

	public void setPrimaryKey2(String primaryKey2) {
		this.primaryKey2 = primaryKey2;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getModule_desc() {
		return module_desc;
	}

	public void setModule_desc(String module_desc) {
		this.module_desc = module_desc;
	}

	public String getObjectSearchKey() {
		return ObjectSearchKey;
	}

	public void setObjectSearchKey(String objectSearchKey) {
		ObjectSearchKey = objectSearchKey;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

}

package com.clarion.hackathon.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScopeMaster {

	@JsonProperty(value = "PrimaryKey1")
	private String primaryKey1;
	@JsonProperty(value = "PrimaryKey2")
	private String primaryKey2;
	private String scopeName;
	private String scopeDesc;

	@JsonProperty(value = "ObjectSearchKey")
	private String objectSearchKey;
	private String createdDate;

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

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public String getScopeDesc() {
		return scopeDesc;
	}

	public void setScopeDesc(String scopeDesc) {
		this.scopeDesc = scopeDesc;
	}

	public String getObjectSearchKey() {
		return objectSearchKey;
	}

	public void setObjectSearchKey(String objectSearchKey) {
		this.objectSearchKey = objectSearchKey;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}

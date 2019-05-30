package com.rpm.services.model;

import java.io.Serializable;

public class DynamicQuery implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1144187867497090171L;

	private String entity;

	private String key;
	
	private String value;
	
	private String operator;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "DynamicQuery [entity=" + entity + ", key=" + key + ", value=" + value + ", operator=" + operator + "]";
	}

	

}

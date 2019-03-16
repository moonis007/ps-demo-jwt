package com.moonis.demo.restapi.entity;

import java.io.Serializable;
import java.util.Date;


public abstract class AbstractEntity implements Serializable {

	/**
	 * This field is used for auditory and logging purposes. It is populated by the
	 * system when an entity instance is created.
	 */
	protected Date createdAt;

	/**
	 * This field is used for auditory and logging purposes. It is populated by the
	 * system when an entity instance is modified.
	 */
	protected Date modifiedAt;
	
	
	protected String createdBy;
	
	protected String modifiedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}

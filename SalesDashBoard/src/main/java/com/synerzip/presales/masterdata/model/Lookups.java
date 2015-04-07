package com.synerzip.presales.masterdata.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "lookups")
public class Lookups implements Serializable{

	@Id
	@Column(name = "LOOKUP_ID", unique = true, nullable = false)
	@Expose
	private Long lookupId;
	
	@Basic
	@Column (name = "LOOKUP_NAME")
	@Expose
	private String lookupName;
	
	@Basic
	@Column (name = "LOOKUP_TYPE")
	@Expose
	private String lookupType;
	
	@Basic
	@Column (name = "LOOKUP_VALUE")
	@Expose
	private String lookupValue;

	public Long getLookupId() {
		return lookupId;
	}

	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}

	public String getLookupName() {
		return lookupName;
	}

	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

	public String getLookupType() {
		return lookupType;
	}

	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lookupId == null) ? 0 : lookupId.hashCode());
		result = prime * result
				+ ((lookupName == null) ? 0 : lookupName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lookups other = (Lookups) obj;
		if (lookupId == null) {
			if (other.lookupId != null)
				return false;
		} else if (!lookupId.equals(other.lookupId))
			return false;
		return true;
	}
	
	
}

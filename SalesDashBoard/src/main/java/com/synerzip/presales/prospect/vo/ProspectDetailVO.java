package com.synerzip.presales.prospect.vo;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import com.synerzip.presales.commons.vo.LookupVO;

public class ProspectDetailVO implements Serializable{

	private String name;
	
	private String companyURL;
	
	private String description;
	
	private Long id;

	private LookupVO lookupvo;
	
	private Long createdDate;

	
	private Long createdBy;
	
	
	private Long updatedDate;

	
	private Long updatedBy;
	
	private Set<ProspectTeamMixVO> teamMixList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyURL() {
		return companyURL;
	}

	public void setCompanyURL(String companyURL) {
		this.companyURL = companyURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LookupVO getLookupvo() {
		return lookupvo;
	}

	public void setLookupvo(LookupVO lookupvo) {
		this.lookupvo = lookupvo;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Long updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<ProspectTeamMixVO> getTeamMixList() {
		return teamMixList;
	}

	public void setTeamMixList(Set<ProspectTeamMixVO> teamMixList) {
		this.teamMixList = teamMixList;
	}
	
	
	
}

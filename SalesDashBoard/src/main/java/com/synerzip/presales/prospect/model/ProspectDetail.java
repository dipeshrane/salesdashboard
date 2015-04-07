package com.synerzip.presales.prospect.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.google.gson.annotations.Expose;
import com.synerzip.presales.masterdata.model.Lookups;

@Entity
@Table(name = "prospect_details")
public class ProspectDetail implements Serializable {

	@Basic
	@Column (name = "NAME")
	@Expose
	private String name;
	
	@Basic
	@Column (name = "COMPANYURL")
	@Expose
	private String companyURL;
	
	@Basic
	@Column (name = "DESCRIPTION")
	@Expose
	private String description;
	
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)	
	private Long id;

	@ManyToOne
	@JoinColumn(name="Status2Status")
	private Lookups lookup;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDDATE")
	private Date createdDate;

	@Basic
	@Column (name = "CREATEDBY")
	private Long createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDDATE")
	private Date updatedDate;

	@Basic
	@Column (name = "UPDATEDBY")
	private Long updatedBy;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prospectDetail",fetch = FetchType.EAGER)
	private Set<ProspectTeamMix> teamMixList;
	
	
	
	public Set<ProspectTeamMix> getTeamMixList() {
		return teamMixList;
	}
	public void setTeamMixList(Set<ProspectTeamMix> teamMixList) {
		this.teamMixList = teamMixList;
	}
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
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Lookups getLookup() {
		return lookup;
	}
	public void setLookup(Lookups lookup) {
		this.lookup = lookup;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProspectDetail other = (ProspectDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}

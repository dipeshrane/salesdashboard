package com.synerzip.presales.prospect.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.google.gson.annotations.Expose;
import com.synerzip.presales.masterdata.model.Lookups;



@Entity
@Table(name = "link_prospect_team_mix")
public class ProspectTeamMix implements Serializable {


	@Id
	@Column(name = "team_mix_id", unique = true, nullable = false)
	@GeneratedValue
	private Long teamMixId;
	
	@ManyToOne
	@JoinColumn(name = "prospect2Prospect_details", nullable = false)
	private ProspectDetail prospectDetail;
	
	@ManyToOne
	@JoinColumn(name="lookup2lookups")
	private Lookups lookup;
	
	@Basic
	@Column (name = "QUANTITY")
	private Long quantity;

	public Long getTeamMixId() {
		return teamMixId;
	}

	public void setTeamMixId(Long teamMixId) {
		this.teamMixId = teamMixId;
	}

	public ProspectDetail getProspectDetail() {
		return prospectDetail;
	}

	public void setProspectDetail(ProspectDetail prospectDetail) {
		this.prospectDetail = prospectDetail;
	}

	public Lookups getLookup() {
		return lookup;
	}

	public void setLookup(Lookups lookup) {
		this.lookup = lookup;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result
				+ ((teamMixId == null) ? 0 : teamMixId.hashCode());
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
		ProspectTeamMix other = (ProspectTeamMix) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (teamMixId == null) {
			if (other.teamMixId != null)
				return false;
		} else if (!teamMixId.equals(other.teamMixId))
			return false;
		return true;
	}
	
	
}

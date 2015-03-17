package com.synerzip.presales.prospect.vo;

import java.io.Serializable;

import com.synerzip.presales.commons.model.Lookups;
import com.synerzip.presales.commons.vo.LookupVO;

public class ProspectTeamMixVO implements Serializable{
	
	private Long teamMixId;
	
	private LookupVO lookupvo;
	
	private Long quantity;

	public Long getTeamMixId() {
		return teamMixId;
	}

	public void setTeamMixId(Long teamMixId) {
		this.teamMixId = teamMixId;
	}

	

	public LookupVO getLookupvo() {
		return lookupvo;
	}

	public void setLookupvo(LookupVO lookupvo) {
		this.lookupvo = lookupvo;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
}

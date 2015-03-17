package com.synerzip.presales.prospect.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.commons.model.Lookups;
import com.synerzip.presales.commons.vo.LookupVO;
import com.synerzip.presales.prospect.dao.ProspectDAO;
import com.synerzip.presales.prospect.model.ProspectDetail;
import com.synerzip.presales.prospect.model.ProspectTeamMix;
import com.synerzip.presales.prospect.service.ProspectService;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;
import com.synerzip.presales.prospect.vo.ProspectTeamMixVO;

public class ProspectServiceImpl implements ProspectService{

	private ProspectDAO prospectDAO;
	
	public ProspectDAO getProspectDAO() {
		return prospectDAO;
	}
	public void setProspectDAO(ProspectDAO prospectDAO) {
		this.prospectDAO = prospectDAO;
	}

	public boolean saveOrUpdateProspect(ProspectDetailVO detailvo)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		ProspectDetail detail = getProspectDetailEntityFromVO(detailvo);
		return prospectDAO.saveOrUpdateProspect(detail);
	}
	
	private ProspectDetail getProspectDetailEntityFromVO(ProspectDetailVO vo){
		ProspectDetail detail = new ProspectDetail();
		detail.setCompanyURL(vo.getCompanyURL());
		detail.setCreatedBy(vo.getCreatedBy());
		detail.setCreatedDate(new Date(vo.getCreatedDate()));
		detail.setDescription(vo.getDescription());
		Lookups lookup = new Lookups();
		lookup.setLookupId(vo.getLookupvo().getLookupId());
		detail.setLookup(lookup);
		
		
		detail.setName(vo.getName());
		detail.setUpdatedBy(vo.getUpdatedBy());
		detail.setUpdatedDate(new Date(vo.getUpdatedDate()));
		Set<ProspectTeamMixVO> teamListVO =  vo.getTeamMixList();
		Set<ProspectTeamMix> teamMixList = new HashSet<ProspectTeamMix>(); 
		for (ProspectTeamMixVO mixvo : teamListVO) {
			ProspectTeamMix mix = new ProspectTeamMix();
			Lookups mixlook = new Lookups();
			mixlook.setLookupId(mixvo.getLookupvo().getLookupId());
			mix.setLookup(mixlook);
			mix.setQuantity(mixvo.getQuantity());
			mix.setProspectDetail(detail);
			teamMixList.add(mix);
		}
		detail.setTeamMixList(teamMixList);
		return detail;
	}
	@Override
	public List<ProspectDetailVO> fetchProspectsForSalesPerson(Long userId)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		List <ProspectDetail> prospectList = prospectDAO.fetchProspectsForSalesPerson(userId);
		List<ProspectDetailVO> prospectVOList = new LinkedList<ProspectDetailVO>();
		for (ProspectDetail detail : prospectList) {
			ProspectDetailVO vo = new ProspectDetailVO();
			vo.setCompanyURL(detail.getCompanyURL());
			vo.setCreatedBy(detail.getCreatedBy());
			vo.setCreatedDate(detail.getCreatedDate().getTime());
			vo.setDescription(detail.getDescription());
			vo.setId(detail.getId());
			LookupVO lookupvo = new LookupVO();
			convertFromLookupToLookupVO(lookupvo, detail.getLookup());
			vo.setLookupvo(lookupvo);
			vo.setName(detail.getName());
			Set<ProspectTeamMix> teammixList = detail.getTeamMixList();
			Set<ProspectTeamMixVO> mixvoList = new HashSet<ProspectTeamMixVO>();
			for (ProspectTeamMix mix : teammixList) {
				ProspectTeamMixVO mixVO = new ProspectTeamMixVO();
				mixVO.setQuantity(mix.getQuantity());
				mixVO.setTeamMixId(mix.getTeamMixId());
				LookupVO mixlookupvo  = new LookupVO();
				convertFromLookupToLookupVO(mixlookupvo, mix.getLookup());
				mixVO.setLookupvo(mixlookupvo);
				mixvoList.add(mixVO);
			}
			vo.setTeamMixList(mixvoList);
			vo.setUpdatedBy(detail.getUpdatedBy());
			vo.setUpdatedDate(detail.getUpdatedDate().getTime());
			prospectVOList.add(vo);
		}
		return prospectVOList;
	}
	
	private void convertFromLookupToLookupVO(LookupVO lookupvo, Lookups lookup){
		lookupvo.setLookupId(lookup.getLookupId());
		lookupvo.setLookupName(lookup.getLookupName());
		lookupvo.setLookupType(lookup.getLookupType());
		lookupvo.setLookupValue(lookup.getLookupValue());
	}

}

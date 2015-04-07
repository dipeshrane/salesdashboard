package com.synerzip.presales.masterdata.service.impl;

import java.util.LinkedList;
import java.util.List;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.masterdata.dao.MasterDataDAO;
import com.synerzip.presales.masterdata.model.Lookups;
import com.synerzip.presales.masterdata.service.MasterDataService;
import com.synerzip.presales.masterdata.vo.LookupVO;
import com.synerzip.presales.prospect.dao.ProspectDAO;
import com.synerzip.presales.prospect.model.ProspectDetail;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;

public class MasterDataServiceImpl implements MasterDataService {

	private MasterDataDAO masterDataDAO;
	

	
	public MasterDataDAO getMasterDataDAO() {
		return masterDataDAO;
	}



	public void setMasterDataDAO(MasterDataDAO masterDataDAO) {
		this.masterDataDAO = masterDataDAO;
	}



	@Override
	public List<LookupVO> fetchLookupsByName(String lookupName)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		List <Lookups> lookupList = masterDataDAO.fetchLookupsByName(lookupName);
		List<LookupVO> lookupVOList = new LinkedList<LookupVO>();
		for (Lookups lookup : lookupList) {
			LookupVO lookupVO = new LookupVO();
			lookupVO.setLookupId(lookup.getLookupId());
			lookupVO.setLookupName(lookup.getLookupName());
			lookupVO.setLookupType(lookup.getLookupType());
			lookupVO.setLookupValue(lookup.getLookupValue());
			lookupVOList.add(lookupVO);
		}
			
		return lookupVOList;
	}



	@Override
	public List<LookupVO> fetchLookupsByType(String lookupType)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		
		List <Lookups> lookupList = masterDataDAO.fetchLookupsByType(lookupType);
		List<LookupVO> lookupVOList = new LinkedList<LookupVO>();
		for (Lookups lookup : lookupList) {
			LookupVO lookupVO = new LookupVO();
			lookupVO.setLookupId(lookup.getLookupId());
			lookupVO.setLookupName(lookup.getLookupName());
			lookupVO.setLookupType(lookup.getLookupType());
			lookupVO.setLookupValue(lookup.getLookupValue());
			lookupVOList.add(lookupVO);
		}
			
		return lookupVOList;
	}

}

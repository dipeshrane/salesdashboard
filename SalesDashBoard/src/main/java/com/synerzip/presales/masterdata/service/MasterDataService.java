package com.synerzip.presales.masterdata.service;

import java.util.List;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.masterdata.vo.LookupVO;


public interface MasterDataService {

	public List<LookupVO> fetchLookupsByName(String lookupName)throws SalesDashboardException;
	
	public List<LookupVO> fetchLookupsByType(String lookupType)throws SalesDashboardException; 
}

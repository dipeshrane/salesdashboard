package com.synerzip.presales.masterdata.dao;

import java.util.List;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.masterdata.model.Lookups;


public interface MasterDataDAO {

	public List<Lookups> fetchLookupsByName(String lookupName)
			throws SalesDashboardException;
	
	public List<Lookups> fetchLookupsByType(String lookupType)
			throws SalesDashboardException;
}

package com.synerzip.presales.prospect.dao;

import java.util.List;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.prospect.model.ProspectDetail;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;

public interface ProspectDAO {

	public boolean saveOrUpdateProspect(ProspectDetail detail)
			throws SalesDashboardException;

	public List<ProspectDetail> fetchProspectsForSalesPerson(Long userId)
			throws SalesDashboardException;
	
}

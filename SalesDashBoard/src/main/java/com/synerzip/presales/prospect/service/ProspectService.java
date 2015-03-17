package com.synerzip.presales.prospect.service;


import java.util.List;

import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;

public interface ProspectService {

	public boolean saveOrUpdateProspect(ProspectDetailVO detail)throws SalesDashboardException;
	
	public List<ProspectDetailVO> fetchProspectsForSalesPerson(Long userId)throws SalesDashboardException;

}


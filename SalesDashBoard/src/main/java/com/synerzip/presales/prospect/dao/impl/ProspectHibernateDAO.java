package com.synerzip.presales.prospect.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.synerzip.presales.commons.dao.impl.AbstractHibernateDAO;
import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.prospect.dao.ProspectDAO;
import com.synerzip.presales.prospect.model.ProspectDetail;

public class ProspectHibernateDAO extends AbstractHibernateDAO<ProspectDetail, Long> implements ProspectDAO{

	
	private static final Logger LOGGER = Logger
			.getLogger(ProspectHibernateDAO.class);

	@Override
	public boolean saveOrUpdateProspect(ProspectDetail detail)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		try{
			saveOrUpdate(detail);
			return true;
		}catch(Exception e){
			LOGGER.error("Unable to save or update Propect",e);
			return false;
		}
	}

	@Override
	public List<ProspectDetail> fetchProspectsForSalesPerson(Long userId)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		List<ProspectDetail> prospectList = null;
		try{
			Session sess = getSessionFactory().getCurrentSession();
			Criteria crit = sess.createCriteria(ProspectDetail.class);
			crit.add(Restrictions.eq("createdBy", userId));
			prospectList =  crit.list();
		}catch(Exception e){
			LOGGER.error("Unable to fetch Prospect for User id = " + userId);
		}
		return prospectList;
	}

}

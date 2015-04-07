package com.synerzip.presales.masterdata.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.synerzip.presales.commons.dao.impl.AbstractHibernateDAO;
import com.synerzip.presales.commons.exception.SalesDashboardException;
import com.synerzip.presales.masterdata.dao.MasterDataDAO;
import com.synerzip.presales.masterdata.model.Lookups;
import com.synerzip.presales.prospect.dao.impl.ProspectHibernateDAO;
import com.synerzip.presales.prospect.model.ProspectDetail;


public class MasterDataHibernateDAO extends AbstractHibernateDAO<Lookups, Long> implements MasterDataDAO{

	private static final Logger LOGGER = Logger
			.getLogger(MasterDataHibernateDAO.class);
	
	@Override
	public List<Lookups> fetchLookupsByName(String lookupName)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		
		List<Lookups> lookupList = null;
		try{
			Session sess = getSessionFactory().getCurrentSession();
			Criteria crit = sess.createCriteria(Lookups.class);
			crit.add(Restrictions.eq("lookupName", lookupName));
			lookupList =  crit.list();
		}catch(Exception e){
			LOGGER.error("Unable to fetch Lookups detail for Lookup Name = " + lookupName);
		}
		return lookupList;
	}

	@Override
	public List<Lookups> fetchLookupsByType(String lookupType)
			throws SalesDashboardException {
		// TODO Auto-generated method stub
		
		List<Lookups> lookupList = null;
		try{
			Session sess = getSessionFactory().getCurrentSession();
			Criteria crit = sess.createCriteria(Lookups.class);
			crit.add(Restrictions.eq("lookupType", lookupType));
			lookupList =  crit.list();
		}catch(Exception e){
			LOGGER.error("Unable to fetch Lookups detail for Lookup Name = " + lookupType);
		}
		return lookupList;
	}

}

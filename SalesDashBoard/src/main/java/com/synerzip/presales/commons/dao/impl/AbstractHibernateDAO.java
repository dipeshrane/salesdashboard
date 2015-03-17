package com.synerzip.presales.commons.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.synerzip.presales.commons.dao.GenericDAO;


public abstract class AbstractHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private SessionFactory sessionFactory;
	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		return (T) getSession().get(getPersistentClass(), id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public T getById(ID id, boolean lock) {
		if (lock) {
			return (T) getSession().get(getPersistentClass(), id,
					LockMode.UPGRADE);
		} else
			return getById(id);
	}

	@SuppressWarnings("unchecked")
	public T loadById(ID id) {
		return (T) getSession().load(getPersistentClass(), id);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	public void merge(T entity) {
		getSession().merge(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void deleteById(ID id) {
		getSession().delete(loadById(id));
	}

	public List<T> findAll() {
		return findByCriteria();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Order order, Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		if(order!=null) {
			crit.addOrder(order);
		}
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}
	
	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Order orders[], Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		if(orders!=null) {
			for (Order order : orders) {
				crit.addOrder(order);
			}
		}
		crit.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}

	/**
	 * Find by criteria.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByCriteria(Map criterias) {

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.allEq(criterias));
		return criteria.list();
	}

	/**
	 * This method will execute an HQL query and return the number of affected
	 * entities.
	 */
	protected int executeQuery(String query, String namedParams[],
			Object params[]) {
		Query q = getSession().createQuery(query);

		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.executeUpdate();
	}

	protected int executeQuery(String query) {
		return executeQuery(query, null, null);
	}

	/**
	 * This method will execute a Named HQL query and return the number of
	 * affected entities.
	 */
	protected int executeNamedQuery(String namedQuery, String namedParams[],
			Object params[]) {
		Query q = getSession().getNamedQuery(namedQuery);

		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.executeUpdate();
	}

	protected int executeNamedQuery(String namedQuery) {
		return executeNamedQuery(namedQuery, null, null);
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance).excludeZeroes()
				.enableLike().ignoreCase();
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	/**
	 * SAVE METHODS (using HibernateTemplate Object)
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public T saveObject(final T entity) {
		this.saveOrUpdate(entity);
		return entity;
	}

	/**
	 * DELETE METHODS (using HibernateTemplate Object)
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public void deleteObject(T entity) {
		this.delete(entity);
	}

	/**
	 * Retrieves the last 2 revisions of the entity with the provided identifier
	 * 
	 * @param id
	 *            identifier of the entity
	 * @param revisionNumber
	 *            latest revision of the entity
	 * @return list containing the latest revision of the entity and one
	 *         previous to the latest
	 */
	/*public List<T> getAuditTrailDifferenceData(ID id, Number revisionNumber) {
		List<T> auditTrailDataList = null;

		final AuditReader reader = AuditReaderFactory.get(getSession());

		T currentObject = reader.find(getPersistentClass(), id, revisionNumber);
		if (currentObject != null) {
			auditTrailDataList = new ArrayList<T>();
			auditTrailDataList.add(currentObject);
			Number previousRevision = (Number) reader
					.createQuery()
					.forRevisionsOfEntity(getPersistentClass(), false, true)
					.addProjection(AuditEntity.revisionNumber().max())
					.add(AuditEntity.id().eq(id))
					.add(AuditEntity.revisionNumber().lt(
							revisionNumber.longValue())).getSingleResult();

			if (previousRevision != null) {
				T previousObject = reader.find(getPersistentClass(), id,
						previousRevision);

				auditTrailDataList.add(previousObject);
			}
		}
		return auditTrailDataList;
	}*/

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
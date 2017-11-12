package edu.elte.airlines.dao.impl;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import edu.elte.airlines.dao.interfaces.CrudDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public abstract class AbstractDao<IdType extends Serializable, EntityType> extends HibernateDaoSupport implements CrudDao<IdType, EntityType> {
	
	private final Class<EntityType> entityTypeClass;


	public AbstractDao(Class<EntityType> entityTypeClass, SessionFactory sessionFactory) {
		this.entityTypeClass = entityTypeClass;
		super.setSessionFactory(sessionFactory);
	}

	public void persist(EntityType entity) {
		currentSession().persist(entity);
	}


	public void update(EntityType entity) {
		currentSession().merge(entity);
	}


	public void delete(EntityType entity) {
		currentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")

	public EntityType findById(IdType id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
		criteria.add(Restrictions.idEq(id));
		Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
		return (EntityType)executableCriteria.uniqueResult();
	}


	public boolean exists(IdType id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
		criteria.add(Restrictions.idEq(id));
		criteria.setProjection(Projections.rowCount());
		Criteria executableCriteria = criteria.getExecutableCriteria(currentSession());
		return 1L == (Long) executableCriteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EntityType> list() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityTypeClass);
		Criteria executeableCriteria = criteria.getExecutableCriteria(currentSession());
		return executeableCriteria.list();
	}
	public EntityType getByKey(IdType key) {
		return currentSession().get(entityTypeClass, key);
	}

	protected Criteria createEntityCriteria(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityTypeClass);
		return detachedCriteria.getExecutableCriteria(currentSession());
	}

}

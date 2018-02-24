package com.spring.dao;

import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDAO<T> implements IBaseDAO<T> {

	private final Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDAO() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	private SessionFactory sessionFactory;
	private HibernateTemplate hibernateTemplate;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(findById(id));
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		List<T> result = (List<T>) hibernateTemplate.findByCriteria(detachedCriteria);
		return result.stream().distinct().collect(Collectors.toList());
		//return result;
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		List<T> result = (List<T>) hibernateTemplate.findByCriteria(detachedCriteria);
		return result.stream().distinct().collect(Collectors.toList());
		//return result;
	}
}

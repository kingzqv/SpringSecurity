package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.stereotype.Repository;

import com.spring.entity.User;

//@Repository("userDAO")
public class UserDAO implements IUserDAO {

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
	public void save(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	@Override
	public void delete(int uid) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(findById(uid));
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.merge(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		List<User> result = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		return result;
	}

	@Override
	public User findById(int uid) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, uid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		List<User> result = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		return result;
	}

}

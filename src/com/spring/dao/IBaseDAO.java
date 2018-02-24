package com.spring.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDAO<T> {
	public void save(T entity);// ���ʵ��
	public void delete(Serializable id);// ɾ��ʵ��
	public void update(T entity);// ����ʵ��

	public List<T> findAll();// ����ȫ��ʵ��
	public T findById(Serializable id);// ����������ʵ��
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);// ��ָ����������ʵ��
}

package com.spring.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface IBaseDAO<T> {
	public void save(T entity);// 添加实例
	public void delete(Serializable id);// 删除实例
	public void update(T entity);// 更新实例

	public List<T> findAll();// 查找全部实例
	public T findById(Serializable id);// 按主键查找实例
	public List<T> findByCriteria(DetachedCriteria detachedCriteria);// 按指定条件查找实例
}

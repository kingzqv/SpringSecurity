package com.spring.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.entity.Role;

public interface IRoleService {
	public void save(Role role);// 添加用户
	public void delete(int id);// 删除用户
	public void update(Role role);// 更新用户

	public List<Role> findAll();// 查找全部用户
	public Role findById(int id);// 按用户id查找用户
	public Role findByName(String role);// 按用户名查找用户
	public List<Role> findByCriteria(DetachedCriteria detachedCriteria);// 按指定条件查找用户
}

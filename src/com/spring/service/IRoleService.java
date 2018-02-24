package com.spring.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.spring.entity.Role;

public interface IRoleService {
	public void save(Role role);// ����û�
	public void delete(int id);// ɾ���û�
	public void update(Role role);// �����û�

	public List<Role> findAll();// ����ȫ���û�
	public Role findById(int id);// ���û�id�����û�
	public Role findByName(String role);// ���û��������û�
	public List<Role> findByCriteria(DetachedCriteria detachedCriteria);// ��ָ�����������û�
}

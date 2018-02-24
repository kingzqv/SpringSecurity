package com.test;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.spring.entity.User;

public interface IUserDAO {
	public void save(User user);// ����û�
	public void delete(int uid);// ɾ���û�
	public void update(User user);// �����û�

	public List<User> findAll();// ����ȫ���û�
	public User findById(int uid);// ���û�id�����û�
	public List<User> findByCriteria(DetachedCriteria detachedCriteria);// ��ָ�����������û�
}

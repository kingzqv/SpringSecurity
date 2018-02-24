package com.test;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.spring.entity.User;

public interface IUserDAO {
	public void save(User user);// 添加用户
	public void delete(int uid);// 删除用户
	public void update(User user);// 更新用户

	public List<User> findAll();// 查找全部用户
	public User findById(int uid);// 按用户id查找用户
	public List<User> findByCriteria(DetachedCriteria detachedCriteria);// 按指定条件查找用户
}

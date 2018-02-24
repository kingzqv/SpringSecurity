package com.spring.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.User;
import com.spring.dao.UserDAO;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional("txManager")
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		if (findByName(user.getUsername()) == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userDAO.save(user);
		}
	}

	@Transactional("txManager")
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if (userDAO.findById(id) != null) {
			userDAO.delete(id);
		}
	}

	@Transactional("txManager")
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		if (userDAO.findById(user.getId()) != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userDAO.update(user);
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		if (!"".equals(username)) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
			detachedCriteria.add(Restrictions.eq("username", username));
			List<User> result = userDAO.findByCriteria(detachedCriteria);
			if (result.size() > 0) {
				return result.get(0);
			}
		}
		return null;
	}

	@Override
	public List<User> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return userDAO.findByCriteria(detachedCriteria);
	}

}

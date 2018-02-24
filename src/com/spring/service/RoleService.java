package com.spring.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Role;
import com.spring.dao.RoleDAO;

@Service("roleService")
public class RoleService implements IRoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Transactional("txManager")
	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		if (findByName(role.getRole()) == null) {
			roleDAO.save(role);
		}
	}

	@Transactional("txManager")
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		if (roleDAO.findById(id) != null) {
			roleDAO.delete(id);
		}
	}

	@Transactional("txManager")
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		if (roleDAO.findById(role.getId()) != null) {
			roleDAO.update(role);
		}
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDAO.findAll();
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleDAO.findById(id);
	}

	@Override
	public Role findByName(String role) {
		// TODO Auto-generated method stub
		if (!"".equals(role)) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
			detachedCriteria.add(Restrictions.eq("role", role));
			List<Role> result = roleDAO.findByCriteria(detachedCriteria);
			if (result.size() > 0) {
				return result.get(0);
			}
		}
		return null;
	}

	@Override
	public List<Role> findByCriteria(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return roleDAO.findByCriteria(detachedCriteria);
	}

}

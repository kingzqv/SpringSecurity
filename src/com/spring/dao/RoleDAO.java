package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.entity.Role;

@Repository("roleDAO")
public class RoleDAO extends BaseDAO<Role> implements IRoleDAO {

}

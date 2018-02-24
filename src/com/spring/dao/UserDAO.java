package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.entity.User;

@Repository("userDAO")
public class UserDAO extends BaseDAO<User> implements IUserDAO{

}

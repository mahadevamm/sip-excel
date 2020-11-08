package com.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.smartinvoice.dao.UserDao;
import com.smartinvoice.model.Users;

@Service
public class UserServiceImpl implements UserService {

	
	@Inject
	UserDao  saveUserDao;
	
	@Override
	public Users saveuser(Users data) {
		return saveUserDao.save(data);
		
	}

	@Override
	public List<Users> receiveAll() {
		return saveUserDao.findAll();
	}

}

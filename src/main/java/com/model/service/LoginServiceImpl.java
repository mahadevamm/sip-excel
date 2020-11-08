package com.model.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.smartinvoice.dao.LoginDao;
import com.smartinvoice.model.Login;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Inject
	LoginDao loginDao;

	public Boolean verifyLoginDetails(String userName, String password) {
		Login login = loginDao.findByUserNameAndPassword(userName, password);
		if(login == null) {
			return false;
		}
		return true;
	}

}

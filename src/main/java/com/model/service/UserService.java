package com.model.service;


import java.util.List;

import com.smartinvoice.model.Users;

public interface UserService {

	Users saveuser(Users user);

	List<Users> receiveAll();

}

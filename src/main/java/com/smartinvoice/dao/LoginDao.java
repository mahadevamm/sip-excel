package com.smartinvoice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartinvoice.model.Login;

@Repository
public interface LoginDao  extends JpaRepository<Login, String> {

	Login findByUserNameAndPassword(String userName, String password);

}

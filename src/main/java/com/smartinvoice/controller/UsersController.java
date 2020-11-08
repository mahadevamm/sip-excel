/**
 * 
 */
package com.smartinvoice.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.service.UserService;
import com.smartinvoice.model.Response;
import com.smartinvoice.model.Users;


/**
 * @author Venky and Mahdev
 *
 */
@RestController
@RequestMapping("/saveuser")
public class UsersController {
	
	@Inject
	UserService saveUserService;
	
	
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public  Object saveUserData(@RequestBody Users user) {
		Response response = new Response();
		try {
			saveUserService.saveuser(user);
			response.setMessage("User saved successfully.");
		} catch (Exception e) {
			response.setMessage("User save or updated failed.");

		}
		return response;
	}
	
	
	/*@RequestMapping(value = { "/userList" }, method = RequestMethod.GET)
	public  Object receiveAllUser() {
	
		
		List<Users>	userList = saveUserService.receiveAll();
			
		return userList;
	}*/
	
	
	
}


	
	 


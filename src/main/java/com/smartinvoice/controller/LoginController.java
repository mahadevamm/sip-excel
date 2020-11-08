package com.smartinvoice.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.service.LoginService;
import com.model.service.UserService;
import com.smartinvoice.excel.WriteIntoExcel;
import com.smartinvoice.model.Response;
import com.smartinvoice.model.Users;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/login")
public class LoginController {

	@Inject
	LoginService loginService;
	
	@Inject
	UserService saveUserService;

	@GetMapping("/submit")
	public ResponseEntity<?> verifyLogin(@RequestParam String userName, @RequestParam String password) {
		Boolean b = loginService.verifyLoginDetails(userName, password);
		if (!b) {
			Response response = new Response();
			response.setCode("LOGIN FAIL");
			response.setMessage("Login failed");
			response.setDescription("user name or password wrong");
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
		return new ResponseEntity<>("Login success", HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/userList" }, method = RequestMethod.GET)
	public  Object receiveAllUser() {
	
		
		List<Users>	userList = saveUserService.receiveAll();
			
		return userList;
	}
	
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
	@RequestMapping(value = { "/download" }, method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws IOException {
		List<Users>	userList = saveUserService.receiveAll();
		 HSSFWorkbook dowExcel = WriteIntoExcel.dowExcel(userList);
		 /*ByteArrayOutputStream bos = new ByteArrayOutputStream(); 
		 dowExcel.write(bos); 
         response.setContentLength(bos.size());*/
         response.setHeader("Content-disposition", "attachment;filename=allInvoiceData.xls");
         response.setContentType("application/vnd.ms-excel");
         dowExcel.write(response.getOutputStream());          
	}
	
}

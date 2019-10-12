package com.spring.starter.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.starter.dto.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/")
public class LoginController {
	
	
	@ApiOperation(value = "Form based login")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ApiParam(value = "Spring boot service.") @RequestBody User user) {
		
		return user.getUsername();
		
	}
}

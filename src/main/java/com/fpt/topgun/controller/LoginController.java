package com.fpt.topgun.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.topgun.dto.ProductOutputDto;
import com.fpt.topgun.dto.UserDto;
import com.fpt.topgun.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {

  private static final Logger logger = LogManager.getLogger(LoginController.class);
  
  private LoginService loginService;
  
  /**
   * This method using to create product.
   */
  @ApiOperation(value = "create product", response = ProductOutputDto.class)
  @RequestMapping(value = "/login/user", method = RequestMethod.POST)
  public boolean createUser(@Valid @RequestBody UserDto userDto) {
    logger.info("Get all products.");
    return loginService.create(userDto);
  }
  
  /**
   * This method using to create product.
   */
  @ApiOperation(value = "create product", response = ProductOutputDto.class)
  @RequestMapping(value = "/login/", method = RequestMethod.PUT)
  public boolean login(@Valid @RequestBody UserDto userDto) {
    logger.info("Get all products.");
    return loginService.checkUser(userDto);
  }
}

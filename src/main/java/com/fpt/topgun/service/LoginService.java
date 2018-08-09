package com.fpt.topgun.service;

import com.fpt.topgun.dto.UserDto;

public interface LoginService {

  boolean create(UserDto userDto);

  boolean checkUser(UserDto userDto);
}

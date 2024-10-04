package com.zagradio.me.zagradio_me_back.service;

import com.zagradio.me.zagradio_me_back.rest.dto.user.UserCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.user.UserInfoDto;

public interface UserService {

    public UserInfoDto getUserInfo(Long id);

    UserInfoDto createUser(UserCreateDto userCreateDto);
}

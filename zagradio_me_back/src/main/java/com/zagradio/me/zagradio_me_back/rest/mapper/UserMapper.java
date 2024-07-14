package com.zagradio.me.zagradio_me_back.rest.mapper;

import com.zagradio.me.zagradio_me_back.entity.User;
import com.zagradio.me.zagradio_me_back.rest.dto.user.UserInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserInfoDto userToUserInfoDto(User user);
}

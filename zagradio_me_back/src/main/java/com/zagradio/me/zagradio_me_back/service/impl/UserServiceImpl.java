package com.zagradio.me.zagradio_me_back.service.impl;

import com.zagradio.me.zagradio_me_back.entity.User;
import com.zagradio.me.zagradio_me_back.repository.UserRepo;
import com.zagradio.me.zagradio_me_back.rest.dto.user.UserCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.user.UserInfoDto;
import com.zagradio.me.zagradio_me_back.service.UserService;
import com.zagradio.me.zagradio_me_back.rest.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserInfoDto getUserInfo(Long id) {
        return userMapper.userToUserInfoDto(userRepo.findUserById(id));
    }

    @Override
    public UserInfoDto createUser(UserCreateDto userCreateDto) {

        User newUser = User.builder()
                .email(userCreateDto.email())
                .firstName(userCreateDto.firstName())
                .lastName(userCreateDto.lastName())
                .isAdmin(false)
                .password(userCreateDto.password())
                .birthDate(userCreateDto.dateOfBirth())
                .build();
        newUser = userRepo.save(newUser);

        return userMapper.userToUserInfoDto(newUser);
    }
}

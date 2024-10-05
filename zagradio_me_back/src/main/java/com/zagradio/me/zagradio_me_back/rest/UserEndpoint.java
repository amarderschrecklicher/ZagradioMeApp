package com.zagradio.me.zagradio_me_back.rest;

import com.zagradio.me.zagradio_me_back.rest.dto.user.UserCreateDto;
import com.zagradio.me.zagradio_me_back.rest.dto.user.UserInfoDto;
import com.zagradio.me.zagradio_me_back.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(path = "/user")
public class UserEndpoint {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("info/{id}")
    public UserInfoDto getUserInfo(@PathVariable("id") long id) {
        log.info("GET user/info/{}", id);
        return userService.getUserInfo(id);
    }

    @PostMapping("create")
    public UserInfoDto createUserInfo(@Valid @RequestBody UserCreateDto userCreateDto) {
        log.info("POST user/create/{}", userCreateDto);
        return userService.createUser(userCreateDto);
    }


    @PostMapping("update/{id}")
    public UserInfoDto updateUserInfo(@PathVariable("id") long id, @Valid @RequestBody UserCreateDto reportCreateDto) {
        log.info("UPDATE report/update/{}", reportCreateDto);
        return userService.updateUser(id, reportCreateDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") long id, @Valid @RequestBody UserCreateDto reportCreateDto) {
        log.info("DELETE report/delete/{}", reportCreateDto);
        userService.deleteUser(id);
    }


}

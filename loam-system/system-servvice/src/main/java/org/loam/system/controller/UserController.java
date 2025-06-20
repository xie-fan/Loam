package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.system.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

}

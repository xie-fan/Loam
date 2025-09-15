package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.User;
import org.loam.system.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public DataSet<User> getUser(@PathVariable int id) {
        return DataSet.success(userService.getUser(id));
    }

    @GetMapping("/account")
    public DataSet<User> getUserByAccount(@RequestParam String account) {
        return DataSet.success(userService.getUserByAccount(account));
    }

    @GetMapping("/list")
    public DataSet<List<User>> getList(User user) {
        return DataSet.success(userService.getList(user));
    }

    @GetMapping("/listByPage")
    public DataSet<List<User>> getListByPage(User user, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return DataSet.success(userService.getListByPage(user, pageNum, pageSize));
    }

    @PostMapping
    public DataSet<User> insertUser(@RequestBody User user) {
        return DataSet.success(userService.insertUser(user));
    }

    @PutMapping
    public DataSet<User> updateUser(@RequestBody User user) {
        return DataSet.success(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public Message deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return Message.success();
    }

}

package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.User;
import org.loam.system.remote.factory.UserCallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "system-service", path = "/system/user", fallbackFactory = UserCallBackFactory.class)
public interface UserRemoteService {


    @GetMapping("/{id}")
    DataSet<User> getUser(@PathVariable Long id);

    @GetMapping("/list")
    DataSet<List<User>> getList(@SpringQueryMap User user);

    @GetMapping("/account")
    DataSet<User> getUserByAccount(@RequestParam String account);

    @GetMapping("/listByPage")
    DataSet<List<User>> getListByPage(@SpringQueryMap User user,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    DataSet<User> insertUser(@RequestBody User user);

    @PutMapping
    DataSet<User> updateUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    Message deleteUser(@PathVariable Long id);

}

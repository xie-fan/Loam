package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.User;
import org.loam.system.remote.factory.UserCallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "userRemoteService", fallbackFactory = UserCallBackFactory.class)
public interface UserRemoteService {


    @GetMapping("/{id}")
    public DataSet<User> getUser(@PathVariable int id);

    @GetMapping("/list")
    public DataSet<List<User>> getList(@RequestParam User user);

    @GetMapping("/account")
    DataSet<User> getUserByAccount(@RequestParam String account);

    @GetMapping("/listByPage")
    public DataSet<List<User>> getListByPage(User user, int pageNum, int pageSize);

    @PostMapping
    public DataSet<User> insertUser(@RequestPart User user) ;

    @PutMapping
    public DataSet<User> updateUser(@RequestPart User user);

    @DeleteMapping("/{id}")
    public Message deleteUser(@PathVariable int id);

}

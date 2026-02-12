package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "system-service", path = "/system/post")
public interface PostRemoteService {


    @GetMapping("/{id}")
    DataSet<Post> getPost(@PathVariable Long id);

    @GetMapping("/list")
    DataSet<List<Post>> getList(@SpringQueryMap Post post);

    @GetMapping("/listByPage")
    DataSet<List<Post>> getListByPage(@SpringQueryMap Post post,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    DataSet<Post> insertPost(@RequestBody Post post);

    @PutMapping
    DataSet<Post> updatePost(@RequestBody Post post);

    @DeleteMapping("/{id}")
    Message deletePost(@PathVariable Long id);

}

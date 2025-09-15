package org.loam.system.remote.service;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "postRemoteService")
public interface PostRemoteService {


    @GetMapping("/{id}")
    public DataSet<Post> getPost(@PathVariable int id);

    @GetMapping("/list")
    public DataSet<List<Post>> getList(Post post);

    @GetMapping("/listByPage")
    public DataSet<List<Post>> getListByPage(Post post, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize);

    @PostMapping
    public DataSet<Post> insertPost(@RequestBody Post post);

    @PutMapping
    public DataSet<Post> updatePost(@RequestBody Post post);

    @DeleteMapping("/{id}")
    public Message deletePost(@PathVariable int id);

}
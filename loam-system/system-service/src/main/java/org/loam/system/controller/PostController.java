package org.loam.system.controller;

import jakarta.annotation.Resource;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.Message;
import org.loam.system.bean.entity.Post;
import org.loam.system.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping("/{id}")
    public DataSet<Post> getPost(@PathVariable Long id) {
        return DataSet.success(postService.getPost(id));
    }

    @GetMapping("/list")
    public DataSet<List<Post>> getList(Post post) {
        return DataSet.success(postService.getList(post));
    }

    @GetMapping("/listByPage")
    public DataSet<List<Post>> getListByPage(Post post, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        return DataSet.success(postService.getListByPage(post, pageNum, pageSize));
    }

    @PostMapping
    public DataSet<Post> insertPost(@RequestBody Post post) {
        return DataSet.success(postService.insertPost(post));
    }

    @PutMapping
    public DataSet<Post> updatePost(@RequestBody Post post) {
        return DataSet.success(postService.updatePost(post));
    }

    @DeleteMapping("/{id}")
    public Message deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return Message.success();
    }

}

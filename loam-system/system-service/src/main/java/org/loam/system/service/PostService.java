package org.loam.system.service;

import org.loam.system.bean.entity.Post;

import java.util.List;

public interface PostService {
    Post getPost(int id);

    List<Post> getList(Post post);

    Post insertPost(Post post);

    Post updatePost(Post post);

    void deletePost(int id);

    List<Post> getListByPage(Post post, int pageNum, int pageSize);
}
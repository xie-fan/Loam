package org.loam.system.service;

import org.loam.system.bean.entity.Post;

import java.util.List;

public interface PostService {
    Post getPost(Long id);

    List<Post> getList(Post post);

    Post insertPost(Post post);

    Post updatePost(Post post);

    void deletePost(Long id);

    List<Post> getListByPage(Post post, int pageNum, int pageSize);
}

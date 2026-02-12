package org.loam.system.service.impl;

import jakarta.annotation.Resource;
import org.loam.system.bean.entity.Post;
import org.loam.system.mapper.PostMapper;
import org.loam.system.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public Post getPost(Long id) {
        return postMapper.selectById(id);
    }

    @Override
    public List<Post> getList(Post post) {
        return postMapper.selectList(post);
    }

    @Override
    public Post insertPost(Post post) {
        postMapper.insertPost(post);
        return post;
    }

    @Override
    public Post updatePost(Post post) {
        postMapper.updatePost(post);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        postMapper.deleteById(id);
    }

    @Override
    public List<Post> getListByPage(Post post, int pageNum, int pageSize) {
        com.github.pagehelper.PageHelper.startPage(pageNum, pageSize);
        return postMapper.selectList(post);
    }
}

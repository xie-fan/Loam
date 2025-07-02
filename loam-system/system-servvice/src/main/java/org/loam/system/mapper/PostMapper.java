package org.loam.system.mapper;

import org.loam.system.bean.entity.Post;

import java.util.List;

public interface PostMapper {

    Post selectById(int id);

    List<Post> selectList(Post post);

    void insertPost(Post post);

    void updatePost(Post post);

    void deleteById(int id);
}
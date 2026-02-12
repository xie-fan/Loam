package org.loam.system.mapper;

import org.loam.system.bean.entity.Post;

import java.util.List;

public interface PostMapper {

    Post selectById(Long id);

    List<Post> selectList(Post post);

    void insertPost(Post post);

    void updatePost(Post post);

    void deleteById(Long id);
}

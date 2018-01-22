package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Blog;
import org.springframework.security.access.prepost.PreAuthorize;

public interface BlogService {
    Iterable<Blog> listAllPosts();
    Iterable<Blog> listTopTenPosts();
    Blog getPostById(Integer id);
    Blog savePost(Blog blog);
    void deletePost(Integer id);
}
package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Blog;

public interface BlogService {
    Iterable<Blog> listAllPosts();
    Blog getPostById(Integer id);
    Blog savePost(Blog blog);
    void deletePost(Integer id);
}
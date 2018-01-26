package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Blog;
import com.carbonara.karateboot.repos.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    private BlogRepository blogRepository;

    @Autowired
    public void setBlogRepository(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    @Override
    public Iterable<Blog> listAllPosts() {
        return blogRepository.findTop200ByOrderByDateDesc();
    }

    @Override
    public Blog getPostById(Integer id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog savePost(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deletePost(Integer id) {
        blogRepository.delete(id);
    }
    
}

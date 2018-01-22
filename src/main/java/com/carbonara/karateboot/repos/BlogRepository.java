package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("blogRepository")
public interface BlogRepository extends CrudRepository<Blog, Integer> {
    
}
package com.carbonara.karateboot.repos;

import com.carbonara.karateboot.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("commentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    Iterable<Comment> findByBlogId(int id);
}
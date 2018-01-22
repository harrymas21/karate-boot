package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Comment;

public interface CommentService {
    //Iterable<Comment> listAllComments();
    //Comment getCommentById(Integer id);
    Comment saveComment(Comment comment);
    //void deleteComment(Integer id);
    Iterable<Comment> findByBlogId(int id);
}

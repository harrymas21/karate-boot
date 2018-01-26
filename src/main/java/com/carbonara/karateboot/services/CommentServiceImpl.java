package com.carbonara.karateboot.services;

import com.carbonara.karateboot.models.Comment;
import com.carbonara.karateboot.repos.CommentRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    
    @PersistenceContext	
    private EntityManager entityManager;
    
    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    
    @Override
    public Comment saveComment(Comment comment) {
       return commentRepository.save(comment);
    }
    
    @Override
    public Iterable<Comment> findByBlogId(int id) {
            //return commentRepository.findByBlogId(id);
        Iterable<Comment> list = entityManager.createQuery("SELECT comments FROM Comment comments WHERE blog_id=? ORDER BY comments.date DESC")
				.setParameter(1, id).setMaxResults(25).getResultList();
        return list;
    }
}
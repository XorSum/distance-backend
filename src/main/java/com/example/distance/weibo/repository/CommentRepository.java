package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Integer> {

    Iterable<Comment> findAllByWeiboIdOrderByDate(Integer weiboId);
    Comment findOneByCommentId(Integer commentId);

}

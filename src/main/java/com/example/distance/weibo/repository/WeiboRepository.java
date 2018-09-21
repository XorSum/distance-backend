package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.Weibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeiboRepository extends JpaRepository<Weibo,Integer>{

    List<Weibo> findAllByUserId(Integer userId);
    Weibo findOneByWeiboId(Integer weiboId);

    List<Weibo> findAll();

    @Query(value = "select weiboId,userId,userName,content,date from Weibo  where content like %:keyword%  order by date desc ")
    List<Weibo> findAllByContent(@Param("keyword") String keyword);

    @Query(value = "select weiboId,userId,userName,content,date from Weibo  where  userName like %:keyword% order by date desc ")
    List<Weibo> findAllByUserName(@Param("keyword") String keyword);


}

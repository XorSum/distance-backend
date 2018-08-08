package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.Weibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface WeiboRepository extends JpaRepository<Weibo,Integer>{

    Iterable<Weibo> findAllByUserId(Integer userId);
    Weibo findOneByWeiboId(Integer weiboId);




}

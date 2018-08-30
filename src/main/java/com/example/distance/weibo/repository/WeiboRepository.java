package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.Weibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeiboRepository extends JpaRepository<Weibo,Integer>{

    List<Weibo> findAllByUserId(Integer userId);
    Weibo findOneByWeiboId(Integer weiboId);

    List<Weibo> findAll();


}

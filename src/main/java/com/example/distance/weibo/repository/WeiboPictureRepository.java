package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.WeiboPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeiboPictureRepository extends JpaRepository<WeiboPicture,Integer>{

    Iterable<WeiboPicture> findAllByWeiboId(Integer weiboId);
    Iterable<String> findPicPathByWeiboId(Integer weiboId);
    Iterable<WeiboPicture> findAllByPicPath(String picPath);
    WeiboPicture findOneByPicPathAndWeiboId(String picPath,Integer weiboId);


}

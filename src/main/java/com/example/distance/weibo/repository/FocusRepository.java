package com.example.distance.weibo.repository;

import com.example.distance.weibo.Model.Focus;
import com.example.distance.weibo.Model.FocusMultiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FocusRepository extends JpaRepository<Focus,FocusMultiKey> {

    Focus findByUserIdAndVId(Integer userId,Integer vId);
    Iterable<Focus> findAllByUserId(Integer userId);

}

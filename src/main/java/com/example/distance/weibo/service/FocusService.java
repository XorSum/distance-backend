package com.example.distance.weibo.service;

import com.example.distance.utils.result.Result;
import com.example.distance.weibo.Model.Focus;
import com.example.distance.weibo.repository.FocusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FocusService {

    @Autowired
    FocusRepository focusRepository;

    public Result add(Integer userId,Integer vId){
        try {
            Focus focus = new Focus();
            focus.setUserId(userId);
            focus.setVId(vId);
            focus.setFocusDate(new Date());
            focusRepository.save(focus);
            return Result.success(focus);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
    }

    public Result del(Integer userId,Integer vId){
        try {
            Focus focus = focusRepository.findByUserIdAndVId(userId,vId);
            if (focus==null){
                return Result.error("并未关注");
            }
            focusRepository.delete(focus);
            return Result.success("取关成功");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    public Result getFocueList(Integer userId){
        try {
            Iterable<Focus> focuses = focusRepository.findAllByUserId(userId);
            if (focuses==null){
                return Result.error("查询失败");
            }
            return Result.success(focuses);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }



}

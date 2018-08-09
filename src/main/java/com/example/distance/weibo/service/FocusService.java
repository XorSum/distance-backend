package com.example.distance.weibo.service;

import com.example.distance.utils.result.ErrorResult;
import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
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
            return new SuccessResult(focus);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult(e.getMessage());
        }
    }

    public Result del(Integer userId,Integer vId){
        try {
            Focus focus = focusRepository.findByUserIdAndVId(userId,vId);
            if (focus==null){
                return new ErrorResult("并未关注");
            }
            focusRepository.delete(focus);
            return new SuccessResult("取关成功");
        }catch (Exception e){
            return new ErrorResult(e.getMessage());
        }
    }

    public Result getFocueList(Integer userId){
        try {
            Iterable<Focus> focuses = focusRepository.findAllByUserId(userId);
            if (focuses==null){
                return new ErrorResult("查询失败");
            }
            return new SuccessResult(focuses);
        }catch (Exception e){
            return new ErrorResult(e.getMessage());
        }
    }



}

package com.example.distance.file;

import com.example.distance.aop.annotation.LogAnnotation;
import com.example.distance.utils.result.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *  文件上传与下载
 */
@RestController
@RequestMapping("/file/")
@LogAnnotation
public class FileController {

    @Autowired
    FileService fileService;


    @ApiOperation(value = "上传文件", notes = " 返回值的data是文件保存在服务器的路径 ", response = Void.class)
    @RequestMapping(value = "/upload/",method = RequestMethod.POST)
    public Result upload(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                         @ApiParam(value = "你想上传的文件" ,required=true ) @RequestParam MultipartFile file) {

       return fileService.upload(file);
    }


    @ApiOperation(value = "下载文件图片", notes = "notes", response = Void.class)
    @RequestMapping(value = "/download/{filePath}",method = RequestMethod.GET)
    public Result downloadFile(@ApiParam(value = "jwt" ,required=true ) @RequestParam String jwt,
                               @ApiParam(value = "文件路经" ,required=true ) @PathVariable String filePath, HttpServletRequest request, HttpServletResponse response) {
        return fileService.downloadFile(filePath,request,response);
    }


}

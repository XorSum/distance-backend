package com.example.distance.file;

import com.example.distance.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class FileController {

    @Autowired
    FileService fileService;


    /**
     * @param file
     * @return Result
     */
    @RequestMapping(value = "/upload/",method = RequestMethod.POST)
    public Result upload( MultipartFile file) {
       return fileService.upload(file);
    }

    /**
     * @param filePath
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/download/{filePath}",method = RequestMethod.GET)
    public Result downloadFile( @PathVariable String filePath, HttpServletRequest request, HttpServletResponse response) {
        return fileService.downloadFile(filePath,request,response);
    }


}

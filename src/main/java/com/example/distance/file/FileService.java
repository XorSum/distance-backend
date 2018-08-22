package com.example.distance.file;

import com.example.distance.utils.MD5;
import com.example.distance.utils.result.ErrorResult;
import com.example.distance.utils.result.Result;
import com.example.distance.utils.result.SuccessResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class FileService {

    @Value("${file.uploadDir}")
    private String uploadDir ;

    public Result upload( MultipartFile file)  {
        if (file.isEmpty()) {
            return new ErrorResult("file is empty");
        }

        String fileName = file.getOriginalFilename();

        String md5fileName = MD5.file(file);
        if (md5fileName==null){
            return new ErrorResult();
        }

       // System.out.println("the file name is " + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
       // System.out.println("the suffix file name is  " + suffixName);
        String filePath =   md5fileName  +  suffixName;
        File dest = new File( uploadDir + "/" + filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
          //  System.out.println("file was saved as " + filePath);
            return new SuccessResult(filePath);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorResult("file didn't upload");

    }


    public Result downloadFile( String filePath, HttpServletRequest request, HttpServletResponse response) {
       // System.out.println("download file " + fileName);
        String fileUrl = uploadDir +filePath;
        if (fileUrl != null) {
            File file = new File(fileUrl);
            if (file.exists()) {
                // response.setContentType("application/force-download");// 设置强制下载不打开
//                response.addHeader("Content-Disposition",
//                "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    //System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

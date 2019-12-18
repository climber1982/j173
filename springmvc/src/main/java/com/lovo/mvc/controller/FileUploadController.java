package com.lovo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping("upload.lovo")
    public ModelAndView upload(@RequestParam("fileName")MultipartFile file,String userName) throws IOException {
        ModelAndView mv=new ModelAndView("upload");
        //获取上传文件的名字
        String fileName=file.getOriginalFilename();
        //创建文件.文件大小为0kb
        File f=new File("D:/img/"+fileName);
        //把spring获得的文件放到我们创建的文件中去
        file.transferTo(f); //这时候文件大小就是上传文件的大小
        System.out.println(userName);
        return mv;
    }
}

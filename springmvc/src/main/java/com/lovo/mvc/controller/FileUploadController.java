package com.lovo.mvc.controller;

import com.lovo.mvc.util.ImgUtile;
import com.lovo.mvc.util.StringInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FileUploadController {

    //注入自定义图片类
    @Autowired
   private ImgUtile imgUtile;
    @RequestMapping("upload.lovo")
    public ModelAndView upload(@RequestParam("fileName")MultipartFile file,String userName) throws IOException {

        ModelAndView mv=new ModelAndView("upload");
        //获取上传文件的名字
        String fileName=file.getOriginalFilename();
        //获取上传文件的后缀
        String []suffixArray=fileName.split("\\.");
        String suffix=suffixArray[suffixArray.length-1];
        //判断上传文件是否合法
        boolean bl=   imgUtile.isSuffixOk(suffix);
        if(bl){
        //重新生成文件名
            String newFileName=System.currentTimeMillis()+"."+suffix;
        //判断文件夹是否存在，如果不存在就创建
          File f=new File(imgUtile.getImgPath()+newFileName);
            f.createNewFile();
//          if(!f.exists()){
//              File f2=new File(imgUtile.getImgPath());
//              f2.mkdir();
//              f.createNewFile();
//          }
        //实现上传
           file.transferTo(f);
        //把文件名保存到数据库

          List<String> listImg=  imgUtile.getListImg();
          listImg.add(newFileName);
        }else {
            //文件非法
            mv.addObject("imgInfo", StringInfo.UPLOADERROR);
        }
        return mv;
    }
}

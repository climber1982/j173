package com.lovo.mvc.util;


import java.util.ArrayList;
import java.util.List;

public class ImgUtile {

    public ImgUtile(String imgPath, String imgSuffix) {
        this.imgPath = imgPath;
        this.imgSuffix = imgSuffix;
        //组装数组
        suffixArray=   this.imgSuffix.split(",");

        this.listImg=new ArrayList<>();
    }
    private  String imgPath; //图片地址
     private  String imgSuffix; //图片后缀
     private  String[] suffixArray;//图片后缀数组
    private List<String> listImg =null;
    /**
     * 上传合法就返回true,否则返回false
     * @param suffix  上传文件的后缀
     * @return
     */
    public boolean isSuffixOk(String suffix){
        boolean bl=false;
      for (String s:suffixArray){
          if(s.equals(suffix)){
              bl=true;
              break;
          }
      }
        return  bl;
    }



    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgSuffix() {
        return imgSuffix;
    }

    public void setImgSuffix(String imgSuffix) {
        this.imgSuffix = imgSuffix;
    }

    public String[] getSuffixArray() {
        return suffixArray;
    }

    public void setSuffixArray(String[] suffixArray) {
        this.suffixArray = suffixArray;
    }

    public List<String> getListImg() {
        return listImg;
    }

    public void setListImg(List<String> listImg) {
        this.listImg = listImg;
    }
}

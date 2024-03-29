package com.zzh.pifashop.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zzh.pifashop.domain.Items;
import com.zzh.pifashop.service.IItemsService;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@EnableAutoConfiguration
public class ItemsController {

    @Autowired
    IItemsService iItemsService;

    private static final String IMGPATHHEAD;

    static {
        try {
//            IMGPATHHEAD = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/";
            IMGPATHHEAD = InetAddress.getLocalHost()+"/image/";
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 无参返回所有item的所有信息
     * @return
     */
    @RequestMapping("/itemList")
    public String itemList(){
        QueryWrapper<Items> qw = new QueryWrapper<>();
        qw.ne("state",-1);
        List<Items> items = iItemsService.list(qw);
//        items.forEach(System.out::println);
        return JSON.toJSONString(items);
    }

    /**
     * 通过id返回一个item的所有信息
     * @param request
     * @param itemid
     * @return
     */
    @RequestMapping("/itemDetial")
    public String itemDetial(HttpServletRequest request,
                             @RequestParam int itemid){
        Items byId = iItemsService.getById(itemid);
        return JSON.toJSONString(byId);
    }

//    /**
//     * 上架商品
//     * @param request
//     * @param name
//     * @param price
//     * @param url
//     * @return
//     */
//    @RequestMapping("/addItem")
//    public String addItem(HttpServletRequest request,
//                          @RequestParam String name,
//                          @RequestParam double price,
//                          @RequestParam String url){
//        url = IMGPATHHEAD + url;
//        Items item = new Items(name, price, url);
//        try {
//            iItemsService.save(item);
//        }catch (Exception e){
//            return e.toString();
//        }
//        return "success";
//    }

    /**
     * 上架商品
     * @param request
     * @param name
     * @param price
     * @param picfile
     * @return
     */
    @RequestMapping("/addItem")
    public String addItem(HttpServletRequest request,
                          @RequestParam String name,
                          @RequestParam double price,
                          @RequestParam("picfile") MultipartFile picfile){
        String imgName;
//        if (picfile.isEmpty()){
//            System.out.println("文件是空的");
//        }
        try {
            String type = picfile.getOriginalFilename().substring(picfile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            imgName = name + type;
            System.out.println(imgName);
//            System.out.println(type);
//            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  type);
            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  imgName);
//            File targetFile = new File("src/main/resources/static/images" ,  type);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            picfile.transferTo(targetFile);
//            return  imgName;
        } catch (Exception e) {
            return "上传失败";
        }
        String url = IMGPATHHEAD + imgName;
        Items item = new Items(name, price, url);
        try {
            iItemsService.save(item);
        }catch (Exception e){
            return e.toString();
        }
        return "success";
    }

    /**
     * 编辑商品属性
     * @param request
     * @param itemid
     * @param name
     * @param price
     * @param picfile
     * @return
     */
    @RequestMapping("editItem")
    public String editItem(HttpServletRequest request,
                           @RequestParam int itemid,
                           @RequestParam String name,
                           @RequestParam double price,
                           @RequestParam("picfile") MultipartFile picfile){
        String imgName;
        try {
            String type = picfile.getOriginalFilename().substring(picfile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            imgName = name + type;
            System.out.println(imgName);
//            System.out.println(type);
//            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  type);
            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  imgName);
//            File targetFile = new File("src/main/resources/static/images" ,  type);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            picfile.transferTo(targetFile);
//            return  imgName;
        } catch (Exception e) {
            return "上传失败";
        }
        String url = IMGPATHHEAD + imgName;
        Items items = new Items(itemid,name, price,0, url);
        try {
            iItemsService.updateById(items);
        }catch (Exception e){
            return e.toString();
        }
        return "success";
    }



    @RequestMapping("/uploadImg")
    public String uploadImg(HttpServletRequest request,
                            @RequestParam("picfile") MultipartFile picfile,
                            @RequestParam("itemname") String itemname){
        if (picfile.isEmpty()){
            System.out.println("文件是空的");
        }
        try {
            String type = picfile.getOriginalFilename().substring(picfile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
            String imgName = itemname + type;
            System.out.println(imgName);
//            System.out.println(type);
//            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  type);
            File targetFile = new File("D:\\IDEA-pifaShop\\pifaShop\\src\\main\\resources\\static\\images" ,  imgName);
//            File targetFile = new File("src/main/resources/static/images" ,  type);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            picfile.transferTo(targetFile);
            return  imgName;
        } catch (Exception e) {
            return "上传失败";
        }

//        System.out.println("\nuploadImg被调用");
//        String filename = picfile.getOriginalFilename()+'.'+picfile.getContentType();
//        System.out.println(filename);
//        String path = "src/main/resources/static/images";
//        System.out.println(path);
////        File realpath = new File(path,filename);
//        return "200";
    }

    /**
     * 下架商品
     * @param request
     * @param itemid
     * @return
     */
    @RequestMapping("/takedown")
    public String takedown(HttpServletRequest request,
                           @RequestParam int itemid){
        UpdateWrapper<Items> uw = new UpdateWrapper<>();
        uw.eq("itemid",itemid).set("state",-1);
        iItemsService.updateState(itemid);
        return "success";
    }

    /**
     * 下架商品列表
     * @return
     */
    @RequestMapping("/takedownList")
    public String takedownList(){
        QueryWrapper<Items> qw = new QueryWrapper<>();
        qw.eq("state",-1);
        List<Items> list = iItemsService.list(qw);
        return JSON.toJSONString(list);
    }

    /**
     * 重新上架商品
     * @param request
     * @param itemid
     * @return
     */
    @RequestMapping("/onshelfAgain")
    public String onshelfAgain(HttpServletRequest request,
                               @RequestParam int itemid){
        UpdateWrapper<Items> uw = new UpdateWrapper<>();
        uw.eq("itemid",itemid).set("state",0);
        iItemsService.update(uw);
        return "success";
    }




//    private String getIMGPATHHEAD() throws Exception {
//        InetAddress lh = InetAddress.getLocalHost();
//        String localhost = lh.getHostAddress()+":8080";
//        return localhost;
//    }

}

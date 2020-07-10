package com.example.demo.controller;

import com.example.demo.service.impl.EventImageServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Controller
public class EventImageController {
    @Autowired
    EventImageServiceImpl eventImageService;

 /*   //获取数据库截图
    @ResponseBody
    @RequestMapping(value="event/image",method = RequestMethod.POST)
    public void gettImage(HttpServletResponse res, HttpServletRequest req) throws IOException {

        String id = req.getParameter("event_id");

        byte[] bytes = eventImageService.selectByPrimaryKey(Integer.parseInt(id)).getImage();


        res.setContentType("image/jpeg, image/jpg, image/png, image/gif");  //设置输出流内容格式为图片格式
        InputStream in1 = new ByteArrayInputStream(bytes);  //将字节流转换为输入流
        IOUtils.copy(in1, res.getOutputStream());//将字节从 InputStream复制到OutputStream中


    }*/
}

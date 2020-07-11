package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Event;
import com.example.demo.service.impl.EventServiceImpl;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;

import java.util.*;

@RestController
@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    //byte[]
    @RequestMapping(value="/event",method= RequestMethod.GET)
    public Object AllEvent(/*HttpServletResponse res*/){
        return eventService.selectAll();
    }

    @ResponseBody
    @RequestMapping(value="event/count",method = RequestMethod.POST)
    public Object SelectCount(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        for(int i=1;i<7;i++){
            String name = req.getParameter("old_name");
            int type = i;
            //{count1,10}
            jsonObject.put("count"+Integer.toString(type), eventService.select(name,type));
        }
        jsonObject.put("code", 1);
        jsonObject.put("msg", "查询成功");
        return jsonObject;

    }



/*    *//*
     * 图片1
     *//*
    //文件
    @ResponseBody
    @RequestMapping(value="event/image1",method = RequestMethod.POST)
    public void gettImage(HttpServletResponse res, HttpServletRequest req) throws IOException {

        String id = req.getParameter("event_id");

        byte[] bytes = eventService.selectByPrimaryKey(Integer.parseInt(id)).getImage();

        String fileName = id + ".png";

        fileName = URLEncoder.encode(fileName, "UTF-8");
        res.setHeader("Content-disposition", "attachment;filename=" + fileName);
        res.setContentType("image/jpeg, image/jpg, image/png, image/gif");  //设置输出流内容格式为图片格式
        InputStream in1 = new ByteArrayInputStream(bytes);  //将字节流转换为输入流
        IOUtils.copy(in1, res.getOutputStream());//将字节从 InputStream复制到OutputStream中

    }

    *//*
     *图片2
     *//*
    //base64
    @ResponseBody
    @RequestMapping(value="event/image2",method = RequestMethod.POST)
    public Object gettImage(HttpServletRequest req) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("event_id");
        Event e = eventService.selectByPrimaryKey(Integer.parseInt(id));
        if(e.getImage() != null) {
            String image = Base64String(e.getImage());
            jsonObject.put("event_id", id);
            jsonObject.put("image", image);
            jsonObject.put("code", 1);
            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","无法找到图片");
            return jsonObject;
        }
    }

    //表格格式
    @RequestMapping(value = "/event/excel", method = RequestMethod.GET)
    //@CrossOrigin(origins = "*", maxAge = 3600)
    public void eventExcel(HttpServletResponse response) {
        List<Event> list = eventService.selectAll() ;//查出数据库数据
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("events");//创建一张表
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue("id");
        titleRow.createCell(1).setCellValue("event_type");//第一列
        titleRow.createCell(2).setCellValue("event_date");
        titleRow.createCell(3).setCellValue("event_location");
        titleRow.createCell(4).setCellValue("event_desc");
        titleRow.createCell(5).setCellValue("oldperson_name");
        int cell = 1;
        for (Event event : list) {
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(event.getId());
            row.createCell(1).setCellValue(event.getEvent_type());//将数据库的数据遍历出来
            row.createCell(2).setCellValue(event.getEvent_date());
            row.createCell(3).setCellValue(event.getEvent_location());
            row.createCell(4).setCellValue(event.getEvent_desc());
            row.createCell(5).setCellValue(event.getOldperson_name());
            cell++;
        }

        String fileName = "events.xlsx";
        OutputStream outputStream = null;
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //byte[]转base64
    public static String Base64String(byte[] b){
        return Base64.encodeBase64String(b);
    }*/

    /*    //Event
    @ResponseBody
    @RequestMapping(value="event/search1",method = RequestMethod.POST)
    public Object SelectByPrimaryKey(HttpServletRequest req){

        String id = req.getParameter("event_id");

        return eventService.selectByPrimaryKey(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value="event/search2",method = RequestMethod.POST)
    public Object SelectByOldid(HttpServletRequest req){

        String name = req.getParameter("old_name");

        return eventService.selectByOld(name);
    }

    @ResponseBody
    @RequestMapping(value="event/search3",method = RequestMethod.POST)
    public Object SelectOldidtype(HttpServletRequest req){

        String name = req.getParameter("old_name");
        String type = req.getParameter("event_type");

        return eventService.select(name,Integer.parseInt(type));
    }

    @ResponseBody
    @RequestMapping(value="event/search4",method = RequestMethod.POST)
    public Object SelectByEventType(HttpServletRequest req){

        String type = req.getParameter("event_type");

        return eventService.selectByEventType(Integer.parseInt(type));
    }

    @ResponseBody
    @RequestMapping(value="event/search5",method = RequestMethod.POST)
    public Object SelectTypeNum(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        String type = req.getParameter("event_type");
        jsonObject.put("type",type);
        jsonObject.put("num",eventService.typenum(Integer.parseInt(type)));
        return jsonObject;
    }*/

}

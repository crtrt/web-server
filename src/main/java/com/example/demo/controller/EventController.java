package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Event;
import com.example.demo.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @RequestMapping(value="/event",method= RequestMethod.GET)
    public Object AllEvent(){ return eventService.selectAll(); }

    @ResponseBody
    @RequestMapping(value="event/search1",method = RequestMethod.POST)
    public Object SelectByPrimaryKey(HttpServletRequest req){

        String id = req.getParameter("event_id");

        return eventService.selectByPrimaryKey(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value="event/search2",method = RequestMethod.POST)
    public Object SelectByOldid(HttpServletRequest req){

        String id = req.getParameter("old_id");

        return eventService.selectByOldid(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value="event/search3",method = RequestMethod.POST)
    public Object SelectOldidtype(HttpServletRequest req){

        String id = req.getParameter("old_id");
        String type = req.getParameter("event_type");

        return eventService.select(Integer.parseInt(id),Integer.parseInt(type));
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
        jsonObject.put("num",eventService.typenum(Integer.parseInt(type)));
        return jsonObject;
    }



   /* @ResponseBody
    @RequestMapping(value="/event/insert",method = RequestMethod.POST)
    public Object addEvent(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Event event = new Event();

        String id = req.getParameter("event_id");
        String type = req.getParameter("event_type");
        String date = req.getParameter("event_date");
        String desc = req.getParameter("event_desc");
        String old_id = req.getParameter("old_id");

        Date eventdate = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            eventdate = sdf.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        event.setId(Integer.parseInt(id));
        event.setEvent_type(Integer.parseInt(type));
        event.setEvent_date(eventdate);
        event.setEvent_desc(desc);
        event.setOldperson_id(Integer.parseInt(old_id));

        boolean add = eventService.addEvent(event);
        if(add){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");
            return jsonObject;
        }

    }*/
}

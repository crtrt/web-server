package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Volunteer;
import com.example.demo.service.VolunteerService;
import com.example.demo.service.impl.VolunteerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
public class VolunteerController {

    @Autowired
    public VolunteerServiceImpl volunteerService;

    //义工列表
    @RequestMapping(value = "/volunteer", method = RequestMethod.GET)
    public Object Allperson(){return volunteerService.selectAll();}

    //查询义工信息
    @ResponseBody
    @RequestMapping(value="/volunteer/detail", method = RequestMethod.POST)
    public Object SearchPerson(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("vol_id");
        boolean check = volunteerService.checkbyPrimaryKey(Integer.parseInt(id));

        if(check) {
            jsonObject.put("code",1);
            jsonObject.put("volunteer",volunteerService.selectByPrimaryKey(Integer.parseInt(id)));

            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");
            return jsonObject;
        }
    }

    //添加义工
    @ResponseBody
    @RequestMapping(value="/volunteer/insert", method = RequestMethod.POST)
    public Object InsertPerson(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Volunteer vol = new Volunteer();

        int sum = volunteerService.getnum() + 1000001;
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String sysuserid = req.getParameter("id");

        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

        /*Timestamp birthday = Timestamp.valueOf(birth);

        String timeStr1 = df.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);*/

        java.util.Date birthday = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(birth);

        } catch (Exception e) {
            e.printStackTrace();
        }

        vol.setID(sum);
        vol.setORG_ID(sum);
        vol.setCLIENT_ID(sum);
        vol.setUsername(name);
        vol.setGender(gender);
        vol.setPhone(phone);
        vol.setId_card(idcard);
        vol.setBirthday(birthday);
        vol.setISACTIVE("1");
        vol.setCREATED(time);
        vol.setCREATEBY(Integer.parseInt(sysuserid));

        boolean insert = volunteerService.insertVolunteer(vol);
        if(insert){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            jsonObject.put("id",sum);

            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");

            return jsonObject;
        }
    }

    //删除义工
    @RequestMapping(value="/volunteer/delete", method = RequestMethod.POST)
    public Object Delete(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("vol_id");
        boolean delete = volunteerService.deleteVolunteer(Integer.parseInt(id));
        boolean check = volunteerService.checkbyPrimaryKey(Integer.parseInt(id));
        if(check&&delete){
            jsonObject.put("code",1);
            jsonObject.put("msg","删除成功");

            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");

            return jsonObject;

        }
    }

    //更新信息
    @ResponseBody
    @RequestMapping(value="/volunteer/detail/update",method=RequestMethod.POST)
    public Object UpdateByPrimaryKey(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Volunteer volunteer = new Volunteer();

        String id = req.getParameter("vol_id");
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String updateby = req.getParameter("id");//sysuser

        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

        /*Timestamp birthday = Timestamp.valueOf(birth);

        String timeStr1 = df.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);*/

        Date birthday = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(birth);

        } catch (Exception e) {
            e.printStackTrace();
        }

        volunteer.setUsername(username);
        volunteer.setGender(gender);
        volunteer.setPhone(phone);
        volunteer.setId_card(idcard);
        volunteer.setBirthday(birthday);
        volunteer.setUPDATED(time);
        volunteer.setUPDATEBY(Integer.parseInt(updateby));

        boolean updated = volunteerService.updateByPrimaryKey(Integer.parseInt(id),volunteer);
        if(updated){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改成功");

            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");

            return jsonObject;
        }

    }

}

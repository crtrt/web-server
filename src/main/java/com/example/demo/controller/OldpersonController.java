package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Oldperson;
import com.example.demo.service.OldpersonService;
import com.example.demo.service.impl.OldpersonServiceImpl;
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
public class OldpersonController {

    @Autowired
    private OldpersonServiceImpl oldpersonService;

    //老人列表
    @RequestMapping(value = "/oldperson", method = RequestMethod.GET)
    public Object Allperson(){return oldpersonService.selectAll();}

    //查询具体信息
    @ResponseBody
    @RequestMapping(value="/oldperson/detail", method = RequestMethod.POST)
    public Object SearchPerson(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        String id = req.getParameter("old_id");
        boolean check = oldpersonService.checkbyPrimaryKey(Integer.parseInt(id));

        if(check) {
            jsonObject.put("code",1);
            jsonObject.put("oldperson",oldpersonService.selectByPrimaryKey(Integer.parseInt(id)));
            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");
            return jsonObject;
        }
    }

    //添加老人
    @ResponseBody
    @RequestMapping(value="/oldperson/insert", method = RequestMethod.POST)
    public Object InsertPerson(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Oldperson old = new Oldperson();

        int sum = oldpersonService.getnum() + 1000001;
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String sysuserid = req.getParameter("id");

        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

     /*   Timestamp birthday = Timestamp.valueOf(birth);

        String timeStr1 = df.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);
*/
        Date birthday = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(birth);

        } catch (Exception e) {
            e.printStackTrace();
        }

        old.setID(sum);
        old.setORG_ID(sum);
        old.setCLIENT_ID(sum);
        old.setUsername(username);
        old.setGender(gender);
        old.setPhone(phone);
        old.setId_card(idcard);
        old.setBirthday(birthday);
        old.setISACTIVE("1");
        old.setCREATED(time);
        old.setCREATEBY(Integer.parseInt(sysuserid));

        boolean insert = oldpersonService.insertOldperson(old);
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

    //删除老人
    @ResponseBody
    @RequestMapping(value="/oldperson/delete", method = RequestMethod.POST)
    public Object Delete(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        String id = req.getParameter("old_id");
        boolean check = oldpersonService.checkbyPrimaryKey(Integer.parseInt(id));
        boolean delete = oldpersonService.deleteOldperson(Integer.parseInt(id));

        if(delete&&check) {
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

    //修改老人信息
    @ResponseBody
    @RequestMapping(value="/oldperson/detail/update",method=RequestMethod.POST)
    public Object UpdateByPrimaryKey(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        String id = req.getParameter("old_id");
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String roomnum = req.getParameter("room_number");
        String fguardianname = req.getParameter("fguardian_name");
        String fguardianrel = req.getParameter("fguardian_relationship");
        String fguardianphone = req.getParameter("fguardian_phone");
        String fguardianwechat = req.getParameter("fguardian_wechat");
        String sguardianname = req.getParameter("sguardian_name");
        String sguardianrel = req.getParameter("sguardian_relationship");
        String sguardianphone = req.getParameter("sguardian_phone");
        String sguardianwechat = req.getParameter("sguardian_wechat");
        String updateby = req.getParameter("id");//sysuser

        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

       /* Timestamp birthday = Timestamp.valueOf(birth);

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

        Oldperson old = new Oldperson();
        old.setUsername(username);
        old.setGender(gender);
        old.setPhone(phone);
        old.setId_card(idcard);
        old.setBirthday(birthday);
        old.setRoom_number(roomnum);
        old.setFirstguardian_name(fguardianname);
        old.setFirstguardian_relationship(fguardianrel);
        old.setFirstguardian_phone(fguardianphone);
        old.setFirstguardian_wechat(fguardianwechat);
        old.setSecondguardian_name(sguardianname);
        old.setSecondguardianr_relationship(sguardianrel);
        old.setFirstguardian_phone(sguardianphone);
        old.setSecondguardian_wechat(sguardianwechat);
        old.setUPDATED(time);
        old.setUPDATEBY(Integer.parseInt(updateby));

        boolean updated = oldpersonService.updateByPrimaryKey(Integer.parseInt(id),old);
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

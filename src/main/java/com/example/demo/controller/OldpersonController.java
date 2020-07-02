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
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController
@Controller
public class OldpersonController {

    @Autowired
    private OldpersonServiceImpl oldpersonService;

    @RequestMapping(value = "/oldperson", method = RequestMethod.GET)
    public Object Allperson(){return oldpersonService.selectAll();}

    @RequestMapping(value="/oldperson/search", method = RequestMethod.POST)
    public Object SearchPerson(HttpServletRequest req){
        String id = req.getParameter("id");
        return oldpersonService.selectByPrimaryKey(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping(value="/oldperson/update",method=RequestMethod.POST)
    public Object UpdateByPrimaryKey(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();

        String id = req.getParameter("id");
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
        String updateby = req.getParameter("sysUser_id");
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

        Oldperson old = new Oldperson();
        old.setUsername(username);
        old.setGender(gender);
        old.setPhone(phone);
        old.setId_card(idcard);
        //old.setBirthday(Date.valueOf(birth));
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

package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.domain.SysUser;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Controller
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sUserService;


    //    判断是否登录成功
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session) {
        JSONObject jsonObject = new JSONObject();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int id = sUserService.getsUserID(name,password);
        boolean res = sUserService.verifypasswd(name, password);
        if (res) {
            jsonObject.put("code", 1);
            //jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);
            jsonObject.put("msg",id);

            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }

    }

    // 注册
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object Register(HttpServletRequest req) {

        JSONObject jsonObject = new JSONObject();
        SysUser suser = new SysUser();

        int sam = sUserService.getUserNum() + 10001;
        String name = req.getParameter("name").trim();
        String pwd = req.getParameter("password").trim();
        String realname = req.getParameter("realname").trim();
        String sex = req.getParameter("sex").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String mobile = req.getParameter("mobile").trim();


        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        System.out.println(time);

        suser.setID(sam);
        suser.setORG_ID(sam);
        suser.setCLIENT_ID(sam);
        suser.setUserName(name);
        suser.setPassword(pwd);
        suser.setREAL_NAME(realname);
        suser.setSEX(sex);
        suser.setEMAIL(email);
        suser.setPHONE(phone);
        suser.setMOBILE(mobile);
        suser.setCREATED(time);

        //System.out.println(suser.getID()+"  "+suser.getUserName()+"  "+sex+"   "+phone+"     "+email+"      "+sex);
        sUserService.addSysUser(suser);
        jsonObject.put("code", 1);
        jsonObject.put("msg", "注册成功");
        return jsonObject;
    }

}

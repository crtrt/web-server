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

@Controller
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sUserService;

    @Autowired
    private SysUserMapper susermapper;

    //    判断是否登录成功
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session) {
        JSONObject jsonObject = new JSONObject();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        boolean res = sUserService.verifypasswd(name, password);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);

            System.out.println("!!!!!!");
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
    public Object Register(HttpServletRequest req, HttpSession session) {

        JSONObject jsonObject = new JSONObject();
        SysUser suser = new SysUser();

        int sam = susermapper.selectall() + 10000;
        String name = req.getParameter("name").trim();
        String pwd = req.getParameter("password").trim();
        String realname = req.getParameter("realname").trim();
        String sex = req.getParameter("sex").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String mobile = req.getParameter("mobile").trim();


        suser.setID(sam);
        suser.setUserName(name);
        suser.setPassword(pwd);
        suser.setREAL_NAME(realname);
        suser.setSEX(sex);
        suser.setEMAIL(email);
        suser.setPHONE(phone);
        suser.setMOBILE(mobile);

        sUserService.addSysUser(suser);

        jsonObject.put("code", 1);
        jsonObject.put("msg", "注册成功");
        return jsonObject;
    }

}

package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.SysUserMapper;
import com.example.demo.domain.SysUser;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@RestController
@Controller
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sUserService;

    @Value("${file.uploadFolder}")
    String uploadFolder;

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

            String imagepath = sUserService.selectByPrimaryKey(id).getLogoimage();
            session.setAttribute("name", name);
            jsonObject.put("code", 1);
            jsonObject.put("id",id);
            jsonObject.put("msg","登录成功");
            jsonObject.put("imagepath",imagepath);

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
    public Object Register(MultipartFile file, String fileName, HttpServletRequest req) throws IOException {

        JSONObject jsonObject = new JSONObject();
        SysUser suser = new SysUser();

        int sam = sUserService.getnum() + 10001;
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
        //System.out.println(time);


        InputStream in = file.getInputStream();
        File mkdir = new File(uploadFolder);
        if(!mkdir.exists()) {
            mkdir.mkdirs();
        }
        //定义输出流，将文件写入硬盘
        FileOutputStream os = new FileOutputStream(mkdir.getPath()+"\\" + fileName);
        int len = 0;
        while( (len = in.read()) != -1) {
            os.write(len);
        }
        os.flush(); //关闭流
        in.close();
        os.close();

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
        suser.setISACTIVE("1");//有效
        suser.setLogoimage(mkdir.getPath()+"\\"+name);

        //System.out.println(suser.getID()+"  "+suser.getUserName()+"  "+sex+"   "+phone+"     "+email+"      "+sex);
        boolean ad = sUserService.addSysUser(suser);
        if(ad) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "注册成功");
            return jsonObject;
        }
        else{
            jsonObject.put("code", 0);
            jsonObject.put("msg", "ERROR");
            return jsonObject;
        }
    }

    //update
    @ResponseBody
    @RequestMapping(value = "/sysuser/detail/update", method = RequestMethod.POST)
    public Object Update(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        SysUser suser = new SysUser();

        String id = req.getParameter("id").trim();
        String name = req.getParameter("name").trim();
        //String pwd = req.getParameter("password").trim();
        String realname = req.getParameter("realname").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String mobile = req.getParameter("mobile").trim();


        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
        //System.out.println(time);
        suser.setUserName(name);
        //suser.setPassword(pwd);
        suser.setREAL_NAME(realname);
        suser.setEMAIL(email);
        suser.setPHONE(phone);
        suser.setMOBILE(mobile);
        suser.setUPDATED(time);

        boolean updates = sUserService.updateByPrimaryKey(Integer.parseInt(id),suser);
        if(updates) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        }
        else{
            jsonObject.put("code", 0);
            jsonObject.put("msg", "ERROR");
            return jsonObject;
        }
    }

    @RequestMapping(value = "/sysuser", method = RequestMethod.GET)
    public Object AllSysUser(){ return sUserService.selectAll();}

    @RequestMapping(value="/sysuser/detail", method = RequestMethod.POST)
    public Object SearchSysUser(HttpServletRequest req){
        String id = req.getParameter("id");
        return sUserService.selectByPrimaryKey(Integer.parseInt(id));
    }

}

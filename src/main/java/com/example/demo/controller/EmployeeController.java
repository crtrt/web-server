package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.example.demo.domain.Employee;
import com.example.demo.service.impl.EmployeeServiceImpl;
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
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //工作人员列表
    @RequestMapping(value="/employee",method= RequestMethod.GET)
    public Object AllEmployee(){ return employeeService.selectAll(); }

    //工作人员信息
    @ResponseBody
    @RequestMapping(value="/employee/detail",method=RequestMethod.POST)
    public  Object EmployeeDetail(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("emp_id");
        boolean check = employeeService.checkbyPrimaryKey(Integer.parseInt(id));
        if(check) {
            jsonObject.put("code",1);
            jsonObject.put("employee",employeeService.selectByPrimaryKey(Integer.parseInt(id)));
            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");
            return jsonObject;
        }
    }

    //删除工作人员
    @ResponseBody
    @RequestMapping(value="/employee/delete",method=RequestMethod.POST)
    public Object DeleteByPrimaryKey(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("emp_id");
        boolean delete = employeeService.deleteByPrimaryKey(Integer.parseInt(id));
        boolean check = employeeService.checkbyPrimaryKey(Integer.parseInt(id));
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

    //添加工作人员
    @ResponseBody
    @RequestMapping(value="/employee/insert",method=RequestMethod.POST)
    public Object AddEmployee(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Employee emp = new Employee();

        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String hire = req.getParameter("hire_date");
        String sysuserid = req.getParameter("id");//系统管理员id

        int num = employeeService.getnum() + 1000001;

        //创建时间
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

/*
        //生日时间格式修改
        Timestamp birthday = Timestamp.valueOf(birth);
        String timeStr1 = df.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);


        //雇佣时间格式修改
        Timestamp hiredate = Timestamp.valueOf(hire);
        String timeStr2 = df.format(hiredate);
        hiredate = Timestamp.valueOf(timeStr2);
*/

        Date birthday = new Date();
        Date hiredate = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(birth);
            hiredate = sdf.parse(hire);

        } catch (Exception e) {
            e.printStackTrace();
        }

        emp.setID(num);
        emp.setORG_ID(num);
        emp.setCLIENT_ID(num);
        emp.setUsername(username);
        emp.setGender(gender);
        emp.setPhone(phone);
        emp.setId_card(idcard);
        emp.setBirthday(birthday);
        emp.setHire_date(hiredate);
        emp.setCREATED(time);
        emp.setISACTIVE("1");//有效
        emp.setCREATEBY(Integer.parseInt(sysuserid));//管理员id


        boolean insert = employeeService.insertEmployee(emp);
        if(insert){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            jsonObject.put("id",num);

            return jsonObject;
        }
        else{
            jsonObject.put("code",0);
            jsonObject.put("msg","ERROR");

            return jsonObject;
        }
    }

    //修改工作人员信息
    @ResponseBody
    @RequestMapping(value="/employee/detail/update",method=RequestMethod.POST)
    public Object UpdateDetail(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        Employee emp = new Employee();

        String id = req.getParameter("emp_id");
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String idcard = req.getParameter("id_card");
        String birth = req.getParameter("birthday");
        String resign = req.getParameter("resign_date");
        String sysuserid = req.getParameter("id");//系统管理员id

        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);

      /*  Timestamp birthday = Timestamp.valueOf(birth);

        String timeStr1 = df.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);

        Timestamp resigndate = Timestamp.valueOf(resign);

        String timeStr2 = df.format(resigndate);
        resigndate = Timestamp.valueOf(timeStr2);*/

        Date birthday = new Date();
        Date resigndate = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(birth);
            resigndate = sdf.parse(resign);
            //System.out.println(birthday.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        emp.setUsername(username);
        emp.setGender(gender);
        emp.setPhone(phone);
        emp.setId_card(idcard);
        emp.setBirthday(birthday);
        emp.setResign_date(resigndate);
        emp.setUPDATED(time);
        emp.setUPDATEBY(Integer.parseInt(sysuserid));

        boolean update = employeeService.updateByPrimaryKey(Integer.parseInt(id),emp);
        if(update){
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

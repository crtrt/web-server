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
import java.text.SimpleDateFormat;

@RestController
@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //工作人员列表
    @RequestMapping(value="/employee",method= RequestMethod.GET)
    public Object AllEmployee(){ return employeeService.selectAll(); }

    //工作人员信息
    @RequestMapping(value="/volunteer/detail",method=RequestMethod.POST)
    public  Object EmployeeDetail(HttpServletRequest req){
        String id = req.getParameter("emp_id");
        return employeeService.selectByPrimaryKey(Integer.parseInt(id));
    }

    //删除工作人员
    @ResponseBody
    @RequestMapping(value="/volunteer/delete",method=RequestMethod.POST)
    public Object DeleteByPrimaryKey(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("emp_id");
        boolean delete = employeeService.deleteByPrimaryKey(Integer.parseInt(id));
        if(delete) {
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
    @RequestMapping(value="/volunteer/insert",method=RequestMethod.POST)
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

        //生日时间格式修改
        Timestamp birthday = Timestamp.valueOf(birth);
        SimpleDateFormat df1 = new SimpleDateFormat("yy-MM-dd");
        String timeStr1 = df1.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);


        //雇佣时间格式修改
        Timestamp hireday = Timestamp.valueOf(hire);
        SimpleDateFormat df2 = new SimpleDateFormat("yy-MM-dd");
        String timeStr2 = df2.format(hireday);
        hireday = Timestamp.valueOf(timeStr2);

        emp.setID(num);
        emp.setORG_ID(num);
        emp.setCLIENT_ID(num);
        emp.setUsername(username);
        emp.setGender(gender);
        emp.setPhone(phone);
        emp.setId_card(idcard);
        emp.setBirthday(birthday);
        emp.setHire_date(hireday);
        emp.setCREATED(time);
        emp.setISACTIVE("1");//有效
        emp.setCREATEBY(Integer.parseInt(sysuserid));//管理员id

        boolean insert = employeeService.insertEmployee(emp);
        if(insert){
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");

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
    @RequestMapping(value="/volunteer/detail/update",method=RequestMethod.POST)
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

        Timestamp birthday = Timestamp.valueOf(birth);
        SimpleDateFormat df1 = new SimpleDateFormat("yy-MM-dd");
        String timeStr1 = df1.format(birthday);
        birthday = Timestamp.valueOf(timeStr1);

        Timestamp resignday = Timestamp.valueOf(resign);
        SimpleDateFormat df2 = new SimpleDateFormat("yy-MM-dd");
        String timeStr2 = df2.format(resignday);
        resignday = Timestamp.valueOf(timeStr2);

        emp.setUsername(username);
        emp.setGender(gender);
        emp.setPhone(phone);
        emp.setId_card(idcard);
        emp.setBirthday(birthday);
        emp.setResign_date(resignday);
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

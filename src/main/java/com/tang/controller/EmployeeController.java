package com.tang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.pojo.Employee;
import com.tang.pojo.Msg;
import com.tang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author tang
 * @create 2021-12-29-15:02
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {


    @Autowired
    public EmployeeService employeeService;


    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn" , defaultValue = "1") Integer pn){
        PageHelper.startPage(pn,5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps =  employeeService.getAll();
        // 使用PageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        // 封装了详细的分页信息,包括有我们查询出来的数据, 传入连续传入的页数
        PageInfo page = new PageInfo(emps,5);
        return Msg.success().add("pageInfo",page);
    }

    /**
     * @return
     * 查询员工数据(分页查询)
     */
//    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn" , defaultValue = "1") Integer pn, Model model){
        //引入PageHelper分页插件
        // 在查询之前只需要调用,传入页码,以及每页的大小
        PageHelper.startPage(pn,5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps =  employeeService.getAll();
        // 使用PageInfo包装查询后的结果,只需要将pageInfo交给页面就行了
        // 封装了详细的分页信息,包括有我们查询出来的数据, 传入连续传入的页数
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }

    /**
     * 员工保存
     */
    @RequestMapping(value = "/emp" , method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Employee employee){

        employeeService.saveEmp(employee);
        return Msg.success();

    }

    /**
     * 校验用户名冲突
     */
    @ResponseBody
    @RequestMapping("/checkuser")
    public Msg checkuser(@RequestParam("empName") String empName){
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }
}

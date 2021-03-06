package com.tang.controller;

import com.tang.pojo.Department;
import com.tang.pojo.Msg;
import com.tang.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author tang
 * @create 2021-12-29-20:56
 * 处理和部门有关的请求
 */

@Controller
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有的部门信息
     */

    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDepts(){

        // 查出的所有部门信息
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts",list);
    }

}

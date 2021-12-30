package com.tang.pojo;

import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer empId;

//    @NotNull(message = "员工姓名不能为空")
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{3,16}$)|(^[\\u2E80-\\u9FFF]{2,8}$)", message = "姓名格式错误, 必须是2-8位中文, 或3-16字母下划线数字")
    private String empName;

    private String empEmail;

    private String empGender;

    private Integer dId;

    private Department department;

    private static final long serialVersionUID = 1L;

    public Employee() {
    }

    public Employee(Integer empId, String empName, String empEmail, String empGender, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empGender = empGender;
        this.dId = dId;
    }

    public Employee(Integer empId, String empName, String empEmail, String empGender, Integer dId, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empEmail = empEmail;
        this.empGender = empGender;
        this.dId = dId;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empId=").append(empId);
        sb.append(", empName=").append(empName);
        sb.append(", empEmail=").append(empEmail);
        sb.append(", empGender=").append(empGender);
        sb.append(", dId=").append(dId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
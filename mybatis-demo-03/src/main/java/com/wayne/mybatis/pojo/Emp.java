package com.wayne.mybatis.pojo;

import java.io.Serializable;

/**
 * @author wayne
 * @date 2022-08-03 22:25
 */
public class Emp implements Serializable {
    private int eid;
    private String empName;
    private int age;
    private String sex;
    private String email;
    private Dept dept;

    public Emp() {
    }

    public Emp( String empName, int age, String sex, String email) {
        this.empName = empName;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                '}';
    }
}

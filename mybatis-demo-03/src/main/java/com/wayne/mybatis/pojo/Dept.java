package com.wayne.mybatis.pojo;

import java.util.List;

/**
 * @author wayne
 * @date 2022-08-03 22:30
 */
public class Dept {

    private int did;
    private String deptName;
    private List<Emp> empList;

    public Dept(int did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }
}

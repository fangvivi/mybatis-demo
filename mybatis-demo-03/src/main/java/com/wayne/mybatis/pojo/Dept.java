package com.wayne.mybatis.pojo;

/**
 * @author wayne
 * @date 2022-08-03 22:30
 */
public class Dept {

    private int did;
    private String deptName;

    public Dept(int did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
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
                '}';
    }
}

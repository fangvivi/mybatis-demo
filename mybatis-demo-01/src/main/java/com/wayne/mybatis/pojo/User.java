package com.wayne.mybatis.pojo;


/**
 * @author wayne
 */
public class User {

  /**
   * 用户id
   */
  private int id;
  /**
   * 用户名
   */
  private String username;
  /**
   * 用户密码
   */
  private String password;
  /**
   * 年龄
   */
  private int age;
  /**
   * 性别
   */
  private String sex;
  /**
   * 电子邮箱
   */
  private String email;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}

/*
 * UserInfo class
 * 用户信息实体类
 * @author Sirius
 * @date 2020-07-13 19:32
 */
package com.sirius.domain;

public class UserInfo {
    private Integer id;
    private String name;
    private String sex;
    private String tel;
    private String vip;
    private String email;
    private String address;

    public UserInfo(){}
    public UserInfo(Integer id, String name, String sex, String tel, String vip, String email, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.vip = vip;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

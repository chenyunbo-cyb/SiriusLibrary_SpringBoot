/*
 * UserLogin class
 * 登录信息实体类
 * @author Sirius
 * @date 2020-07-13 19:35
 */
package com.sirius.domain;

import java.util.Date;

public class UserLogin {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private Date lasttime;

    public UserLogin(Integer id, String username, String password, String salt, Date lasttime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.lasttime = lasttime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }
}

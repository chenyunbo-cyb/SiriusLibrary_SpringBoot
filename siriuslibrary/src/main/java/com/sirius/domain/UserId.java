/*
 * Demo class
 * 用户id操作实体类
 * @author Sirius
 * @date 2020-07-14 17:15
 */
package com.sirius.domain;

public class UserId {
    private Integer id;
    // flag为id状态，1表示正在使用已经被注册；0表示空闲未被使用；2表示冻结
    private Integer flag;

    public UserId(Integer id, Integer flag) {
        this.id = id;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}

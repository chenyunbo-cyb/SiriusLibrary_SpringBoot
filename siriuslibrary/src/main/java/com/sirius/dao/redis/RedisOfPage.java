/*
* 操作页面元素的redis数据库接口
* */

package com.sirius.dao.redis;

public interface RedisOfPage {
    Object set(String key, Object value);
    Object get(String key);
}

/*
 * PublicPage
 * 描述
 @author Sirius
 */
package com.sirius.service.impls;

import com.sirius.service.interfaces.PublicPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class PublicPageImpl implements PublicPageService {

    // 自动注入Redis组件
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String enterNum() {
        String get = stringRedisTemplate.opsForValue().get("total_in");  // 获取total_in的值
        if (get == null){
            stringRedisTemplate.opsForValue().set("total_in", "1");    // 如果为空，则创建，值为1.
        }else {
            stringRedisTemplate.opsForValue().increment("total_in"); // 如果不为空，则加1
        }
        return stringRedisTemplate.opsForValue().get("total_in");    // 取出值并返回
    }
}

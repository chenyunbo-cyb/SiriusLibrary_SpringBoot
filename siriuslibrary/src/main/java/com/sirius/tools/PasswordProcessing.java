package com.sirius.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;

@Component
public class PasswordProcessing {
    // 指定哈希算法方式为SHA1，可修改
    private static final String algorithm = "SHA1";
    private static final Charset charset = StandardCharsets.UTF_8;
    // 盐值取值字符串
    private static final String saltList = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //  附加生成盐值功能，返回加盐后的hash值
    public HashMap<String, String> hash(String input) {
        if (input.isEmpty()) {
            return null;
        }
        HashMap<String, String> result = new HashMap<>();
        String salt = this.getSalt();
        // 加盐组成新的密码，盐值加在用户输入的密码后面
        String passwordWithSalt = input + salt;
        // 结果返回HashMap，其中pw为哈希后的密码，salt为盐值。
        result.put("pw", this.getHash(passwordWithSalt));
        result.put("salt", salt);
        return result;
    }

    // 手动添加盐值，返回加盐后的hash
    public String hash(String input, String salt) {
        if (input.isEmpty() || salt.isEmpty()) {
            return null;
        }
        String passwordWithSalt = input + salt;
        return this.getHash(passwordWithSalt);
    }

    // 私有方法，生成盐值
    private String getSalt() {
        StringBuilder salt = new StringBuilder();
        Random random = new Random();
        // 获取盐值取值字符串的长度
        int saltListLength = saltList.length();
        // 盐值长度为10个字符串
        for (int i = 0; i < 11; i++) {
            // 随机数模块取随机数，得到盐值取值字符串随机索引，然后取值
            int choice = random.nextInt(saltListLength);
            char x = saltList.charAt(choice);
            salt.append(x);
        }
        return salt.toString();
    }

    // 私有方法，获取哈希值
    private String getHash(String input) {
        MessageDigest hash = null;
        try {
            hash = MessageDigest.getInstance(algorithm);
            // 将字符串使用utf-8转换成bytes数组
            byte[] confirm = input.getBytes(charset);
            // 将上面生成的数组传入算法，生成消息摘要bytes数组，----------主算法1
            byte[] bytes = hash.digest(confirm);
            StringBuilder hashPassword = new StringBuilder();
            // 遍历消息摘要数组，将元素利用哈希算法转换成哈希值，生成一个字符串，这个字符串的长度为2
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                // 如果长度为1，前面加个0
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                // 结果存入
                hashPassword.append(temp);
            }
            return hashPassword.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

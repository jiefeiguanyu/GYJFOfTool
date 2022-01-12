package cn.jcj.tool.string;

import cn.jcj.emnu.RandomCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2022/1/8 11:28   @author 关于皆非  @version 1.00
 * Description 生成随机码的工具类
 */
public class RandomCodeTool {

    /**
     * 将字符集合拼接
     *
     * @param list 字符集合
     * @return 字符串
     */
    public static String listAsString(List<Character> list) {
        StringBuilder t = new StringBuilder();
        for (Character c : list) {
            t.append(c);
        }
        return t.toString();
    }

    /**
     * 通过枚举选择自带的随机码库并指定长度生成随机码
     *
     * @param randomCode 随机码库的枚举。例：RandomCode.NRC.getCode()
     * @param length     指定生成随机码的长度
     * @return 完整的随机码
     */
    public static String getRandomCode(RandomCode randomCode, Integer length) {
        return getRandomCode(randomCode.getCode(), length);
    }

    /**
     * 指定字符串和长度生成随机码
     *
     * @param randomString 自定义采集随机码库
     * @param length       随机码生成的长度
     * @return 随机码
     */

    public static String getRandomCode(String randomString, Integer length) {
        if (randomString == null || randomString.equals("") || length == null || length == 0) {
            return "";
        }
        char[] chars = randomString.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add((chars[(int) Math.floor(Math.random() * chars.length)]));
        }
        return listAsString(list);
    }


}
/*
 *        更新日志 有BUG加Q2476535821
 * 1.0 2022/1/8
 * 创建RandomCodeTool类
 * 加入listAsString方法
 * 加入getRandomCode方法及一些重载
 * 加入相关枚举
 */

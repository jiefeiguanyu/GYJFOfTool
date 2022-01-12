package cn.jcj.tool.string;

import cn.jcj.tool.number.NumberTool;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/12/7 20:07   @author jcj  @version 1.00
 * Description 字符串工具
 */
@Component
public class StringTool {
    /**
     * 补零
     *
     * @param str       要补零的字符串
     * @param length    补零后字符串的长度
     * @param frontBack true为前补零，false为后补零
     * @return 返回补充后的String对象
     * <p>
     * 数字的小数位补零可参考：{@link NumberTool}
     */
    public static String zeroFill(String str, Integer length, boolean frontBack) {
        return frontBack ? String.format("%0" + length + "d", Integer.parseInt(str)) : FillString(str, length, "0", false);
    }

    /**
     * 让指定字符串前后补充到字符串的指定长度（类似于补零）
     *
     * @param str       要进行长度补充的字符串
     * @param length    指定字符串补充完成后的长度
     * @param word      指定要补充的字符
     * @param frontBack true为前补充，false为后补充
     * @return 返回补充后的String
     */
    public static String FillString(String str, Integer length, String word, boolean frontBack) {
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < length) {
            if (frontBack)
                sb.insert(0, word);
            else
                sb.append(word);
        }
        return sb.toString();
    }

    /**
     * 解析像身份证那样的数字转为LocalDate
     *
     * @param str 要转换的数字字符串
     * @return 返回一个LocalDate
     */
    public static LocalDate dateStringAnalysis(String str) {
        int year = Integer.parseInt(str.substring(0, 4));
        int month = Integer.parseInt(str.substring(4, 6));
        int day = Integer.parseInt(str.substring(6));
        return LocalDate.of(year, month, day);
    }


    /*
     *
     * -------------------实例方法区-----------------------
     * 将静态方法以实例方法调用，然后整个工具类整合到GYJFOfTool中方便自动注入调用
     *
     *
     * */

    public String zeroFillExample(String str, Integer length, boolean frontBack) {
        return StringTool.zeroFill(str, length, frontBack);
    }

    public String FillStringExample(String str, Integer length, String word, boolean frontBack) {
        return StringTool.FillString(str, length, word, frontBack);
    }

    public LocalDate dateStringAnalysisExample(String str) {
        return StringTool.dateStringAnalysis(str);
    }


}
/*
 *     更新日志 有BUG加Q2476535821
 * 1.0 2021/12/7
 * 创建StringTool类
 * 加入zeroFill方法及实例
 * 加入FillString方法及实例
 * 加入dateStringAnalysis方法及实例
 */
package cn.jcj.tool.number;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2022/1/4 16:50   @author jcj  @version 1.00
 * Description 对数字的长度、小数进行操作。
 */
public class NumberTool {

    /**
     * 格式化数字
     *
     * @param number       任意一个数字
     * @param mid          设置数字的最大整数长度（直接截断）
     * @param nid          设置数字的最小整数长度
     * @param mfd          设置数字的最大小数长度（直接截断），默认为3
     * @param nfd          设置数字的最小小数长度
     * @param locale       设置这个数字的单位
     * @param groupingUsed 是否启用逗号作为千位分隔符
     * @return 数字字符串
     */
    public static String numberFormatting(Number number, Integer mid, Integer nid, Integer mfd, Integer nfd, Locale locale, Boolean groupingUsed) {
        NumberFormat currencyInstance;
        if (locale != null) {
            currencyInstance = NumberFormat.getInstance(locale);
        } else {
            currencyInstance = NumberFormat.getInstance();
        }
        //设置是否使用千位分隔符（到千位时一个逗号）
        currencyInstance.setGroupingUsed(groupingUsed != null ? groupingUsed : false);

        if (mfd != null) {
            //限制数字的最大小数长度（直接截断）
            currencyInstance.setMaximumFractionDigits(mfd);
        }
        if (nfd != null) {
            //限制数字的最小小数长度
            currencyInstance.setMinimumFractionDigits(nfd);
        }
        if (mid != null) {
            //限制数字的最大整数长度（直接截断）
            currencyInstance.setMaximumIntegerDigits(mid);
        }
        if (nid != null) {
            //设置数字的最小整数长度
            currencyInstance.setMinimumIntegerDigits(nid);
        }

        return currencyInstance.format(number);
    }

    public static String numberFormatting(Number number, Integer mid, Integer nid, Integer mfd, Integer nfd) {
        return numberFormatting(number, mid, nid, mfd, nfd, null, false);
    }

    /**
     * 对小数位补零
     *
     * @param number 任意一个数字
     * @param length 小数位补零后的长度
     * @return 小数位补零后的字符串
     */
    public static String decimalZeroPadding(Number number, int length) {
        return numberFormatting(number, null, null, null, length);
    }

    /**
     * 整数位前补零，在整数的最左边补零
     *
     * @param number 任意一个数字
     * @param length 整数位补零后的长度
     * @return 整数位补零后的字符串
     */
    public static String addZeroBeforeInteger(Number number, int length) {
        return numberFormatting(number, null, length, null, null);
    }


}
   /*
    *       更新日志 有BUG加Q2476535821
    *
    *  1.00 2022/1/4
    *  创建NumberTool类。
    *  加入numberFormatting方法及一些重载
    *  加入addZeroBeforeInteger方法
    *  加入decimalZeroPadding方法
    *
    */

package cn.jcj.emnu;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2022/1/8 11:23   @author jcj  @version 1.00
 * Description 随机码库枚举
 */
public enum RandomCode {
    /**
     * 0-9的数字
     */
    NRC("1234567890"),
    /**
     * 26字母大小写组合
     */
    ARC("abcdefghijklmnopqrstuvwxyzANCDEFGHIZKLMNOPQRSTUVWXYZ"),
    /**
     * 26个字母大写
     */
    ARCUP("ANCDEFGHIZKLMNOPQRSTUVWXYZ"),
    /**
     * 26个字母小写
     */
    ARCLO("abcdefghijklmnopqrstuvwxyz"),
    /**
     * 数字、26字母大小写组合
     */
    ALL("abcdefghijklmnopqrstuvwxyzANCDEFGHIZKLMNOPQRSTUVWXYZ1234567890");

    String code;

    RandomCode(String code) {
        this.code = code;
    }

    /**
     * 获取随机码
     *
     * @return 随机码
     */
    public String getCode() {
        return code;
    }
}

package cn.jcj.emnu;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/11/4 13:46   @author 关于皆非  @version 1.00
 * Description Stream需要用到的枚举（虽然没有必要）
 */
public enum Sort {
    ASC("正序", true),
    DESC("倒序", false);

    String str;
    boolean boole;

    Sort() {
    }

    Sort(String str, boolean boole) {
        this.str = str;
        this.boole = boole;
    }

    public String getStr() {
        return str;
    }

    public boolean isBoole() {
        return boole;
    }
}

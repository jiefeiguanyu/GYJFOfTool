package cn.jcj.tool.stream;

import cn.jcj.emnu.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/8/23 13:02   @author  关于皆非  @version 4.01
 * <br>描述： StreamTool工具类，通过反射来实现
 */
@Component
public class StreamTool {

    //当传入的属性名无效时，排序失败的次数
    static Integer errorCount = 0;

    /**
     * @param list          需要排序的集合
     * @param attributeName 指定通过那个属性升序
     * @param sort          StreamTool自带的枚举选项，用来选择升序或降序
     * @param <T>           返回list的类型
     * @author : 关于皆非
     * @since: Description: 升序排序（最小的值在上面）
     */
    public static <T> void sort(List<T> list, String attributeName, Sort sort) {

        List<T> collect = null;

        collect = list.stream().sorted(getSorted(attributeName, sort)).collect(Collectors.toList());

        System.out.println((errorCount > 0 ? "出现错误！给予的属性可能不存在！尝试次数：" + errorCount : "排序成功！"));
        list.clear();
        list.addAll(collect);

    }

    private static <T> Comparator<T> getSorted(String attributeName, Sort sort) {

        return (s1, s2) -> {
            try {
                Field declaredField = s1.getClass().getDeclaredField(attributeName);
                declaredField.setAccessible(true);
                Field declaredField1 = s2.getClass().getDeclaredField(attributeName);
                declaredField1.setAccessible(true);
                  if (
                        (declaredField.getType() == Integer.class && declaredField1.getType() == Integer.class)
                                ||
                                (declaredField.getType() == int.class && declaredField1.getType() == int.class)) {
                    Integer i = (Integer) declaredField.get(s1);
                    Integer i1 = (Integer) declaredField1.get(s2);
                    return (sort == Sort.ASC ? i.compareTo(i1) : i1.compareTo(i));
                } else if (
                        (declaredField.getType() == Double.class && declaredField1.getType() == Double.class)
                                ||
                                (declaredField.getType() == double.class && declaredField1.getType() == double.class)) {
                    Double i = (Double) declaredField.get(s1);
                    Double i1 = (Double) declaredField1.get(s2);
                    return (sort == Sort.ASC ? i.compareTo(i1) : i1.compareTo(i));
                } else if (
                        (declaredField.getType() == Float.class && declaredField1.getType() == Float.class)
                                ||
                                (declaredField.getType() == float.class && declaredField1.getType() == float.class)) {
                    Float i = (Float) declaredField.get(s1);
                    Float i1 = (Float) declaredField1.get(s2);
                    return (sort == Sort.ASC ? i.compareTo(i1) : i1.compareTo(i));
                }

                return 0;
            } catch (ClassCastException e) {
                errorCount++;
                return 0;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return 0;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return 0;
            } catch (Exception e) {
                errorCount++;
                return 0;
            }
        };
    }


    /**
     * @param list          一个要查找的list
     * @param attributeName 要查找的对应属性名
     * @param filterString  模糊查找的条件
     * @param <T>           返回list的类型
     * @return List
     * @author : 关于皆非
     * @since: 一个模糊查询方法，需要给它一个list、要查找的属性名称、模糊查询关键字
     */
    public static <T> List<T> filterQuery(List<T> list, String attributeName, String filterString) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<T> tList = list.stream().filter(c -> {
            try {
                Class<?> aClass = c.getClass();
                Field declaredField = aClass.getDeclaredField(attributeName);
                declaredField.setAccessible(true);
                String o = null;
                try {
                    o = (String) declaredField.get(c);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return o.contains(filterString);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        }).collect(Collectors.toList());
        return tList;
    }

    /**
     * 它是简单的使用stream进行分页，返回一个StreamPage
     *
     * @param list      要进行分页的list集合
     * @param pageIndex 当前页数
     * @param pageSize  每页大小
     * @param <O>       分页对象的类型
     * @return StreamPage
     */
    public static <O> StreamPage<O> pageStream(List<O> list, Integer pageIndex, Integer pageSize) {

        StreamPage<O> streamPage = new StreamPage<>();
        streamPage.setPageNumber(pageIndex != null ? pageIndex : 1);
        streamPage.setPageSize(pageSize != null ? pageSize : 4);
        if (list == null || list.size() == 0) {
            return streamPage;
        }
        streamPage.setTotal(list.size());

        //单精度或者双精度数相除或者是和整数相除才会进行除尽操作，否则整数和整数相除只会向下取整
        streamPage.setPageCount((int) Math.ceil((double) streamPage.getTotal() / (double) pageSize));
        Integer starNumber = (pageIndex - 1) * pageSize;
        Integer endNumber = starNumber + pageSize;
        //Stream的skip与第一个的limit是界定一个分页范围，第二个limit是用来解决有时starNumber小于endNumber的时候出现的一个严重漏洞
        List<O> collect = list.stream().skip(starNumber).limit(endNumber).limit(pageSize).collect(Collectors.toList());
        streamPage.setList(collect);
        return streamPage;
    }
    /*
     *
     * -------------------实例方法区-----------------------
     * 将静态方法以实例方法调用，然后整个工具类整合到GYJFOfTool中方便自动注入调用
     *
     *
     * */
    public <T> void sortExample(List<T> list, String attributeName, Sort sort) {
        StreamTool.sort(list, attributeName, sort);
    }

    public <T> List<T> filterQueryExample(List<T> list, String attributeName, String filterString) {
        return StreamTool.filterQuery(list, attributeName, filterString);
    }

    public <O> StreamPage<O> pageStreamExample(List<O> list, Integer pageIndex, Integer pageSize) {
        return StreamTool.pageStream(list, pageIndex, pageSize);
    }


    /*
     *       更新日志
     * 4.01
     * 设置分页的默认值和非空判断
     *
     *
     * 4.0
     * 新增实例化方法
     * 新增StreamPage的方法
     *
     *
     * 3.0
     * 现在可以使用这个工具对list进行分页啦！返回一个StreamPage类型 2021/10/25
     *
     *
     * 2.0
     * 修复无法对doube类型等非Integer类型排序的问题
     * 优化一些奇奇怪怪的操作
     *
     *
     *
     * */
}

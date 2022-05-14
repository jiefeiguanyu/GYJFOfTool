package cn.jcj.tool.list;

import java.util.List;

/**
 * @since 2022/2/10 10:29   @author jcj  @version 1.00
 * Description 集合工具
 */
public class ListTool {
    /**
     * 判断数组是否为空
     *
     * @return 如果数组为空时返回true，否则返回false
     */
    public boolean isEmpty(List<?> list){
        return list==null||list.size() == 0;
    }
}

/*
 *        更新日志 有BUG加Q2476535821
 * 1.0 2022/5/14
 * 创建ListTool类
 * 加入isEmpty方法
 */
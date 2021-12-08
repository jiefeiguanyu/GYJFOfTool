package cn.jcj.tool.stream;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/10/25 16:22   @author  jcj  @version 1.00
 * Description StreamPage通过Stream实现分页的分页类
 */
public class StreamPage<O> implements Serializable {
    //当前页码
    private Integer pageNumber;
    //每页大小
    private Integer pageSize;
    //总记录数（总条数）
    private Integer total;
    //总页数
    private Integer pageCount;
    //集合
    private List<O> list;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<O> getList() {
        return list;
    }

    public void setList(List<O> list) {
        this.list = list;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

/*    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            declaredField.setAccessible(true);
            try {
                sb.append(declaredField.getName()).append("=").append(declaredField.get(declaredField));
            } catch (IllegalAccessException e) {
                System.out.println("错误！非法访问！"+e.getMessage());
            }
            if(declaredFields.length-1==i){
              sb.append("}");
            }else {
                sb.append(",");
            }
        }
        return sb.toString();
    }*/

    @Override
    public String toString() {
        return "StreamPage{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pageCount=" + pageCount +
                ", list=" + list +
                '}';
    }
}

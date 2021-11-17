package cn.jcj.tool.jsr303;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

/**
 * @since 2021/10/26   @author  关于皆非  @version 2.00
 * Description 用来处理对象检查格式的工具类
 */
@Component
public class ValidatedTool {

    /**
     * <br>
     * 检查传过来的BindingResult对象，如果判定为异常，那么将会返回错误信息(一个HashMap)
     * 否则返回一个null
     *
     * @param br 需要一个BindingResult对象
     * @return HashMap
     */
    public static HashMap validatedPattern(BindingResult br) {
        HashMap<String, String> map = new HashMap<String, String>();
        if (br.hasErrors()) {

            List<FieldError> fieldErrors = br.getFieldErrors();

            for (FieldError f : fieldErrors) {

                String fgf = f.getField();

                String fdm = f.getDefaultMessage();

                map.put(fgf, fdm);
            }
            return map;
        }


        return null;
    }

    /*
     *
     * -------------------实例方法区-----------------------
     * 将静态方法以实例方法调用，然后整个工具类整合到GYJFOfTool中方便自动注入调用
     *
     *
     * */

   public HashMap validatedPatternExample(BindingResult br){
       return ValidatedTool.validatedPattern(br);
   }


    /*
     *       更新日志
     * 2.00
     * 创建实例方法
     *
     * 1.00
     * 新增了validatedPattern方法，简化了操作
     *
     *
     *
     * */

}

package cn.jcj.specificTools.ICardAnalysis;


import cn.jcj.tool.string.StringTool;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/12/7 9:46   @author jcj  @version 1.00
 * Description 身份证解析工具 1.00
 */
@Component
public class IDCardAnalysis {

    public static AnalysisResult analysis(String cardNo) {
        if (StringUtils.isEmpty(cardNo)) return null;
        StringBuilder sb = new StringBuilder(cardNo);
        String pi = sb.substring(0, 6);
        String placeIdentity = AdministrativeCB.analysisCode(pi);
        LocalDate dateBirth = StringTool.dateStringAnalysis(sb.substring(6, 14));
        String orderCode = sb.substring(14, 17);
        String checkCode = sb.substring(sb.length() - 1);
        return new AnalysisResult(pi, dateBirth, orderCode, checkCode, Integer.parseInt(orderCode) % 2 == 0 ? "1" : "2", placeIdentity);
    }
}


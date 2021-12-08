package cn.jcj.specificTools.ICardAnalysis;

import java.time.LocalDate;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/12/7 9:49   @author jcj  @version 1.00
 * Description 一个对身份证解析的返回结果
 */
public class AnalysisResult {

    /**
     * 身份证归属地号码(6位)
     */
    private String placeIdentityCode;
    /**
     * 出生日期(8位)
     */
    private LocalDate dateBirth;
    /**
     * 顺序码(3位)
     */
    private String orderCode;
    /**
     * 校验码(1位)
     */
    private String checkCode;
    /**
     * 性别
     */
    private String sexAnalysis;
    /**
     * 归属地解析
     */
    private String placeIdAnalysis;

    public AnalysisResult() {
    }

    public AnalysisResult(String placeIdentityCode, LocalDate dateBirth, String orderCode, String checkCode, String sexAnalysis, String placeIdAnalysis) {
        this.placeIdentityCode = placeIdentityCode;
        this.dateBirth = dateBirth;
        this.orderCode = orderCode;
        this.checkCode = checkCode;
        this.sexAnalysis = sexAnalysis;
        this.placeIdAnalysis = placeIdAnalysis;
    }

    public AnalysisResult(LocalDate dateBirth, String sexAnalysis, String placeIdAnalysis) {
        this.dateBirth = dateBirth;
        this.sexAnalysis = sexAnalysis;
        this.placeIdAnalysis = placeIdAnalysis;
    }

    public String getPlaceIdentityCode() {
        return placeIdentityCode;
    }

    public void setPlaceIdentityCode(String placeIdentityCode) {
        this.placeIdentityCode = placeIdentityCode;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getSexAnalysis() {
        return sexAnalysis;
    }

    public void setSexAnalysis(String sexAnalysis) {
        this.sexAnalysis = sexAnalysis;
    }

    public String getPlaceIdAnalysis() {
        return placeIdAnalysis;
    }

    public void setPlaceIdAnalysis(String placeIdAnalysis) {
        this.placeIdAnalysis = placeIdAnalysis;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "placeIdentityCode='" + placeIdentityCode + '\'' +
                ", dateBirth=" + dateBirth +
                ", orderCode='" + orderCode + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", sexAnalysis='" + sexAnalysis + '\'' +
                ", placeIdAnalysis='" + placeIdAnalysis + '\'' +
                '}';
    }
}

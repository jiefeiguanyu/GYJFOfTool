package cn.jcj;

import cn.jcj.specificTools.ICardAnalysis.AdministrativeCB;
import cn.jcj.specificTools.ICardAnalysis.IDCardAnalysisTool;
import cn.jcj.tool.jsr303.ValidatedTool;
import cn.jcj.tool.redis.RedisDataTool;
import cn.jcj.tool.stream.StreamTool;

import cn.jcj.tool.string.StringTool;
import org.springframework.context.annotation.Configuration;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/11/6 8:34   @author jcj  @version 1.00
 * Description 将所有工具集成在一起
 */
@Configuration
public class GYJFOfTool {

    private StreamTool streamTool;

    private ValidatedTool validatorTool;

    private RedisDataTool redisDataTool;

    private StringTool stringTool;

    private IDCardAnalysisTool idCardAnalysisTool;

    private AdministrativeCB administrativeCB;

    /**
     * 获得AdministrativeCB的实例
     *
     * @return AdministrativeCB
     */
    public AdministrativeCB getAdministrativeCB() {
        if (administrativeCB == null) administrativeCB = new AdministrativeCB();
        return administrativeCB;
    }

    /**
     * 获得IDCardAnalysis的实例
     *
     * @return IDCardAnalysis
     */
    public IDCardAnalysisTool getIdCardAnalysisTool() {
        if (idCardAnalysisTool == null) idCardAnalysisTool = new IDCardAnalysisTool();
        return idCardAnalysisTool;
    }

    /**
     * 获得StringTool的实例
     *
     * @return StringTool
     */
    public StringTool getStringTool() {
        if (stringTool == null) stringTool = new StringTool();
        return stringTool;
    }

    /**
     * 获得StreamTool的实例
     *
     * @return StreamTool
     */
    public StreamTool getStreamTool() {
        if (streamTool == null) streamTool = new StreamTool();
        return streamTool;
    }

    /**
     * 获得ValidatedTool的实例
     *
     * @return ValidatedTool
     */
    public ValidatedTool getValidatorTool() {
        if (validatorTool == null) validatorTool = new ValidatedTool();
        return validatorTool;
    }

    /**
     * 获得RedisDataTool的实例
     *
     * @return RedisDataTool
     */
    public RedisDataTool getRedisDataTool() {
        if (redisDataTool == null) redisDataTool = new RedisDataTool();
        return redisDataTool;
    }


}

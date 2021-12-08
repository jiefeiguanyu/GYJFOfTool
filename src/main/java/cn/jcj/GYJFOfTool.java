package cn.jcj;

import cn.jcj.tool.jsr303.ValidatedTool;
import cn.jcj.tool.redis.RedisDataTool;
import cn.jcj.tool.stream.StreamTool;

import org.springframework.stereotype.Component;

/**
 * https://github.com/jiefeiguanyu/GYJFOfTool
 * https://mvnrepository.com/artifact/io.github.jiefeiguanyu/GYJFOfTool
 *
 * @since 2021/11/6 8:34   @author jcj  @version 1.00
 * Description 将所有工具集成在一起
 */

@Component
public class GYJFOfTool {

    private StreamTool streamTool;

    private ValidatedTool validatorTool;

    private RedisDataTool redisDataTool;

    public StreamTool getStreamTool() {
        if (streamTool == null) {
            streamTool = new StreamTool();
        }
        return streamTool;
    }

    public ValidatedTool getValidatorTool() {
        if (validatorTool == null) {
            validatorTool = new ValidatedTool();
        }
        return validatorTool;
    }

    public RedisDataTool getRedisDataTool() {
        if (redisDataTool == null) {
            redisDataTool = new RedisDataTool();
        }
        return redisDataTool;
    }

}

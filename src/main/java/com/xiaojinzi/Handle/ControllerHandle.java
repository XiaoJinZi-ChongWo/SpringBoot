package com.xiaojinzi.Handle;

import com.xiaojinzi.Exception.GirlException;
import com.xiaojinzi.domain.Result;
import com.xiaojinzi.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 内容异常捕捉
 * Created by JQ on 2017/9/7.
 */
@ControllerAdvice
public class ControllerHandle {

    private final static Logger logger = LoggerFactory.getLogger(ControllerHandle.class);
    /**
     * 控制层异常捕捉机制
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ExceptionHandle(Exception e){
        if(e instanceof GirlException){
            return ResultUtil.erro(((GirlException) e).getCode(),e.getMessage());
        }else {
            logger.info("系统异常 {}",e.getMessage());
            return ResultUtil.erro(-1, "未知错误");
        }
    }

}

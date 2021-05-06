package com.stef.user.common.exception;

import com.stef.common.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RespBean handler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        ObjectError objectError = result.getAllErrors().stream().findFirst().get();
        log.error("实体校验异常：{}", objectError.getDefaultMessage());
        return RespBean.error(objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public RespBean handler(IllegalArgumentException e) {
        log.error("Assert异常：{}", e.getMessage());
        return RespBean.error(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public RespBean handler(BadSqlGrammarException e) {
        log.error("SQL异常：{}", e.getMessage());
        return RespBean.error("服务器内部异常,请稍后再试.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public RespBean handler(RuntimeException e) {
        log.error("运行时异常：{}", e.getMessage());
        return RespBean.error(e.getMessage());
    }


}

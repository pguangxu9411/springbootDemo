package com.gg.errorcatch;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorCatchDemo {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> resultError(){
        Map<String ,Object> result=new HashMap<String, Object>();
        result.put("errorCode","500");
        result.put("errorMsg","系统异常");
        return result;
    }
}

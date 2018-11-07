package com.gg.errorcatch;

import com.gg.utils.ResponseUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorCatch implements ErrorController {
    @RequestMapping("/error")
    public ResponseUtil handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        String errorcode = request.getAttribute("javax.servlet.error.status_code").toString();

        return new ResponseUtil(-1, "错误" + errorcode);

    }

    @Override
    public String getErrorPath() {
        return "/error";

    }
}
package com.gg.errorcatch;

import com.gg.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorCatch implements ErrorController {
    public static Logger logger = LoggerFactory.getLogger(ErrorCatch.class);

    @RequestMapping("/error")
    public ResponseUtil handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        String errorcode = request.getAttribute("javax.servlet.error.status_code").toString();
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String objmsg = null == throwable ? "" : throwable.getMessage();
        logger.info("错误代码================>>>:"+errorcode);
        logger.info("错误信息================>>>:"+objmsg);
        return new ResponseUtil(-1, "错误" + errorcode, objmsg);

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}

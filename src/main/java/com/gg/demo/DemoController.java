package com.gg.demo;


import com.gg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/test")
    public String test(){
        int a= 1/0;
        return "Controller测试成功";
    }
    @RequestMapping("/getDsMsg")
    public ResponseUtil getDsMsg(){

        return  new ResponseUtil(1,"success",demoService.getDsMsg());
    }
}

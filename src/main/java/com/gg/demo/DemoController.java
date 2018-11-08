package com.gg.demo;


import com.gg.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping("/test")
    public String test(){
        return "Controller测试成功";
    }

    /*
       数据库连接测试
     */
    @RequestMapping("/getDsMsg")
    public ResponseUtil getDsMsg(){

        return  new ResponseUtil(1,"success",demoService.getDsMsg());
    }
    /*
        普通参数传递
     */
    @RequestMapping("/paramDemo")
    public ResponseUtil paramDemo(String param,String param2){

        return  new ResponseUtil(1,"success","参数值："+param+":"+param2);
    }
    /*
        Map传递
     */
    @RequestMapping(
            value = "mapDemo",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseUtil mapDemo(@RequestBody Map<String, Object> map) {
        return new ResponseUtil(1,"success","参数值："+map.toString());
    }
    /*
        对象传递
     */
    @RequestMapping(
            value = "objDemo",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseUtil objDemo(@RequestBody UserVo userVo) {
        return new ResponseUtil(1,"success","参数值："+userVo.getUsername()+":"+userVo.getPassword());
    }
}

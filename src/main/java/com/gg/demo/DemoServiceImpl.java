package com.gg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DemoServiceImpl implements DemoService{
    @Autowired
    DemoDao demoDao;
    @Override
    public List getDsMsg(){

        return demoDao.getDsMsg();
    }
}

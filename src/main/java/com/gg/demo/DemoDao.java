package com.gg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemoDao {
    @Autowired
    @Qualifier("mysqlJT")
    JdbcTemplate mjt;
    @Autowired
    @Qualifier("oracleJT")
    JdbcTemplate ojt;

    public List getDsMsg(){
        List mLi=mjt.queryForList("select * from test",new Object[]{});
        List oLi=ojt.queryForList("select * from test",new Object[]{});
        mLi.add(oLi);
        return mLi;
    }
}

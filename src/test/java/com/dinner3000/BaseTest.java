package com.dinner3000;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.nio.charset.Charset;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class BaseTest {
    @Autowired
    protected DataSource dataSource;

//    Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setUp() throws Exception {

        try {
            ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
            Resources.setCharset(Charset.forName("UTF-8"));
            runner.setLogWriter(null);
            runner.runScript(Resources.getResourceAsReader("init.sql"));
            runner.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
    }

}

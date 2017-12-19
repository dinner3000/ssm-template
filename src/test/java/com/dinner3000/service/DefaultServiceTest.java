package com.dinner3000.service;

import com.dinner3000.BaseTest;
import com.dinner3000.model.Info;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultServiceTest extends BaseTest {

    @Autowired
    private DefaultService defaultService;

    @Test
    public void getList() throws Exception {
        List<String> list = defaultService.getList();
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void queryList() throws Exception {
        List<String> list = defaultService.queryList();
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void getInfo() throws Exception {
        Info infoExpected = new Info();
        Info infoActual = defaultService.getInfo();
        Assert.assertTrue(infoActual.equals(infoExpected));
    }

}
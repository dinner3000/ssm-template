package com.dinner3000.service;

import com.dinner3000.mybatis.generated.inf.ListMapper;
import com.dinner3000.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultService {
    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        return list;
    }

    @Autowired
    private ListMapper listMapper;

    public List<String> queryList(){
        List<String> list = listMapper.selectAll();
        return list;
    }

    public Info getInfo(){
        return new Info();
    }

}

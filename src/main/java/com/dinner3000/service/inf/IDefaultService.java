package com.dinner3000.service.inf;

import com.dinner3000.model.Info;

import java.util.List;

public interface IDefaultService {
    List<String> getList();

    List<String> queryList();

    Info getInfo();

}

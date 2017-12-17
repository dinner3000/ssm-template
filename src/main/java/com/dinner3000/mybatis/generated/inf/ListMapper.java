package com.dinner3000.mybatis.generated.inf;

import com.dinner3000.mybatis.generated.model.List;

public interface ListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(List record);

    int insertSelective(List record);

    List selectByPrimaryKey(Integer id);
    java.util.List<String> selectAll();

    int updateByPrimaryKeySelective(List record);

    int updateByPrimaryKey(List record);
}
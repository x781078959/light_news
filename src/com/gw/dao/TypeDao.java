package com.gw.dao;

import com.gw.pojo.NewsType;

import java.util.List;

/**
 * ClassName: TypeDao
 * PackageName: com.gw.dao
 * Description:
 * @ Author: 谢金宸
 * @ Create: 2023.4.14 - 上午 9:57
 * @ Version: 1.0
 */
public interface TypeDao {

    //查询所有类别
    List<NewsType> queryAllType();
    //添加类别
    int addType(String typeName);
    //根据id删除类别
    int deleteTypeById(int id);
    //根据id查询类别
    NewsType selectTypeById(int id);
    //根据id修改类别
    int modifyTypeById(int id, String typeName);
    //根据名称查询类别……
    NewsType selectTypeByName(String name);
}

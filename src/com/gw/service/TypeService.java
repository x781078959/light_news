package com.gw.service;

import com.gw.criteria.PageBean;
import com.gw.pojo.NewsType;

import java.util.List;

/**
 * ClassName: TypeService
 * PackageName: com.gw.service
 * Description: 类别业务的接口
 *
 * @Author: 谢金宸
 * @Create: 2023.4.19 - 上午 8:40
 * @Version: 1.0
 */
public interface TypeService {
    //查询所有类别
    public List<NewsType> queryAllType();

    //添加类别(1.成功 >0 2.失败 =0 3.类别名已存在 <0)
    public int addType(String typeName);

    //根据id删除类别(删除新闻表单中此id的新闻，删除此id的类别) 事务！
    public int deleteType(int id);
    //根据id修改类别
    public int updateType(int id, String typeName);
    //根据id查询类别
    public NewsType queryTypeById(int id);
    long queryAllTypeCount(PageBean pageBean);
}

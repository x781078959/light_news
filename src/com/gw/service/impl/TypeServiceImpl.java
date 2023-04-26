package com.gw.service.impl;

import com.gw.dao.TypeDao;
import com.gw.dao.impl.TypeDaoImpl;
import com.gw.pojo.NewsType;
import com.gw.service.TypeService;

import java.util.List;

/**
 * ClassName: TypeServiceImpl
 * PackageName: com.gw.service.impl
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.4.19 - 上午 9:04
 * @Version: 1.0
 */
public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao = new TypeDaoImpl();

    @Override
    public List<NewsType> queryAllType() {
        return typeDao.queryAllType();
    }

    @Override
    public int addType(String typeName) {
        //检查此名称的类别是否存在，如果存在直接返回-1
        List<NewsType> list = typeDao.queryAllType();
        for (NewsType each : list) {
            if (each.getTypeName().equals(typeName)) {
                return -1;
            }
        }
        if (typeDao.selectTypeByName(typeName) != null) {
            return -1;
        }
        return typeDao.addType(typeName);
    }

    @Override
    public int deleteType(int id) {
        return 0;
    }

    @Override
    public int updateType(int id, String type) {
        return 0;
    }

    @Override
    public NewsType queryTypeById(String id) {
        return null;
    }
}

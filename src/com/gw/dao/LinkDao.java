package com.gw.dao;

import com.gw.pojo.LinkVo;

import java.util.List;

/**
 * ClassName: LinkDao
 * PackageName: com.gw.dao
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 10:48
 * @Version: 1.0
 */
public interface LinkDao {
    List<LinkVo> getAllLinks();

    int deleteLinkById(int i);

    LinkVo queryLinkById(int i);

    int updateLink(LinkVo linkVo);

    int addLink(LinkVo linkVo);
}

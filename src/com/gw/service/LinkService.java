package com.gw.service;

import com.gw.pojo.LinkVo;

import java.util.List;

/**
 * ClassName: LinkService
 * PackageName: com.gw.service
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 10:57
 * @Version: 1.0
 */
public interface LinkService {
    List<LinkVo> getAllLinks();

    int deleteLinkById(int i);

    LinkVo queryLinkById(int i);

    int updateLink(LinkVo linkVo);

    int addLink(LinkVo linkVo);
}

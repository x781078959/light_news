package com.gw.service.impl;

import com.gw.dao.LinkDao;
import com.gw.dao.impl.LinkDaoImpl;
import com.gw.pojo.LinkVo;
import com.gw.pojo.NewsType;
import com.gw.service.LinkService;

import java.util.List;

/**
 * ClassName: LinkServiceImpl
 * PackageName: com.gw.service.impl
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 10:57
 * @Version: 1.0
 */
public class LinkServiceImpl implements LinkService {
    private LinkDao linkDao = new LinkDaoImpl();
    @Override
    public List<LinkVo> getAllLinks() {
        return linkDao.getAllLinks();
    }
    @Override
    public int deleteLinkById(int i) {
        return linkDao.deleteLinkById(i);
    }

    @Override
    public LinkVo queryLinkById(int i) {
        return linkDao.queryLinkById(i);
    }

    @Override
    public int updateLink(LinkVo linkVo) {
        List<LinkVo> list = linkDao.getAllLinks();
        for (LinkVo each : list) {
            if (each.getLinkName().equals(linkVo.getLinkName())) {
                return -1;
            }
        }
        return linkDao.updateLink(linkVo);
    }

    @Override
    public int addLink(LinkVo linkVo) {
        List<LinkVo> list = linkDao.getAllLinks();
        for (LinkVo each : list) {
            if (each.getLinkName().equals(linkVo.getLinkName())) {
                return -1;
            }
        }
        return linkDao.addLink(linkVo);
    }
}

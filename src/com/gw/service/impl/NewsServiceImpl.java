package com.gw.service.impl;

import java.util.List;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.dao.NewDao;
import com.gw.dao.impl.NewDaoImpl;
import com.gw.service.NewsService;
import com.gw.pojo.NewsVo;

public class NewsServiceImpl implements NewsService {

	private NewDao newDao = new NewDaoImpl();

	@Override
	public List<NewsVo> queryNewsByPage(NewsSearch newsSearch, PageBean pageBean) {
		return newDao.selectNewsByPage(newsSearch, pageBean);
	}

	@Override
	public long queryNewsCount(NewsSearch newsSearch) {
		// TODO Auto-generated method stub
		return newDao.selectNewsCount(newsSearch);
	}

	@Override
	public int deleteNewsById(int id) {
		return newDao.deleteNewsById(id);
	}
}

package com.gw.service.impl;

import java.util.List;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.dao.NewDao;
import com.gw.dao.impl.NewDaoImpl;
import com.gw.pojo.News;
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

	@Override
	public int addNews(News news) {
		return newDao.addNews(news);
	}

	@Override
	public int updateNews(News news) {
		return newDao.updateNewsById(news);
	}

	@Override
	public News queryNewsById(int id) {
		return newDao.selectNewsById(id);
	}

	@Override
	public int newsClick(int newsId) {
		return newDao.newsClick(newsId);
	}

	@Override
	public boolean existNewByTypeId(int typeId) {
		return newDao.existNewByTypeId(typeId);
	}

	@Override
	public List<News> newestNewsList() {
		return newDao.newestNewsList();
	}

	@Override
	public List<News> hotNewsList() {
		return newDao.hotNewsList();
	}

	@Override
	public List<NewsVo> allIndexNewsList(int typeId) {
		return newDao.allIndexNewsList(typeId);
	}

}

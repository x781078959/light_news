package com.gw.dao;

import java.util.List;

import com.gw.criteria.NewsSearch;
import com.gw.criteria.PageBean;
import com.gw.pojo.News;
import com.gw.pojo.NewsVo;

public interface NewDao {
	
	//根据条件（新闻名称？，起始时间？，终止时间？）分页查询新闻
	 List<NewsVo> selectNewsByPage(NewsSearch newsSearch,PageBean pageBean);
	
	//根据条件（新闻名称？ ，起始时间？， 终止时间？， 类别id？，）查询
	long  selectNewsCount(NewsSearch newsSearch);

	int addNews(News news);

	int deleteNewsById(int id);

	News selectNewsById(int id);
	int updateNewsById(News news);

	/**
	 * 最近更新新闻
	 * @return
	 */
	 List<News> newestNewsList();

	/**
	 * 热点新闻
	 * @return
	 */
	 List<News> hotNewsList();

	/**
	 * 根据新闻类型获取新闻
	 * @return
	 */
	 List<NewsVo> allIndexNewsList(int typeId);
	/**
	 * 查询新闻表中是否有此类别的新闻
	 * @param typeId
	 * @return
	 */
	 boolean existNewByTypeId(int typeId);

	/**
	 * 访问量
	 * @param newsId
	 * @return
	 */
	 int newsClick(int newsId);

}

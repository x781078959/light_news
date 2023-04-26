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
	
}

package com.xuel.manager.service;

import com.xuel.manager.po.DatagridResult;

public interface NetEaseNewsService {
	 public DatagridResult queryNetEaseNewsList(Integer page, Integer rows);
}

package com.xuel.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuel.manager.mapper.NeteasenewsMapper;
import com.xuel.manager.po.DatagridResult;
import com.xuel.manager.po.Neteasenews;
import com.xuel.manager.po.NeteasenewsExample;
import com.xuel.manager.po.User;
import com.xuel.manager.po.UserExample;
@Service
public class NetEaseNewsServiceImpl implements NetEaseNewsService{
	@Autowired
	NeteasenewsMapper neteasenewsMapper;
	@Override
	public DatagridResult queryNetEaseNewsList(Integer page, Integer rows) {
		//初始化分页 信息
				PageHelper.startPage(page, rows);
				
				NeteasenewsExample example = new NeteasenewsExample();
				//执行statement
				 List<Neteasenews> list = neteasenewsMapper.selectByExample(example);
				
				PageInfo<Neteasenews> pageinfo = new PageInfo<>(list);
				
				long total = pageinfo.getTotal();
				
				DatagridResult result = new DatagridResult();
				result.setRows(list);
				result.setTotal(total);
				
				return result;
	}
	
}

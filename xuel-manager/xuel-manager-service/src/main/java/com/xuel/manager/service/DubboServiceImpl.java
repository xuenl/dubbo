package com.xuel.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuel.manager.mapper.UserMapper;
import com.xuel.manager.po.DatagridResult;
import com.xuel.manager.po.User;
import com.xuel.manager.po.UserExample;

@Service	
public class DubboServiceImpl implements DubboService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public List show() {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameLike("%xiaohui%");
		List<User> list = userMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 使用分页插件PageHelper的话，不需要修改原有的业务sql，比如业务sql为：select * from table
	 * Statement中包含sql语句，请求参数、结果类型
	 * 分页插件，将sql语句拦截，添加分页处理，也就是给sql添加limit 语句
	 * Mysql
	 * <p>Title: queryItemList</p>
	 * <p>Description: </p>
	 * @param page
	 * @param rows
	 * @return
	 * @see com.xuel.manager.service.DubboService#queryItemList(java.lang.Integer, java.lang.Integer)
	 */
	
	@Override
	public DatagridResult queryuserList(Integer page, Integer rows) {
		//初始化分页 信息
		PageHelper.startPage(page, rows);
		
		UserExample example = new UserExample();
		//执行statement
		List<User> list = userMapper.selectByExample(example);
		
		PageInfo<User> pageinfo = new PageInfo<>(list);
		
		long total = pageinfo.getTotal();
		
		DatagridResult result = new DatagridResult();
		result.setRows(list);
		result.setTotal(total);
		
		return result;
	}

	@Override
	public List<User> finduserList() {
		UserExample example = new UserExample();
		//执行statement
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

}

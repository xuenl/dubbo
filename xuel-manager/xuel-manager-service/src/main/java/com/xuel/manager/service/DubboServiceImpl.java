package com.xuel.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuel.manager.mapper.UserMapper;
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

}

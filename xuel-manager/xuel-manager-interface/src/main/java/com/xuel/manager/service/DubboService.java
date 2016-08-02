package com.xuel.manager.service;

import java.util.List;

import com.xuel.manager.po.DatagridResult;
import com.xuel.manager.po.User;

public interface DubboService {
 
 public List show();

 public DatagridResult queryuserList(Integer page, Integer rows);

 public List<User> finduserList();

}

package com.xuel.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xuel.manager.po.DatagridResult;
import com.xuel.manager.po.User;
import com.xuel.manager.service.DubboService;

@RequestMapping("/user")
@Controller
public class UserController {
	@Autowired
	private DubboService service;

	/**
	 * 请求URL：/user/list 请求参数：String page，Integer rows
	 * ，page和rows都是easyui分页控件提供的请求参数，其中page默认为1 ，rows是通过pagesize属性赋值的，也就是30
	 * 请求返回值：json格式 Easyui要求的json数据格式。{total:100,rows:[{},{}]}
	 * 定义pojo来存储结果对象：DatagridResult对象，它包括Long total、List tows属性。 业务逻辑：
	 * 1、根据page和rows进行分页查询，需要使用pageHelper插件进行分页处理
	 * 2、需要将查询的商品信息，封装到DatagridResult对象中，并且返回。
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/userlist")
	public ModelAndView velocityTest(
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		DatagridResult d = service.queryuserList(page, rows);
		List<User> userList = d.getRows();
		// 创建模型视图对象

		ModelAndView modelAndView = new ModelAndView();
		long total = d.getTotal() % rows == 0 ? d.getTotal() / rows : d
				.getTotal() / rows + 1;
		int prevPage = page == 1 ? 1 : page - 1;
		int afterPage = page == (int) total ? (int) total : page + 1;
		// 向模型和视图中添加数据用户返回给页面
		modelAndView.addObject("userList", userList)//
				.addObject("page", page)//
				.addObject("prevPage", prevPage)//
				.addObject("afterPage", afterPage)//
				.addObject("total", total);//

		modelAndView.setViewName("userlist");

		return modelAndView;
	}
}

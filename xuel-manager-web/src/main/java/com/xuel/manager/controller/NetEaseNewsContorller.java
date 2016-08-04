package com.xuel.manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xuel.manager.po.DatagridResult;
import com.xuel.manager.po.Neteasenews;
import com.xuel.manager.service.NetEaseNewsService;

@RequestMapping("/netEaseNews")
@Controller
public class NetEaseNewsContorller {
	@Autowired
	NetEaseNewsService service;

	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		DatagridResult d = service.queryNetEaseNewsList(page, rows);
		List<Neteasenews> list = d.getRows();
		// 创建模型视图对象

		ModelAndView modelAndView = new ModelAndView();
		long total = d.getTotal() % rows == 0 ? d.getTotal() / rows : d
				.getTotal() / rows + 1;
		int prevPage = page == 1 ? 1 : page - 1;
		int afterPage = page == (int) total ? (int) total : page + 1;
		List pageRange = new ArrayList();
		if (total - page >= 10) {
			for (int i = 0; i < 10; i++) {
				pageRange.add(page + i);
			}
		} else {
			for (int i = 0; i <= total - page; i++) {
				pageRange.add(page + i);
			}
		}
		// 向模型和视图中添加数据用户返回给页面
		modelAndView.addObject("list", list)//
				.addObject("page", page)//
				.addObject("prevPage", prevPage)//
				.addObject("afterPage", afterPage)//
				.addObject("pageRange", pageRange)//
				.addObject("total", total);//

		modelAndView.setViewName("list");

		return modelAndView;
	}

}

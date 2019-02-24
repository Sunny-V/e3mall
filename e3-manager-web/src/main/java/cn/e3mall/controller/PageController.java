package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author 神秘V
 *
 */
@Controller
public class PageController {
	
	//跳转到后台首页
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	//后台菜单项页面展示
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	
}

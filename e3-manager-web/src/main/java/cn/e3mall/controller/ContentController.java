package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

/**
 * 内容管理Controller
 */
@Controller
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	/**
	 * 添加内容
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/content/save", method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(TbContent content) {
		//调用服务把内容数据保存到数据库
		E3Result e3Result = contentService.addContent(content);
		return e3Result;
	}
	/**
	 * 更新内容的Handle
	 * 
	 * @param content
	 * @return 更新的结果
	 */
	@RequestMapping("/content/update")
	@ResponseBody
	public E3Result updateContent(TbContent content) {
		E3Result result = contentService.updateContent(content);
		return result;
	}
	/**
	 * 内容管理列表查询的Handle
	 * 
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(long categoryId, int page, int rows) {
		EasyUIDataGridResult content = contentService.getContentList(categoryId, page, rows);
		return content;
	}
	/**
	 * 删除内容
	 * 
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/content/delete")
	@ResponseBody
	public E3Result deleteContent(@RequestParam("ids") long[] itemId) {
		E3Result result = contentService.deleteContent(itemId);
		return result;
	}

}

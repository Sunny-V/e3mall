package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * @author 神秘V
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//调用服务查询商品列表
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	/**
	 * 商品添加
	 */
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addItem(TbItem item,String desc) {
		E3Result result = itemService.addItem(item, desc);
		return result;
	}
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public String getItemDescById(@PathVariable("itemId")Long itemId){
		return JsonUtils.objectToJson(itemService.getItemDescById(itemId));
	}	
	
	@RequestMapping("/rest/item/update")
	@ResponseBody
	public String updateItem(TbItem item, String desc){
		return JsonUtils.objectToJson(itemService.updateItem(item, desc));
	}
	
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public String deleteItems(String ids){
		return JsonUtils.objectToJson(itemService.deleteItems(ids));
	}
	
}

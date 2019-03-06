package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

public interface ItemService {

	/**
	 * 根据商品id查询商品接口
	 */
	TbItem getItemById(long itemId);

	/**
	 * 根据商品id查询商品描述信息
	 */
	TbItemDesc getItemDescById(long itemId);

	/**
	 * 获取商品类目表的接口
	 */
	EasyUIDataGridResult getItemList(int page, int rows);

	/**
	 * 保存商品到数据库的方法
	 */
	E3Result addItem(TbItem item, String desc);

	/**
	 * 删除商品的方法（包括商品描述）
	 */
	E3Result deleteItem(long[] itemId);

	/**
	 * 商品下架
	 */
	E3Result dropoffItem( long[] itemId, TbItem item);

	/**
	 * 商品上架
	 */
	E3Result upperoffItem( long[] itemId, TbItem item);
}
	


package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbContent;

/**
 * 内容管理的相关接口（包括新增、更新、删除、内容列表查询等方法的接口）
 * @author 神秘V
 *
 */
public interface ContentService {
	// 添加内容
	E3Result addContent(TbContent content);
	// 根据内容分类id查询内容列表
	List<TbContent> getContentListByCid(long cid);
	// 删除内容
	E3Result deleteContent( long[] contentId);
	// 更新内容
	E3Result updateContent(TbContent content);
	// 根据内容分类id查询内容列表
	EasyUIDataGridResult getContentList(long categoryId, int page, int rows);
}

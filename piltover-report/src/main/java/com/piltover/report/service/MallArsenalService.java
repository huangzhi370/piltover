package com.piltover.report.service;

import com.github.pagehelper.PageInfo;
import com.piltover.report.entity.MallArsenal;
import com.piltover.report.entity.MallMessageBoard;

public interface MallArsenalService {
	/**
	 * 藏宝阁
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageInfo<MallArsenal> getArsenalList(Integer pageSize,Integer pageNo);
	
	/**
	 * 留言板
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public PageInfo<MallMessageBoard> getMessageList(Integer pageSize,Integer pageNo);
	
	/**
	 * 留言
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public void saveMessageBoard(MallMessageBoard mallMessageBoard);
}

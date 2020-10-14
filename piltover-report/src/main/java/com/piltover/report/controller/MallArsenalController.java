package com.piltover.report.controller;


import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.piltover.common.utils.BeanUtils;
import com.piltover.report.dto.PageDto;
import com.piltover.report.entity.MallArsenal;
import com.piltover.report.entity.MallMessageBoard;
import com.piltover.report.service.MallArsenalService;

import io.seata.tm.api.GlobalTransactionContext;

@RestController
@RequestMapping("/arsenal")
public class MallArsenalController {
	
	@Autowired
	private MallArsenalService mallArsenalService;
	
	
	@RequestMapping("/getArsenalList")
	public PageInfo<MallArsenal> getArsenalList(@RequestBody PageDto pageDto){
		return mallArsenalService.getArsenalList(pageDto.getPageSize(), pageDto.getPageNum());
	}
	
	@RequestMapping("/getMessageList")
	public PageInfo<MallMessageBoard> getMessageList(@RequestBody PageDto pageDto){
		return mallArsenalService.getMessageList(pageDto.getPageSize(), pageDto.getPageNum());
	}
	
	@RequestMapping("/saveMessageBoard")
	public void saveMessageBoard(@RequestBody Map<String, String> paramData){
		String xid = GlobalTransactionContext.getCurrentOrCreate().getXid();
		System.out.println("----------------------"+xid);
		MallMessageBoard mallMessageBoard=new MallMessageBoard();
		try {
			BeanUtils.mapToUser(paramData, mallMessageBoard);
			mallMessageBoard.setCrtTime(new Date());
			mallArsenalService.saveMessageBoard(mallMessageBoard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

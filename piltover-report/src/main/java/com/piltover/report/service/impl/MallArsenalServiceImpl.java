package com.piltover.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.piltover.report.dao.MallArsenalMapper;
import com.piltover.report.dao.MallMessageBoardMapper;
import com.piltover.report.entity.MallArsenal;
import com.piltover.report.entity.MallMessageBoard;
import com.piltover.report.entity.MallMessageBoardExample;
import com.piltover.report.service.MallArsenalService;

@Service
public class MallArsenalServiceImpl implements MallArsenalService {
	
		@Autowired
		private MallArsenalMapper mallArsenalMapper;
		
		@Autowired
		private MallMessageBoardMapper mallMessageBoardMapper;
	
		public PageInfo<MallArsenal> getArsenalList(Integer pageSize,Integer pageNo){
			PageHelper.startPage(pageNo,pageSize);
			List<MallArsenal> arseList=mallArsenalMapper.selectByExample(null);
			PageInfo<MallArsenal> pageInfo = new PageInfo<>(arseList);
			return pageInfo;
		}

		@Override
		public PageInfo<MallMessageBoard> getMessageList(Integer pageSize, Integer pageNo) {
			PageHelper.startPage(pageNo,pageSize);
			MallMessageBoardExample ex=new MallMessageBoardExample();
			ex.setOrderByClause("CRT_TIME DESC");
			List<MallMessageBoard> arseList=mallMessageBoardMapper.selectByExample(ex);
			PageInfo<MallMessageBoard> pageInfo = new PageInfo<>(arseList);
			return pageInfo;
		}

		@Override
		public void saveMessageBoard(MallMessageBoard mallMessageBoard) {
			mallMessageBoardMapper.insert(mallMessageBoard);
		}
}

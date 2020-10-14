package com.piltover.report.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.piltover.report.dao.MallArsenalMapper;
/**
 * 系统启动的时候去请求下 防止第一次访问卡顿
 * @author Administrator
 *
 */
@Component
public class CodeCache {
	
	@Autowired
	private MallArsenalMapper mallArsenalMapper;
	
	@PostConstruct
	public void init(){
		mallArsenalMapper.selectByPrimaryKey(1);
		
	}
}

package com.piltover.user.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.piltover.user.dao.MallUserLogMapper;
/**
 * 系统启动的时候去请求下 防止第一次访问卡顿
 * @author Administrator
 *
 */
@Component
public class CodeCache {
	
	@Autowired
	private MallUserLogMapper mallUserLogMapper;
	
	@PostConstruct
	public void init(){
		System.out.println("初始化------------------------");
		mallUserLogMapper.selectByPrimaryKey(1);
		System.out.println("初始化------------------------");
	}
}

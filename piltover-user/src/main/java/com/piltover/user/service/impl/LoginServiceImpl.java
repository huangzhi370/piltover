package com.piltover.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.piltover.user.dao.MallUserDetailMapper;
import com.piltover.user.dao.MallUserInfoMapper;
import com.piltover.user.dao.MallUserLogMapper;
import com.piltover.user.entity.MallMenuInfo;
import com.piltover.user.entity.MallUserDetail;
import com.piltover.user.entity.MallUserDetailExample;
import com.piltover.user.entity.MallUserInfo;
import com.piltover.user.entity.MallUserInfoExample;
import com.piltover.user.entity.MallUserLog;
import com.piltover.user.service.LoginService;
import com.piltover.user.service.MallArsenalFegin;

import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
    private MallUserInfoMapper mallUserInfoMapper;
	
	@Autowired
    private MallUserDetailMapper mallUserDetailMapper;
	
	@Autowired
	private MallUserLogMapper mallUserLogMapper;
	
	@Autowired
	private MallArsenalFegin mallArsenalFegin;

	@Override
	public List<MallMenuInfo> getMenu(String userName){
		// TODO Auto-generated method stub
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("userName", userName);
		List<MallMenuInfo> allMenu=	mallUserInfoMapper.queryMenu(paramMap);
		return allMenu;
	}

	@Override
	public MallUserDetail getMallMallUserInfo(String username) {
		MallUserDetailExample ex=new MallUserDetailExample();
		ex.createCriteria().andUserNameEqualTo(username);
		// TODO Auto-generated method stub
		List<MallUserDetail> userDetailList=mallUserDetailMapper.selectByExample(ex);
		return userDetailList.get(0);
	}

	@Override
	public List<MallUserDetail> getUserList() {
		List<MallUserDetail> userDetailList=mallUserDetailMapper.selectByExample(null);
		return userDetailList;
	}

	@Override
	@GlobalTransactional(name = "fsp_create_message",rollbackFor = Exception.class)
	public void saveInfo(Map<String, String> param) {
		String xid = GlobalTransactionContext.getCurrentOrCreate().getXid();
		System.out.println("--------------------"+xid);
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MallUserInfoExample ex=new MallUserInfoExample();
		ex.createCriteria().andUserNameEqualTo(user.getUsername());
		MallUserInfo mallUserInfo=mallUserInfoMapper.selectByExample(ex).get(0);
		param.put("userId", mallUserInfo.getId()+"");
		param.put("userName", mallUserInfo.getUserName());
		//调用其他分布式模块方法
		mallArsenalFegin.saveMessageBoard(param);
		
		//制造一个异常 查看分布式事务是否回滚
		//int a=1/0;
		
		//插入日志
		mallUserLogMapper.insert(new MallUserLog(null, "记录了一条日志", new Date(), mallUserInfo.getId()+""));
		
		
		
	}

}

package com.piltover.user.service;

import java.util.List;
import java.util.Map;

import com.piltover.user.entity.MallMenuInfo;
import com.piltover.user.entity.MallUserDetail;

public interface LoginService {
	public List<MallMenuInfo> getMenu(String username);
	
	public MallUserDetail getMallMallUserInfo(String username);
	
	public List<MallUserDetail> getUserList();
	
	public void saveInfo(Map<String,String> param);
}

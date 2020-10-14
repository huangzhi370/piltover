package com.piltover.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piltover.user.dao.MallUserInfoMapper;
import com.piltover.user.entity.MallUserInfo;
import com.piltover.user.entity.MallUserInfoExample;

/**
 * Created by macro on 2019/9/30.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private MallUserInfoMapper mallUserInfoMapper;

    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	MallUserInfoExample mallExample=new  MallUserInfoExample();
    	mallExample.createCriteria().andUserNameEqualTo(username);
    	List<MallUserInfo> userList=mallUserInfoMapper.selectByExample(mallExample);
    	if(null==userList||userList.size()==0){
    		throw new UsernameNotFoundException("用户名或密码错误");
    	}else{
    		MallUserInfo  mallUserInfo= userList.get(0);
    		return new User(mallUserInfo.getUserName(),
    				passwordEncoder.encode(mallUserInfo.getPassWord()),
    				AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    	}
    }
    
 
}


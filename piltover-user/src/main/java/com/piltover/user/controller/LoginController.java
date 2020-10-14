package com.piltover.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.common.model.CommonResult;
import com.piltover.user.service.LoginService;


@RestController
@RequestMapping("/userLogin")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/sayHello")
	public String sayHello(){
		return "piltover-user do say hello";
	}
	
	@Autowired
    private ConsumerTokenServices consumerTokenServices;
	
	@RequestMapping("/getMenu")
	public CommonResult<Object> getMenu(){
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("menuList", loginService.getMenu(user.getUsername()));
		resultMap.put("userInfo", loginService.getMallMallUserInfo(user.getUsername()));
		return CommonResult.success(resultMap,"查询成功");
	}
	
	@RequestMapping("/getUserList")
	public CommonResult<Object> getUserList(){
		return CommonResult.success(loginService.getUserList(),"查询成功");
	}
	
	

	@RequestMapping("/logout")
    public CommonResult<Object> logout(@RequestBody Map<String,Object> param){
		String accessToken=(String) param.get("accessToken");
		if(!StringUtils.isEmpty(accessToken)){
			 String[] num=accessToken.split("Bearer ");
			 accessToken=num[1];
			 if (consumerTokenServices.revokeToken(accessToken)) {
		            return CommonResult.success("注销成功");
		      }
		}
        return CommonResult.failed("注销失败");
    }
	
	@RequestMapping("/saveArsenal")
    public CommonResult<Object> saveArsenal(@RequestBody Map<String,String> param){
		loginService.saveInfo(param);
        return CommonResult.success("保存成功");
    }
	
	
}

package com.piltover.user.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="piltover-report")
public interface MallArsenalFegin {
	
	@PostMapping(value = "/arsenal/saveMessageBoard",consumes="application/json") 
	public void saveMessageBoard(@RequestBody Map<String, String> paramData);
}

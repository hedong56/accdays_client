package com.accdays.service.accumulation.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accdays.cxf.IUserInfoCXFService;
import com.accdays.model.User;
import com.accdays.rmi.IUserInfoService;
import com.accdays.service.accumulation.IAccumulationService;

@Service
public class AccumulationServiceImpl implements IAccumulationService {

	
@Resource(name="userInfoService")
private IUserInfoService userInfoService;
	
	@Resource(name="cxfUserInfoService")
	private IUserInfoCXFService cxfUserInfoService;
	
	@Override
	public User getPersonInfoInRMI(long userId) {
		return userInfoService.getUserById(userId);
	}
	@Override
	public List<User> findUserByName(String name) {
		try {
//			List<User> us=userInfoService.findUserByName(name);
			List<User> us=cxfUserInfoService.findUsersByName(name);
			return us;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

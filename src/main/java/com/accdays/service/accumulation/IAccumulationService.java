package com.accdays.service.accumulation;

import java.util.List;

import com.accdays.model.User;

public interface IAccumulationService {

	User getPersonInfoInRMI(long userId);

	List<User> findUserByName(String name);

	
}

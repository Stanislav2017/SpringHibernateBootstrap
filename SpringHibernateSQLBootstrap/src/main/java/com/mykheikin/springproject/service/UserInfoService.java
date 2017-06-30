package com.mykheikin.springproject.service;

import java.util.List;

import com.mykheikin.springproject.model.UserInfo;

public interface UserInfoService {

	UserInfo findById(int id);

	void save(UserInfo userInfo);

	void updateUserInfo(UserInfo userInfo);

	void deleteById(int id);

	List<UserInfo> findAllUserInfo();
}

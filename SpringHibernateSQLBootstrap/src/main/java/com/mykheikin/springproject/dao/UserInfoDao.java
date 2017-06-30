package com.mykheikin.springproject.dao;

import java.util.List;

import com.mykheikin.springproject.model.UserInfo;

public interface UserInfoDao {

	UserInfo findById(int id);

	void save(UserInfo userInfo);

	void deleteById(int id);

	List<UserInfo> findAllUserInfo();
}
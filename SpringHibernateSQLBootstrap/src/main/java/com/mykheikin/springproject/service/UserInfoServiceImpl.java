package com.mykheikin.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.springproject.dao.UserInfoDao;
import com.mykheikin.springproject.model.UserInfo;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfo findById(int id) {
		return userInfoDao.findById(id);
	}

	public void save(UserInfo userInfo) {
		userInfoDao.save(userInfo);
	}

	public void updateUserInfo(UserInfo userInfo) {
		UserInfo entity = userInfoDao.findById(userInfo.getId());
		if (entity != null) {
			entity.setFirstName(userInfo.getFirstName());
			entity.setLastName(userInfo.getLastName());
			entity.setPatronymic(userInfo.getPatronymic());
			entity.setDepartmentName(userInfo.getDepartmentName());
			entity.setPersonnelNumber(userInfo.getPersonnelNumber());
			entity.setSector(userInfo.getSector());
			entity.setPosition(userInfo.getPosition());
			entity.setExperience(userInfo.getExperience());
		}
	}

	public void deleteById(int id) {
		userInfoDao.deleteById(id);
	}

	public List<UserInfo> findAllUserInfo() {
		return userInfoDao.findAllUserInfo();
	}
}

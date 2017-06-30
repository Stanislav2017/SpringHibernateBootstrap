package com.mykheikin.springproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mykheikin.springproject.model.UserInfo;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends AbstractDao<Integer, UserInfo> implements UserInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final Logger logger = LoggerFactory.getLogger(UserInfoDaoImpl.class);

	@Override
	public UserInfo findById(int id) {
		UserInfo userInfo = getByKey(id);
		logger.info("UserInfo successfully load. UserInfo details: " + userInfo);
		return userInfo;
	}

	@Override
	public void save(UserInfo userInfo) {
		persist(userInfo);
		logger.info("UserInfo successfully saved. UserInfo details: " + userInfo);
	}

	@Override
	public void deleteById(int id) {
		UserInfo userInfo = getByKey(id);
		delete(userInfo);
		logger.info("UserInfo successfully deleted. UserInfo details: " + userInfo);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserInfo> findAllUserInfo() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<UserInfo> userInfoList = (List<UserInfo>) criteria.list();

		return userInfoList;
	}
}

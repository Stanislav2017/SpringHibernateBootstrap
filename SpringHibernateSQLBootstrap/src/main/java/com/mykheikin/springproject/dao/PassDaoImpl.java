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

import com.mykheikin.springproject.model.Pass;

@Repository("passDao")
public class PassDaoImpl extends AbstractDao<Integer, Pass> implements PassDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	private static final Logger logger = LoggerFactory.getLogger(PassDaoImpl.class);

	public Pass findById(int id) {
		Pass pass = getByKey(id);
		logger.info("Pass successfully load. Pass details: " + pass);
		return pass;
	}

	public void save(Pass pass) {
		persist(pass);
		logger.info("Pass successfully saved. Pass details: " + pass);
	}

	public void deleteById(int id) {
		Pass pass = getByKey(id);
		delete(pass);
		logger.info("Pass successfully deleted. Pass details: " + pass);
	}

	@SuppressWarnings("unchecked")
	public List<Pass> findAllPasses() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<Pass> passList = (List<Pass>) criteria.list();

		return passList;
	}
}

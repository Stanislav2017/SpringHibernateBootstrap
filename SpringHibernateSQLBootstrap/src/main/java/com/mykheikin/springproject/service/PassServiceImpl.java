package com.mykheikin.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykheikin.springproject.dao.PassDao;
import com.mykheikin.springproject.model.Pass;

@Service("passService")
@Transactional
public class PassServiceImpl implements PassService {

	@Autowired
	private PassDao dao;

	public Pass findById(int id) {
		return dao.findById(id);
	}

	public void save(Pass pass) {
		dao.save(pass);
	}

	public void updatePass(Pass pass) {
		Pass entity = dao.findById(pass.getId());
		if (entity != null) {
			entity.setDayStart(pass.getDayStart());
			entity.setTimeStart(pass.getTimeStart());
			entity.setTimeEnd(pass.getTimeEnd());
			entity.setPassNumber(pass.getPassNumber());
		}
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public List<Pass> findAllPasses() {
		return dao.findAllPasses();
	}
}

package com.mykheikin.springproject.dao;

import java.util.List;

import com.mykheikin.springproject.model.Pass;

public interface PassDao {

	Pass findById(int id);

	void save(Pass pass);

	void deleteById(int id);

	List<Pass> findAllPasses();

}

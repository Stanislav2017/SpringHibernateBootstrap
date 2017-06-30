package com.mykheikin.springproject.service;

import java.util.List;

import com.mykheikin.springproject.model.Pass;

public interface PassService {

	Pass findById(int id);

	void save(Pass pass);

	void updatePass(Pass pass);

	void deleteById(int id);

	List<Pass> findAllPasses();
}
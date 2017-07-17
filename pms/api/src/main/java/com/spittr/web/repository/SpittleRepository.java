package com.spittr.web.repository;

import java.util.List;

import com.spittr.web.bean.Spittle;

public interface SpittleRepository {

	public List<Spittle> findSpittles(long max, int count);
	
	public Spittle findOne(long id);

}

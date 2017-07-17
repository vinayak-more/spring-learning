package com.spittr.web.repository.impl.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spittr.web.bean.Spittle;
import com.spittr.web.repository.SpittleRepository;

@Component
public class DummySpittleRepository implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 1; i <= count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date(), 0.0, 0.0));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long id) {
		return new Spittle(id, "Spittle", new Date());
	}
}

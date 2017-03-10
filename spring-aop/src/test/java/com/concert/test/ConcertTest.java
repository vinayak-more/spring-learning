package com.concert.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.concert.config.JavaConfig;
import com.concert.performer.Performer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfig.class })
public class ConcertTest {

	@Autowired
	private Performer performer;

	@Test
	public void shouldNotBeNull() {
		assertNotNull(performer);
	}
	
	@Test
	public void perform(){
		String performance;
		try {
			performance = performer.perform();
			assertEquals(performance, "Performer is Performing");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}

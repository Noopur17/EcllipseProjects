package com.demo.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.demo.impl.NumbersProcessors;

public class NumbersProcessorsTest {

	NumbersProcessors np=new NumbersProcessors();
	@SuppressWarnings("deprecation")
	@Test
	public void testSqrt() {
		assertEquals(2, np.sqrt(4),0);
	}

	@Test
	public void testNegativeSqrt() {
		assertEquals(4, np.sqrt(-16),0);
	}
	@Test
	public void testPower() {
		assertEquals(990, np.power(10, 3),0);
	}

	@Test
	public void testConvertCase() {
		
		assertEquals(null, np.convertCase(null));
	}

}

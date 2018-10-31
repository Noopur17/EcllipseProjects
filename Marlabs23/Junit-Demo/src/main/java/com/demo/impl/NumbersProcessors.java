/**
 * 
 */
package com.demo.impl;

/**
 * @author Noopur
 *
 */
public class NumbersProcessors {
	public double sqrt(double num) {
		return Math.sqrt(num);
	}
	
	public double power(int n1,int n2) {
		return Math.pow(n1, n2);
	}
	
	public String convertCase(String name) {
		if(name==null)
			return null;
		
		return name.toUpperCase();
	}

}

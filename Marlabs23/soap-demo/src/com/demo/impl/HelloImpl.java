package com.demo.impl;

import javax.jws.WebService;

import com.demo.soap.IHello;

@WebService(endpointInterface="com.demo.soap.IHello")
public class HelloImpl implements IHello{

	public String sayHello(String name) {
		return "Hello from SOAP: " +name;
	}
}

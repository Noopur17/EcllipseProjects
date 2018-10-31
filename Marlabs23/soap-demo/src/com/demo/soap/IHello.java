package com.demo.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHello {

	@WebMethod
	public String sayHello(String name);
	
}

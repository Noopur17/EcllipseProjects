package com.demo.main;

import javax.xml.ws.Endpoint;

import com.demo.impl.HelloImpl;

public class Main {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:5555/myservices/samplesoap", new HelloImpl());//will create WSDL for your application
		System.out.println("SOAP is published!");
	}

}

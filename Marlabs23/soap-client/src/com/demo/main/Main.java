package com.demo.main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloImplService service =new HelloImplService();
		IHello iHello=(IHello)service.getHelloImplPort();
		System.out.println(iHello.sayHello(args[0]));
	}

}

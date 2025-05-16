package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
private int i=1;

	@GetMapping("/get")
	public String get() throws UnknownHostException {
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println("hitting "+ i++);
		return "Hi Rajesh ! Welcome to Our App : From MS DEMO" ;
	}
	
   
	
}

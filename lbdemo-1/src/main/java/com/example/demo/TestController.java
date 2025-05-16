package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
private int i=1;

	@GetMapping("/get")
	public String get() throws UnknownHostException {
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println("hitting "+ i++);
		return "Hi Rajesh ! Welcome to Our App : From " + localhost.getHostAddress().trim() ;
	}
	
	@GetMapping("/getMS")
	public String getMS() {
		String msdemo = System.getenv("MSDEMO_SERVICE_HOST");
		String msdemoURL=msdemo+":8081/msdemo/get";
		System.out.println("hitting "+ msdemoURL +" "+ i++);
		return new RestTemplate().getForObject(msdemoURL, String.class);
	}
	
   
	
}

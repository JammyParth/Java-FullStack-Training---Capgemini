package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ProductClient {

	
	//step 1
	public static void main(String[] args) {
		
		//step 2
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		ProductService p1 =  (ProductService) factory.getBean("productService1");           //step 3
		
		//step 9
		p1.allProducts();
		
		
		                             //step 11
		ProductService p2 =  (ProductService) factory.getBean("productService2");
		
		
		//step 17
		p2.allProducts();
		
		
	}

}

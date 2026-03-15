package com.springcore;

public class ProductServiceImpl implements ProductService{

		String product;         //step 8 - MacAirM1       // step 16 - MacProM1
		
		public ProductServiceImpl() {
			                                        //step 6
		}
		
		public ProductServiceImpl(String product) {
			this.product = product;                   //MACAirM1  step 7
		}
		
		
		public void setProduct(String product) {                //step 14
			this.product = product;                 //step 15 - MacAirM1
		}
		
		
		public void allProducts() {               //step 10 , 18
			System.out.println("Product name : " + product);
		}

	
}

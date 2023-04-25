package application;

import java.util.ArrayList;

public class test1 {

	public static void main(String[] args) {
		BevShop bevShop; 
		bevShop = new BevShop(); 
		bevShop.startNewOrder(8,DAY.MONDAY,"Kate", 20);                           
		bevShop.processCoffeeOrder("americano", SIZE.SMALL, true, false);         
		bevShop.processCoffeeOrder("Cappuccino", SIZE.LARGE, false, false);       
		                                                                          
		                                                                          
		bevShop.startNewOrder(8,DAY.SUNDAY,"John", 30);                           
		bevShop.processSmoothieOrder("Detox", SIZE.SMALL, 1, false);              
		System.out.print(bevShop.toString());
	}

}

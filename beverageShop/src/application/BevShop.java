package application;

import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {
	private int alcoholCount;
	
	int MIN_AGE_FOR_ALCOHOL = 21;  //Minimum age for offering alcohol drink
	int MAX_ORDER_FOR_ALCOHOL = 3;   /*Maximum number of alcohol beverages
									that can be ordered within an order  */
	int MIN_TIME= 8;				//earliest time for the order
	int MAX_TIME= 23;				//latest  time for the order
	int MAX_FRUIT = 5;
    private ArrayList<Order> orders;

    public BevShop() {
        this.orders = new ArrayList<>();
        this.alcoholCount = 0;
    }

    public boolean validTime(int time) {
    	
    	if (time >= MIN_TIME && time <= MAX_TIME) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public boolean eligibleForMore() {
        if (orders.isEmpty()) {
            return true;
        }

        Order currentOrder = orders.get(orders.size() - 1);
        int alcoholCount = 0;

        for (Beverage bev : currentOrder.getBeverages()) {
            if (bev instanceof Alcohol) {
                alcoholCount++;
            }
        }

        return alcoholCount < MAX_ORDER_FOR_ALCOHOL;
    }

    public boolean validAge(int age) {
    	if (age > MIN_AGE_FOR_ALCOHOL) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}
    
    public int getNumOfAlcoholDrink() {
    	Order currentOrder = orders.get(orders.size() - 1);
    	int alcoholCount = 0;
    	for (Beverage bev : currentOrder.getBeverages()) {
            if (bev instanceof Alcohol) {
                alcoholCount++;
            }
        }
    	return alcoholCount;
    }
    
    public int getMaxOrderForAlcohol(){
    	return MAX_ORDER_FOR_ALCOHOL;
    }
    
    public int getMinAgeForAlcohol() {
    	return MIN_AGE_FOR_ALCOHOL;
    }

    // Methods to create new orders
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
    	Customer customer = new Customer(customerName, customerAge);
        orders.add(new Order(time, day, customer));
    }

    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        orders.get(orders.size() - 1).addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    public void processAlcoholOrder(String bevName, SIZE size) {
    	orders.get(orders.size() - 1).addNewBeverage(bevName, size);
    }

    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
    	orders.get(orders.size() - 1).addNewBeverage(bevName, size, numOfFruits, addProtien);
    }

    
    public int totalNumOfMonthlyOrders() {
    	return 1;
    }
    
    public boolean isMaxFruit(int num) {
    	
    	if (num > 5) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }

        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);

        if (index == -1) {
            return -1;
        }

        Order currentOrder = orders.get(index);
        return currentOrder.calcOrderTotal();
    }

    public double totalMonthlySale() {
        double total = 0;

        for (Order order : orders) {
            total += order.calcOrderTotal();
        }

        return total;
    }

    public void sortOrders() {
        int lowestIndex = 0;
        Order tempOrder;
    	for (int i = 0; i < orders.size() - 1; i++) {
    		for (int j = i + 1; j < orders.size(); j++) {
    			lowestIndex = i;
    			if (orders.get(i).getOrderNo() > orders.get(j).getOrderNo()) {
    				lowestIndex = j;
    			}
    		}
    		if (i != lowestIndex) {
    			tempOrder = orders.get(i);
        		orders.set(i, orders.get(lowestIndex));
        		orders.set(lowestIndex, tempOrder);
    		}
    	}
    }

    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orders.size(); i++) {
            sb.append("Order ").append(orders.get(i).toString());
        }
        
        sb.append("\nTotal Monthly Sales: ").append(this.totalMonthlySale());
        return sb.toString();
    }
}
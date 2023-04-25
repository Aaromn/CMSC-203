package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Order implements OrderInterface{
	private static int orderCount = -1;
    private int orderNum;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private ArrayList<Beverage> bevs = new ArrayList<>();

    public Order(int orderTime, DAY day, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = day;
        this.customer = customer;
        orderCount++;
        this.orderNum = orderCount;
    }

    // Getters and Setters
    public int getOrderNo() {
        return orderNum;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public DAY getOrderDay() {
        return orderDay;
    }

    // Returns a deep copy
    public Customer getCustomer() {
    	Customer customerDeep = new Customer(this.customer);
        return customerDeep;
    }

    public ArrayList<Beverage> getBeverages() {
        return bevs;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.bevs = beverages;
    }
    
    public int getTotalItems() {
    	return this.bevs.size();
    }
    
    public Beverage getBeverage(int itemNo) {
		return bevs.get(itemNo);
	}
    
    /**
     *  Generates number between 10000 and 90000
     * @return A number between 10000 and 90000
     */
    public int generateInt() {
    	Random rand = new Random();
    	final int min = 10000;
    	final int max = 90000;
    	
    	int randomNum = rand.nextInt(max - min + 1) + min;
    	return randomNum;
    }
    
    /**
     * Add a beverage to the ArrayList bevs
     */
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol alc = new Alcohol(bevName, size, this.orderDay);
		this.bevs.add(alc);
	}
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee cof = new Coffee(bevName, size, extraShot, extraSyrup);
		this.bevs.add(cof);
	}
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		Smoothie smoth = new Smoothie(bevName, size, numOfFruits, addProtien);
		this.bevs.add(smoth);
	}
	
	
	/**
	 * checks if it is the weekend
	 * @return true or false based on if it is the weekend
	 */
	public boolean isWeekend() {
		if (this.orderDay == DAY.SATURDAY || this.orderDay == DAY.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	/** 
	 * @param Order order
	 * @return if orderNum is less = -1; if orderNum is more = 1; if orderNum is equal = 0;
	 */
	public int compareTo(Order order) {
		
		if (this.orderNum == order.orderNum) {
			return 0;
		}
		else if (this.orderNum > order.orderNum) {
			return 1;
		}
		else if (this.orderNum < order.orderNum) {
			return -1;
		}
		return -2;
	}
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		double total = 0;
		for (int i = 0; i < bevs.size(); i++) {
			total += bevs.get(i).calcPrice();
		}
		
		return total;
	}
	
	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(TYPE type) {
		int total = 0;
		for (int i = 0; i < bevs.size(); i++) {
			if (type == bevs.get(i).getType()) {
				total += 1;
			}
		}
		
		return total;
	}
	
    @Override
    public String toString() {
        String output = "Order number: " + orderNum + "\n";
        output += "Order day: " + orderDay + "\n";
        output += "Order time: " + orderTime + "\n";
        output += "Customer: " + customer.getName() + "\n";
        output += "Beverages:\n";
        for (Beverage b : bevs) {
            output += "  " + b.getBevName() + " (" + b.getSize() + ") - $" + b.calcPrice() + "\n";
        }
        output += "Total amount: $" + calcOrderTotal() + "\n";
        return output;
    }
}
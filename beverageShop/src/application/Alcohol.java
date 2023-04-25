package application;

public class Alcohol extends Beverage {
    private boolean weekend;

    public Alcohol(String name, SIZE size, boolean weekend) {
        super(name, TYPE.ALCOHOL, size); // alcohol has a base price of 5.0
        this.weekend = weekend;
    }
    
    public Alcohol(String name, SIZE size) {
        super(name, TYPE.ALCOHOL, size); // alcohol has a base price of 5.0
        this.weekend = false;
    }
    
    public Alcohol(String name, SIZE size, DAY day) {
        super(name, TYPE.ALCOHOL, size); // alcohol has a base price of 5.0
        this.weekend = isWeekend(day);
    }
    

    public boolean isWeekend() {
        return weekend;
    }
    
    public boolean isWeekend(DAY day) {
    	if (day == DAY.SATURDAY || day == DAY.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    @Override
    public double calcPrice() {
        double totalPrice = getPrice();
        
        if (getSize() == SIZE.LARGE) {
            totalPrice += getSizePrice() * 2;
        }
        else if (getSize() == SIZE.MEDIUM) {
            totalPrice += getSizePrice();
        }
        else if (getSize() == SIZE.SMALL) {
        	totalPrice += 0;
        }
        
        if (isWeekend()) {
            totalPrice += 0.6;
        }

        return totalPrice;
    }

    public double getBasePrice() {
    	return super.getPrice();
    }
    
    public String getBevName() {
    	return super.getBevName();
    }
    
    @Override
    public String toString() {
        return "Name: " + getBevName() + ", Type: " + getType() + ", Size: " + getSize() + ", Weekend: " + weekend + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alcohol) {
            Alcohol other = (Alcohol) obj;
            return super.equals(other) && this.weekend == other.weekend;
        }
        return false;
    }
}
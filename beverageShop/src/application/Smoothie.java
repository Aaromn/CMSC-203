package application;

import java.util.Objects;

public class Smoothie extends Beverage {
    private int numFruit;
    private boolean proteinPowder;
    final int MAX_FRUIT = 5;

    public Smoothie(String name, SIZE small, int numFruit, boolean proteinPowder) {
        super(name, TYPE.SMOOTHIE, small);
        this.numFruit = numFruit;
        this.proteinPowder = proteinPowder;
    }

	public int getNumOfFruits() {
        return numFruit;
    }

    public void setNumOfFruits(int numFruit) {
        this.numFruit = numFruit;
    }

    public boolean getAddProtien() {
        return proteinPowder;
    }

    public void setAddProtien(boolean proteinPowder) {
        this.proteinPowder = proteinPowder;
    }
    
    public double getBasePrice() {
    	return super.getPrice();
    }
    
    public String getBevName() {
    	return super.getBevName();
    }

    @Override
    public double calcPrice() {
        double totalPrice = getPrice();
        
        // If the size is "large", add $1 to the total price
        // If the size is "medium", double the total price
        // If the size is "small", no change to the total price
        if (getSize() == SIZE.LARGE) {
            totalPrice += getSizePrice() * 2;
        }
        else if (getSize() == SIZE.MEDIUM) {
            totalPrice += getSizePrice();
        }
        else if (getSize() == SIZE.SMALL) {
        	totalPrice += 0;
        }
        
        // Add $1.5 to the total price for each fruit
        totalPrice += 0.5 * numFruit;
        
        // Add $1.5 to the total price for protein powder
        if (proteinPowder) {
            totalPrice += 1.5;
        }
        
        return totalPrice;
    }
    
    @Override
    public String toString() {
        String proteinPowderString = proteinPowder ? "with protein powder" : "without protein powder";
        return getBevName() + " (" + getSize() + ") " + numFruit + " fruits " + proteinPowderString + " - $" + calcPrice();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Smoothie other = (Smoothie) obj;
        if (!Objects.equals(this.getBevName(), other.getBevName())) {
            return false;
        }
        
        if (!Objects.equals(this.getType(), other.getType())) {
            return false;
        }
        
        if (!Objects.equals(this.getSize(), other.getSize())) {
            return false;
        }
        
        if (this.numFruit != other.numFruit) {
            return false;
        }
        
        if (this.proteinPowder != other.proteinPowder) {
            return false;
        }
        
        return true;
    }
}
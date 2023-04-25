package application;

import java.util.Objects;

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, TYPE.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
    
    public String getBevName() {
    	return super.getBevName();
    }
    
    public double getBasePrice() {
    	return super.getPrice();
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
        
        // Add $0.5 to the total price for extra shot
        if (extraShot) {
            totalPrice += 0.5;
        }
        
        // Add $0.5 to the total price for extra syrup
        if (extraSyrup) {
            totalPrice += 0.5;
        }
        
        return totalPrice;
    }
    
    @Override
    public String toString() {
        String extraShotString = extraShot ? "with extra shot" : "without extra shot";
        String extraSyrupString = extraSyrup ? "with extra syrup" : "without extra syrup";
        return getBevName() + " (" + getSize() + ") " + extraShotString + ", " + extraSyrupString + " - $" + calcPrice();
    }
    
    // This has to be re-written to compare two Coffee class objects to make sure that they are identical
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Coffee other = (Coffee) obj;
        if (!Objects.equals(this.getBevName(), other.getBevName())) {
            return false;
        }
        
        if (!Objects.equals(this.getType(), other.getType())) {
            return false;
        }
        
        if (!Objects.equals(this.getSize(), other.getSize())) {
            return false;
        }
        
        if (this.extraShot != other.extraShot) {
            return false;
        }
        
        if (this.extraSyrup != other.extraSyrup) {
            return false;
        }
        
        return true;
    }
}

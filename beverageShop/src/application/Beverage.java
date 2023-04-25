package application;

public abstract class Beverage {
    private String name;
    private TYPE type;
    private final double price = 2.0;
    private final double sizePrice = 1.0;
    private SIZE size;
    
    public Beverage(String name, TYPE type, SIZE small) {
        this.name = name;
        this.type = type;
        this.size = small;
    }

	// getters and setters
    public String getBevName() {
        return name;
    }
    
    public void setBevName(String name) {
        this.name = name;
    }
    
    public TYPE getType() {
        return type;
    }
    
    public void setType(TYPE type) {
        this.type = type;
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getSizePrice() {
        return sizePrice;
    }
    
    public SIZE getSize() {
        return size;
    }
    
    public void setSize(SIZE size) {
        this.size = size;
    }
    
    public abstract double calcPrice();
    
    @Override
    public String toString() {
        return "Name: " + name + ", Size: " + size;
    }
    
    // This has to be re-written to compare two Beverage class objects to make sure that they are identical
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof Beverage)) {
            return false;
        }
        
        Beverage other = (Beverage) obj;
        return name.equals(other.name) &&
               type.equals(other.type) &&
               size.equals(other.size);
    }
}

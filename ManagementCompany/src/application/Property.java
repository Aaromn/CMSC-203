package application;

public class Property{
	
	private Plot plot;
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	
	
	public Property(Property other) {
        this.owner = other.owner;
        this.plot = other.plot;
        this.city = other.city;
        this.rentAmount = other.rentAmount;
        this.propertyName = other.propertyName;
    }
	
	public Property() {
		this.plot = new Plot();
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
	}
	
	public Property(String propertyName, String cityName, double rent, String owner) {
		this.propertyName = propertyName;
		this.city = cityName;
		this.rentAmount = rent;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String cityName, double rent, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = cityName;
		this.rentAmount = rent;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setPlot(int x, int y, int width, int depth) {
    	plot.setX(x);
    	plot.setY(y);
    	plot.setWidth(width);
    	plot.setDepth(depth);

    }
    
    public Plot getPlot() {
    	return this.plot;
    }
    
    public String toString(){
    	String product = "";
    	product = "\nProperty Name: " + propertyName + "\nLocated in " + city + "\nBelonging to:  " + owner + "\nRent Amount: " + rentAmount;
    	return product;
    }
	
}

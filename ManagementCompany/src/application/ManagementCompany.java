package application;

public class ManagementCompany {
	//Variables 
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	public ManagementCompany() {
	    this.mgmFeePer = 0.0;
	    this.name = "";
	    this.taxID = "";
	    this.MGMT_DEPTH = 10;
	    this.MGMT_WIDTH = 10;
	    this.plot = new Plot(0,0,10,10);
	    properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
	    this.mgmFeePer = mgmFee;
	    this.name = name;
	    this.taxID = taxID;
	    this.MGMT_DEPTH = 10;
	    this.MGMT_WIDTH = 10;
	    this.plot = new Plot(0,0,10,10);
	    properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
	    this.mgmFeePer = mgmFee;
	    this.name = name;
	    this.taxID = taxID;
	    this.MGMT_DEPTH = 10;
	    this.MGMT_WIDTH = 10;
	    this.plot = new Plot(x,y,width,depth);
	    properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany other) {
	    this.mgmFeePer = other.mgmFeePer;
	    this.name = other.name;
	    this.properties = other.properties;
	    this.taxID = other.taxID;
	    this.MGMT_DEPTH = other.MGMT_DEPTH;
	    this.MGMT_WIDTH = other.MGMT_WIDTH;
	    this.plot = new Plot(other.plot);
	    properties = new Property[MAX_PROPERTY];
	}
	
	public int addProperty(Property property) {
		//Copy constructor
		Property property2 = new Property(property);
		
		//Conditions for return statement
		if (property2.equals(null)) {
			return -2;
		}
		
		//Check if it fits in the plot
		if (this.plot.encompasses(property2.getPlot()) == false) {
			return -3;
		}
		
		//Add Property to array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (this.properties[i] == null) {
				this.properties[i] = property2;
				return i;
			}
			else {
				if (property2.getPlot().overlaps(this.properties[i].getPlot())) {
					return -4;
				}
			}
		}
		return -1;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		//Copying the object
		Property property2 = new Property();
		property2.setPropertyName(name);
		property2.setCity(city);
		property2.setRentAmount(rent);
		property2.setOwner(owner);
				
		//Conditions for return statement
		if (property2.equals(null)) {
			return -2;
		}
				
		//Check if it fits in the plot
		if (this.plot.encompasses(property2.getPlot()) == false) {
			return -3;
		}
		
		
		//Add Property to array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (this.properties[i] == null) {
				this.properties[i] = property2;
				return i;
			}
			else {
				if (property2.getPlot().overlaps(this.properties[i].getPlot())) {
					return -4;
				}
			}
		}
		return -1;
	}
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		//Copying the object
		Property property2 = new Property();
		property2.setPropertyName(name);
		property2.setCity(city);
		property2.setRentAmount(rent);
		property2.setOwner(owner);
		property2.setPlot(x, y, width, depth);
		
		//Conditions for return statement
		if (property2.equals(null)) {
			return -2;
		}
				
		//Check if it fits in the plot
		if (this.plot.encompasses(property2.getPlot()) == false) {
			return -3;
		}
		
		
		//Add Property to array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (this.properties[i] == null) {
				this.properties[i] = property2;
				return i;
			}
			else {
				if (property2.getPlot().overlaps(this.properties[i].getPlot())) {
					return -4;
				}
			}
		}
		
		return -1;
	}
	
	public String displayPropertyAtIndex(int i){
		return this.properties[i].toString();
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public double maxRentProp() {
		double maxRent = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				if (properties[i].getRentAmount() > maxRent) {
					maxRent = properties[i].getRentAmount();
				}
			}
		}
		
		return maxRent;
	}
	
	public int maxRentPropertyIndex() {
		double maxRent = 0;
		int index = -1;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				index = i;
			}
		}
		
		return index;
	}
	
	public String toString() {
		String prod = "";
		prod += "List of properties for " + this.name + ", taxID: " + this.taxID + "\n________________________________________________";
		for (int i = 0; i < MAX_PROPERTY; i++) {
			prod += properties[i].toString() + "\n";
		}
		
		prod += "________________________________________________";
		
		return prod;
	}
	
	public double totalRent() {
		int total = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] != null) {
				total += properties[i].getRentAmount();
			}
		}
		
		return total;
	}
	
	public Plot getPlot(){
		return this.plot;
	}
	
	public String getName() {
		return this.name;
	}
	
}

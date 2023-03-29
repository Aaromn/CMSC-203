package application;

public class Plot {
	private int x;
    private int y;
    private int width;
    private int depth;

    
    public Plot() {
    	this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
    
    public Plot(Plot other) {
        this.x = other.x;
        this.y = other.y;
        this.width = other.width;
        this.depth = other.depth;
    }
    
    public Plot(int x, int y, int width, int depth) {
    	this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getDepth() {
        return this.depth;
    }
    
    public boolean overlaps(Plot other) {
        if (this.x + this.width <= other.x || other.x + other.width <= this.x) {
            return false;
        }
        if (this.y + this.depth <= other.y || other.y + other.depth <= this.y) {
            return false;
        }
        return true;
    }
    
    public boolean encompasses(Plot other) {
        if (this.x <= other.x && this.y <= other.y && this.x + this.width >= other.x + other.width && this.y + this.depth >= other.y + other.depth) {
            return true;
        }
        return false;
    }
    
    public String toString() {
        return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
    }


}

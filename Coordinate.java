public class Coordinate {
	private int x, y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y; 
	}
	public int getX(){return (int)x;}
	public int getY(){return (int)y;}
	public void setX(int newX){x = newX;}
	public void setY(int newY){y = newY;}
	
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}
}

import java.awt.Rectangle;

public class Hitbox {
	private Coordinate coordinate;
	private final int width;
	private final int height;
	public Hitbox (Coordinate coo, int width, int height) {
		coordinate = coo;
		this.width = width;
		this.height = height;
	}
	
	public void setCoordinate(Coordinate coo) {
		coordinate = coo;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private Rectangle getRectangle() {
		return new Rectangle(coordinate.getX(), coordinate.getY(), width, height);
	}
	
	public boolean hit(Hitbox hitbox){
		// size of enemy image -> 30 x 30 pixels, size of projectile -> 10 x 10
		
		Rectangle box1 = getRectangle();
		Rectangle box2 = new Rectangle(hitbox.getCoordinate().getX(), hitbox.getCoordinate().getY(), hitbox.getWidth(), hitbox.getHeight());

		return box1.intersects(box2);
	}
}

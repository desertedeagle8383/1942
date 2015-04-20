import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Thing {
	private int width;
	private int height;
	private Coordinate currentCoordinate;
	private int xVelocity;
	private int yVelocity;
	private Image image;
	private Hitbox hitbox;

	public Coordinate getCoordinate(){return currentCoordinate;};
	public void setCoordinate(Coordinate newCoordinate) {
		currentCoordinate = newCoordinate;
	}
	public int getXVelocity(){return xVelocity;};
	public int getYVelocity(){return yVelocity;};
	public void setXVelocity(int newXVelocity){xVelocity = newXVelocity;}
	public void setYVelocity(int newYVelocity){yVelocity = newYVelocity;}
	public void setHitbox(Hitbox hitbox) {this.hitbox = hitbox;}
	public Hitbox getHitbox() {return hitbox;}
	//Implement sprites
	public void setImage(String filePath){
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
	}
	public Image getImage(){return image;}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}

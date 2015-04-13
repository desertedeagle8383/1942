import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Thing {
	private Coordinate currentCoordinate;
	private int xVelocity;
	private int yVelocity;
	private Image image;

	public Coordinate getCoordinate(){return currentCoordinate;};
	public void setCoordinate(Coordinate newCoordinate) {
		currentCoordinate = newCoordinate;
	}
	public int getXVelocity(){return xVelocity;};
	public int getYVelocity(){return yVelocity;};
	public void setXVelocity(int newXVelocity){xVelocity = newXVelocity;}
	public void setYVelocity(int newYVelocity){yVelocity = newYVelocity;}
	//Implement sprites
	public void setImage(String filePath){
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
	}
	public Image getImage(){return image;}
	
}

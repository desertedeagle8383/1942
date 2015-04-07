import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Thing {
	private Coordinate currentCoordinate;
	private double xVelocity;
	private double yVelocity;
	Image image;

	
	public Coordinate getCoordinate(){return currentCoordinate;};
	public double getXVelocity(){return xVelocity;};
	public double getYVelocity(){return yVelocity;};
	public void setXVelocity(double newXVelocity){xVelocity = newXVelocity;}
	public void setYVelocity(double newYVelocity){yVelocity = newYVelocity;}
	public void setImage(String filePath){
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
	}
	public Image getImage(){return image;}
	
}

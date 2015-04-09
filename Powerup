import java.awt.Image;

public abstract class Powerup extends Thing{
	private Hitbox hitbox;
	private String filePath = "";
	private Coordinate coordinate;
	
	public Powerup(Coordinate coordinate, Hitbox hitbox){
		this.coordinate = coordinate;
		this.hitbox = hitbox; 
		setImage(filePath);
	}
	
	public Coordinate getCoordinate(){return coordinate;}
	public Hitbox getHitbox(){return hitbox;}
	public void setCoordinate(Coordinate newCoordinate){coordinate = newCoordinate;}
	public void setHitbox(Hitbox newHitbox){hitbox = newHitbox;}
	
}

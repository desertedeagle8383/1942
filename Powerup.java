import java.awt.Image;

public abstract class Powerup extends Thing{
	
	public Powerup(Coordinate coordinate, Hitbox hitbox){
		setHitbox(new Hitbox(coordinate, 20, 20));
		setCoordinate(coordinate);
		setXVelocity(0);
		setYVelocity(5);
		setWidth(20);
		setHeight(20);
	}
}

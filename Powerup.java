public class Powerup extends Thing{
	public static final int QUAD_GUN = 314;
	public static final int ENEMY_CRASH = 159;
	public static final int EXTRA_LIFE = 265;
	public static final int NO_ENEMY_BULLETS = 358;
	public static final int EXTRA_SHIELD = 979;
	public static final int THOUSAND_POINTS = 323;
	
	private int type;
	
	public Powerup(Coordinate coordinate, Hitbox hitbox, int powerupType){
		type = powerupType;
		setHitbox(new Hitbox(coordinate, 20, 20));
		setCoordinate(coordinate);
		setXVelocity(0);
		setYVelocity(5);
		setWidth(20);
		setHeight(20);
	}
	
	public int getType() {
		return type;
	}
}

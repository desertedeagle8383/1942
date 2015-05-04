public class Powerup extends Thing{
	public static final int QUAD_GUN = 314;
	public static final int ENEMY_CRASH = 159;
	public static final int EXTRA_LIFE = 265;
	public static final int NO_ENEMY_BULLETS = 358;
	public static final int EXTRA_SHIELD = 979;
	public static final int THOUSAND_POINTS = 323;
	
	private String filePath1 = "Quad_Gun.png";
	private String filePath2 = "Enemy_Crash.png";
	private String filePath3 = "Extra_Life.png";
	private String filePath4 = "No_Enemy_Bullets.png";
	private String filePath5 = "Extra_Shield.png";
	private String filePath6 = "Thousand_Points.png";
	
	private int type;
	
	public Powerup(Coordinate coordinate, int powerupType){
		type = powerupType;
		setHitbox(new Hitbox(coordinate, 20, 20));
		setCoordinate(coordinate);
		setXVelocity(0);
		setYVelocity(-5);
		setWidth(20);
		setHeight(20);
		switch (powerupType) {
		case QUAD_GUN: setImage(filePath1); break;
		case ENEMY_CRASH: setImage(filePath2); break;
		case EXTRA_LIFE: setImage(filePath3); break;
		case NO_ENEMY_BULLETS: setImage(filePath4); break;
		case EXTRA_SHIELD: setImage(filePath5); break;
		case THOUSAND_POINTS: setImage(filePath6); break;
		}
	}
	
	public int getType() {
		return type;
	}
}

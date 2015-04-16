import java.util.ArrayList;
public class Enemy extends Thing{
	private long initialTime;
	private int health;
	private Powerup powerup;
	private ArrayList<Action> actions;
	private String filePath = "Z:\\My Documents\\1942\\src\\Enemy.png";
	public Enemy(Coordinate coordinate, int width, int height, int health, ArrayList<Action> actions){
		this.health = health;
		this.actions = actions;
		this.powerup = null;
		setCoordinate(coordinate);
		setHitbox(new Hitbox(coordinate, width, height));
		setWidth(width);
		setHeight(height);
		setXVelocity(0);
		setYVelocity(0);
		setImage(filePath);
	}
	public Enemy(Coordinate coordinate, int width, int height, int health, ArrayList<Action> actions, Powerup powerupDrop){
		this.health = health;
		this.actions = actions;
		this.powerup = powerupDrop;
		setCoordinate(coordinate);
		setHitbox(new Hitbox(coordinate, width, height));
		setWidth(width);
		setHeight(height);
		setXVelocity(0);
		setYVelocity(0);
	}
	public ArrayList<Action> getActions(){return actions;}
	public long getInitialTime(){return initialTime;}
	public void setInitialTime(long initialTime){this.initialTime = initialTime;}
	public int getHealth(){return health;}
	public boolean hasPowerup() {return powerup == null;}
	public Powerup getPowerup() {return powerup;}
	public boolean isAlive(){return (health == 0);}
}

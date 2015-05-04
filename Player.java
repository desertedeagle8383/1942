import java.util.ArrayList;

public class Enemy extends Thing {
	private long initialTime;
	private int health;
	private int powerup;
	private ArrayList<Action> actions;
	private int points;
	private String filePath = "Enemy.png";
	public Enemy(Coordinate coordinate, int width, int height, int initX, int initY, int health, int points, ArrayList<Action> actions){
		this.health = health;
		this.actions = actions;
		this.powerup = 0;
		this.points = points;
		setXVelocity(initX);
		setYVelocity(initY);
		setCoordinate(coordinate);
		setHitbox(new Hitbox(coordinate, width, height));
		setWidth(width);
		setHeight(height);

	}
	public Enemy(Coordinate coordinate, int width, int height, int initX, int initY, int health, int points, ArrayList<Action> actions, int powerupType){
		this.health = health;
		this.actions = actions;
		this.powerup = powerupType;
		this.points = points;
		setCoordinate(coordinate);
		setHitbox(new Hitbox(coordinate, width, height));
		setWidth(width);
		setHeight(height);
		setXVelocity(0);
		setYVelocity(0);
		setImage(filePath);
	}

	public int getPoints() {return points;}
	public ArrayList<Action> getActions(){return actions;}
	public long getInitialTime(){return initialTime;}
	public void setInitialTime(long initialTime){this.initialTime = initialTime;}
	public int getHealth(){return health;}
	public boolean hasPowerup() {return powerup != 0;}
	public Powerup getPowerup() {return new Powerup(getCoordinate(), powerup);}
	public boolean isAlive(){return (health > 0);}
	public void hit() {health--;}
}

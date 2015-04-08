import java.util.ArrayList;

public class Enemy extends Plane{
	private long initialTime;
	private int health;
	private int width;
	private int height;
	private ArrayList<Action> actions;
	
	public Enemy(int width, int height, int health, ArrayList<Action> actions){
		this.health = health;
		this.actions = actions;
		this.width = width;
		this.height = height;
	}
	
	public ArrayList<Action> getActions(){return actions;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public long getInitialTime(){return initialTime;}
	public void setInitialTime(long initialTime){this.initialTime = initialTime;}
	public int getHealth(){return health;}
	public boolean isAlive(){return (health == 0);}
}

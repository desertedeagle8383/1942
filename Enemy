import java.util.ArrayList;

public class Enemy extends Plane{
	private long initialTime;
	private int health;
	private ArrayList<Action> actions;
	
	public Enemy(int health, ArrayList<Action> actions){
		this.health = health;
		this.actions = actions;
	}
	
	public ArrayList<Action> getActions(){return actions;}
	public long getInitialTime(){return initialTime;}
	public void setInitialTime(long initialTime){this.initialTime = initialTime;}
	public int getHealth(){return health;}
	public boolean isAlive(){
		if (health == 0)
			return false;
		return true;
	}
}

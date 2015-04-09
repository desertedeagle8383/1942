import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game{
	private int currentLevel = 1;
	private int score;
	private int lives;
	private int rolls;
	private long initialTime;
	private Grid grid;
	private Timer timer;
	private ArrayList<Level> levels;

	public Game(Grid grid){
		score = 0;
		lives = 3;
		rolls = 2;
		grid.createPlayer();
	}

	public int getScore(){return score;}
	public int getLives(){return lives;}
	public int getRolls(){return rolls;}
	public long getInitialTime(){return initialTime;}
	public Grid getGrid(){return grid;}

	public void shoot(){
		Projectile newProjectile = new Projectile(false, grid.getPlayer().getCoordinate());
		newProjectile.setXVelocity(0);
		newProjectile.setYVelocity(10);
		grid.addProjectile(newProjectile);
	}

	public void nextFrame(){
		//what to do here?
	}
	
	public void startLevel(){
		if (currentLevel < levels.size()) {
			initialTime = System.currentTimeMillis();
			timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					endLevel();
				}
			}, levels.get(currentLevel).getLevelLength());
		} else {
			endGame();
		}
	}
	
	public void startGame() {
		
	}
	
	private void endLevel() {
		
	}
	
	private void endGame() {
		
	}

	public void cancelTasks(){
		timer.cancel();
		timer.purge();
	}
}

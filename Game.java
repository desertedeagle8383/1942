import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game{
	private int currentLevel;
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

	public void nextFrame(long initialTime){
		long elapsedTime = System.currentTimeMillis() - initialTime;
		
		for (int i = 0; i < grid.getEnemies().size(); i++) {
			Enemy currentEnemy = grid.getEnemies().get(i);
			Coordinate lastCoo = currentEnemy.getCoordinate();
			for(int j = 0; j < currentEnemy.getActions().size(); i++) {
				Action currentAction = currentEnemy.getActions().get(i);
				long delay = currentAction.getDelay();
				if (delay < elapsedTime && delay > elapsedTime - 30) {
					currentEnemy.setXVelocity(currentAction.getXVelocity());
					currentEnemy.setYVelocity(currentAction.getYVelocity());
					if (currentAction.getFire())
						grid.addProjectile()
				}
			}
			currentEnemy.setCoordinate(new Coordinate((int) (lastCoo.getX() + currentEnemy.getXVelocity()), (int) (lastCoo.getY() + currentEnemy.getYVelocity())));
		}
	}
	
	public void startLevel(){
		if (currentLevel < levels.size()) {
			initialTime = System.currentTimeMillis();
			timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					endLevel();
				}
			}, new Date(initialTime + levels.get(currentLevel).getLevelLength()));
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {
					nextFrame(initialTime);
				}
			}, new Date(initialTime + 3000), 30);
		} else {
			endGame();
		}
	}
	
	public void startGame() {
		currentLevel = 1;
		startLevel();
	}
	
	private void endLevel() {
		cancelTasks();
	}
	
	private void endGame() {
		cancelTasks();
	}

	public void cancelTasks(){
		timer.cancel();
		timer.purge();
	}
}

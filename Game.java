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
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

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
		Player player = grid.getPlayer();

		for (int i = 0; i < grid.getProjectiles().size(); i++) {
			Projectile currentProjectile = grid.getProjectiles().get(i);
			Coordinate lastCoo = currentProjectile.getCoordinate();
			Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity()));
			if (newCoo.getX() < 0 && newCoo.getX() > grid.getWidth() && newCoo.getY() < 0 && newCoo.getY() > grid.getHeight())
				grid.removeProjectile(currentProjectile);
			else
				currentProjectile.setCoordinate(new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity())));
		}

		for (int i = 0; i < grid.getEnemies().size(); i++) {
			Enemy currentEnemy = grid.getEnemies().get(i);
			Coordinate lastCoo = currentEnemy.getCoordinate();
			for(int j = 0; j < currentEnemy.getActions().size(); i++) {
				Action currentAction = currentEnemy.getActions().get(i);
				long delay = currentAction.getDelay();
				if (delay < elapsedTime && delay > elapsedTime - 30) {
					currentEnemy.setXVelocity(currentAction.getXVelocity());
					currentEnemy.setYVelocity(currentAction.getYVelocity());
				}
				Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentEnemy.getXVelocity()), (int) (lastCoo.getY() + currentEnemy.getYVelocity()));
				if (newCoo.getX() < 0 && newCoo.getX() > grid.getWidth() && newCoo.getY() < 0 && newCoo.getY() > grid.getHeight()) {
					grid.removeEnemy(currentEnemy);
				} else {
					currentEnemy.setCoordinate(newCoo);
					if (currentAction.getFire())
						if (currentAction.aimsAtPlayer()) 
							grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), player.getCoordinate()));
						else
							grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), currentAction.getTargetCoordinate()));
					if (currentAction.getLoop()) {
						currentEnemy.getActions().add(currentAction.generateLoopedCopy());
					}
				}
			}
			if ()
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

	public void setLeft(boolean asd) {
		left = asd;
	}
	public void setRight(boolean asd) {
		right = asd;
	}
	public void setUp(boolean asd) {
		up = asd;
	}
	public void setDown(boolean asd) {
		down = asd;
	}

}

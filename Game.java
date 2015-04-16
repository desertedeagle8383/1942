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
		up = false;
		down = false;
		left = false;
		right = false;
		score = 0;
		lives = 3;
		rolls = 2;
		grid.createPlayer();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		ArrayList<Long> times = new ArrayList<Long>();
		Level testLevel = new Level(enemies, times, 9999999);
		levels = new ArrayList<Level>();
		levels.add(testLevel);
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
		Level level = levels.get(currentLevel);
		ArrayList<Long> times = level.getEnemySpawnTimes();
		ArrayList<Enemy> enemies = level.getEnemies();
		for (int i = 0; i < times.size(); i++) {
			long currentTime = times.get(i);
			if (currentTime < elapsedTime && currentTime > elapsedTime - 30) {
				grid.addEnemy(enemies.get(i));
			}
		}

		for (int i = 0; i < grid.getPowerups().size(); i++) {
			Powerup currentPowerup = grid.getPowerups().get(i);
			Coordinate lastCoo = currentPowerup.getCoordinate();
			Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentPowerup.getXVelocity()), (int) (lastCoo.getY() + currentPowerup.getYVelocity()));
			if (newCoo.getY() < 0 && newCoo.getY() + currentPowerup.getHeight() > grid.getHeight())
				grid.removePowerup(currentPowerup);
			else {
				currentPowerup.setCoordinate(new Coordinate((int) (lastCoo.getX()), (int) (lastCoo.getY() + currentPowerup.getYVelocity())));
				currentPowerup.getHitbox().setCoordinate(newCoo);
			}
		}

		for (int i = 0; i < grid.getProjectiles().size(); i++) {
			Projectile currentProjectile = grid.getProjectiles().get(i);
			Coordinate lastCoo = currentProjectile.getCoordinate();
			Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity()));
			if (newCoo.getX() + currentProjectile.getWidth() < 0 && newCoo.getX() > grid.getWidth() && newCoo.getY() < 0 && newCoo.getY() + currentProjectile.getHeight() > grid.getHeight())
				grid.removeProjectile(currentProjectile);
			else {
				currentProjectile.setCoordinate(new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity())));
				currentProjectile.getHitbox().setCoordinate(newCoo);
			}
		}

		for (int i = 0; i < grid.getEnemies().size(); i++) {
			Enemy currentEnemy = grid.getEnemies().get(i);
			Coordinate lastCoo = currentEnemy.getCoordinate();
			for(int j = 0; j < currentEnemy.getActions().size(); j++) {
				Action currentAction = currentEnemy.getActions().get(i);
				long delay = currentAction.getDelay();
				if (delay < elapsedTime && delay > elapsedTime - 30) {
					currentEnemy.setXVelocity(currentAction.getXVelocity());
					currentEnemy.setYVelocity(currentAction.getYVelocity());
					if (currentAction.getFire())
						if (currentAction.aimsAtPlayer()) 
							grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), player.getCoordinate()));
						else
							grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), currentAction.getTargetCoordinate()));
					if (currentAction.getLoop()) {
						currentEnemy.getActions().add(currentAction.generateLoopedCopy());
					}
				}
				Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentEnemy.getXVelocity()), (int) (lastCoo.getY() + currentEnemy.getYVelocity()));
				if (newCoo.getX() + currentEnemy.getWidth() < 0 && newCoo.getX() > grid.getWidth() && newCoo.getY() < 0 && newCoo.getY() + currentEnemy.getHeight() > grid.getHeight()) {
					grid.removeEnemy(currentEnemy);
				} else {
					currentEnemy.setCoordinate(newCoo);
					currentEnemy.getHitbox().setCoordinate(newCoo);
				}
				Coordinate playerCoo = player.getCoordinate();
				int netX = 0;
				int netY = 0;
				if (left)
					netX -= 10;
				if (right)
					netX += 10;
				if (up)
					netY += 10;
				if (down)
					netY -= 10;
				player.setCoordinate(new Coordinate(playerCoo.getX() + netX, playerCoo.getY() + netY));
				currentEnemy.getHitbox().setCoordinate(newCoo);
			}
		}
		if (player.isHittable()) {
			for (int i = 0; i < grid.getEnemyProjectiles().size(); i++) {
				Projectile p = grid.getEnemyProjectiles().get(i);
				if (player.getHitbox().hit(p.getHitbox())) {
					death();
					grid.removeProjectile(p);
				}
			}
			for (int i = 0; i < grid.getEnemies().size(); i++) {
				Enemy e = grid.getEnemies().get(i);
				if (player.getHitbox().hit(e.getHitbox())) {
					grid.removeEnemy(e);
					death();
				}
			}
		}
		for (int i = 0; i < grid.getPowerups().size(); i++) {
			Powerup p = grid.getPowerups().get(i);
			//Implement powerups
			if (player.getHitbox().hit(p.getHitbox())) {
				if (p.getType() == Powerup.QUAD_GUN) {
					
				} else if (p.getType() == Powerup.ENEMY_CRASH) {
					
				} else if (p.getType() == Powerup.EXTRA_LIFE) {
					
				} else if (p.getType() == Powerup.NO_ENEMY_BULLETS) {
					
				} else if (p.getType() == Powerup.EXTRA_LOOP) {
					
				} else if (p.getType() == Powerup.THOUSAND_POINTS) {
					
				}
				grid.removePowerup(p);
			}
		}
		for (int i = 0; i < grid.getEnemies().size(); i++) {
			Enemy e = grid.getEnemies().get(i);
			for (int j = 0; j < grid.getFriendlyProjectiles().size(); j++) {
				Projectile p = grid.getFriendlyProjectiles().get(i);
				if (e.getHitbox().hit(p.getHitbox())) {
					score += e.getPoints();
					grid.removeEnemy(e);
					grid.removeProjectile(p);
				}
			}
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
		currentLevel += 1;
		startLevel();
	}
	
	//implement
	private void endLevel() {
		cancelTasks();
		currentLevel++;
	}

	//implement
	private void endGame() {
		cancelTasks();
		System.exit(0);
	}

	private void cancelTasks(){
		timer.cancel();
		timer.purge();
	}
	
	private void death() {
		if (lives > 1) {
			lives--;
			grid.getPlayer().setHittable(false);
			timer.schedule(new TimerTask() {
				public void run() {
					grid.getPlayer().setHittable(true);
				}
			}, 3000);
		} else {
			endGame();
		}
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

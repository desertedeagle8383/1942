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
	private boolean shoot;
	private GameFrame gameFrame;

	public Game(GameFrame frame, Grid grid){
		gameFrame = frame;
		
		Action a1 = new Action(1000, -20, -20, false, false, null, false, 0);
		Action a2 = new Action(1000, -20, -20, true, true, null, true, 1000);
		Action a3 = new Action(5000, -20, 0, false, false, null, false, 0);
		Action a4 = new Action(10000, -20, 20, false, false, null, false, 0);
		
		ArrayList<Action> acts1 = new ArrayList<Action>();
		acts1.add(a1);
		acts1.add(a2);
		acts1.add(a3);
		acts1.add(a4);
		
		Enemy e1 = new Enemy(new Coordinate(grid.getWidth() - 30, grid.getHeight() - 30), 30, 30, 1, 500, acts1);
		
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		enemies.add(e1);
		
		ArrayList<Long> times = new ArrayList<Long>();
		
		times.add(new Long(5000));
		
		Level testLevel = new Level(enemies, times, 9999999);
		levels = new ArrayList<Level>();
		levels.add(testLevel);
		this.grid = grid;
	}

	public int getScore(){return score;}
	public int getLives(){return lives;}
	public int getRolls(){return rolls;}
	public long getInitialTime(){return initialTime;}
	public Grid getGrid(){return grid;}

	public void shoot(){
		if (shoot) {
			Projectile newProjectile = new Projectile(new Coordinate(grid.getPlayer().getCoordinate().getX() + 13, grid.getPlayer().getCoordinate().getY()));
			grid.addProjectile(newProjectile);
			shoot = false;
			timer.schedule(new TimerTask() {

				@Override
				public void run() {
					shoot = true;
				}
				
			}, 100);
		}
	}

	public void nextFrame(long initialTime){
		long elapsedTime = System.currentTimeMillis() - initialTime;
//		System.out.println(elapsedTime);
		Player player = grid.getPlayer();
		Level level = levels.get(currentLevel);
		ArrayList<Long> times = level.getEnemySpawnTimes();
		ArrayList<Enemy> enemies = level.getEnemies();
		for (int i = 0; i < times.size(); i++) {
			long currentTime = times.get(i);
			if (currentTime < elapsedTime && currentTime > elapsedTime - 30) {
//				System.out.println("Enemy added: " + enemies.get(i).getCoordinate());
				grid.addEnemy(enemies.get(i));
			}
		}

		for (int i = 0; i < grid.getPowerups().size(); i++) {
			Powerup currentPowerup = grid.getPowerups().get(i);
			Coordinate lastCoo = currentPowerup.getCoordinate();
			Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentPowerup.getXVelocity()), (int) (lastCoo.getY() + currentPowerup.getYVelocity()));
			if (newCoo.getY() < 0)
				grid.removePowerup(currentPowerup);
			else {
				currentPowerup.setCoordinate(new Coordinate((int) (lastCoo.getX()), (int) (lastCoo.getY() + currentPowerup.getYVelocity())));
				currentPowerup.getHitbox().setCoordinate(newCoo);
			}
		}

		for (int i = 0; i < grid.getProjectiles().size(); i++) {
			Projectile currentProjectile = grid.getProjectiles().get(i);
//			System.out.println(currentProjectile.getHitbox().getHeight());
			Coordinate lastCoo = currentProjectile.getCoordinate();
			Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity()));
			if (newCoo.getX() + currentProjectile.getWidth() < 0 || newCoo.getX() > grid.getWidth() || newCoo.getY() < 0 || newCoo.getY() + currentProjectile.getHeight() > grid.getHeight())
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
					System.out.println("Action: " + i);
					System.out.println("X Velocity: " + currentAction.getXVelocity());
					System.out.println("Y Velocity: " + currentAction.getYVelocity());
					System.out.println("Shoot: " + currentAction.getFire());
					System.out.println("Fires At Player: " + currentAction.aimsAtPlayer());
					System.out.println("Loops: " + currentAction.getLoop());
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
				if (newCoo.getX() + currentEnemy.getWidth() < 0 || newCoo.getX() > grid.getWidth() || newCoo.getY() < 0 || newCoo.getY() + currentEnemy.getHeight() > grid.getHeight()) {
					grid.removeEnemy(currentEnemy);
				} else {
//					System.out.println(newCoo);
					currentEnemy.setCoordinate(newCoo);
					currentEnemy.getHitbox().setCoordinate(newCoo);
				}
			}
		}
		
		Coordinate playerCoo = player.getCoordinate();
		int netX = 0;
		int netY = 0;
		if (gameFrame.getLeft())
			netX -= 10;
		if (gameFrame.getRight())
			netX += 10;
		if (gameFrame.getUp())
			netY += 10;
		if (gameFrame.getDown())
			netY -= 10;
//		System.out.println(gameFrame.getAlt());
		if (gameFrame.getAlt())
			shoot();
		Coordinate newCoo = new Coordinate(playerCoo.getX() + netX, playerCoo.getY() + netY);
		if (newCoo.getX() < 0)
			newCoo.setX(0);
		if (newCoo.getX() > grid.getWidth() - player.getWidth())
			newCoo.setX(grid.getWidth() - player.getWidth());
		if (newCoo.getY() < player.getHeight())
			newCoo.setY(player.getHeight());
		if (newCoo.getY() > grid.getHeight())
			newCoo.setY(grid.getHeight());
		player.setCoordinate(newCoo);
		player.getHitbox().setCoordinate(newCoo);
		
//		System.out.println(player.getCoordinate().getX() + ", " + player.getCoordinate().getY());
//		System.out.println(grid.getPlayer().getCoordinate().getX() + ", " + grid.getPlayer().getCoordinate().getY());
//		System.out.println(left);
		
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
//				System.out.println("Player Hitbox:" + player.getHitbox().getCoordinate());
//				System.out.println("Enemy Hitbox:" + e.getHitbox().getCoordinate());
//				System.out.println(player.getHitbox().hit(e.getHitbox()));
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
		gameFrame.updateFrame(grid, score, lives, rolls, grid.getProjectiles().size(), grid.getEnemies().size(), grid.getPowerups().size());
	}

	private void startLevel(){
//		System.out.println("currentLevel < levels.size(): " + (currentLevel < levels.size()));
		shoot = true;
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
//					System.out.println("Timer iteration");
					nextFrame(initialTime);
				}
			}, new Date(initialTime), 30);
		} else {
			endGame();
		}
	}

	public void startGame() {
//		System.out.println("game started");
		score = 0;
		lives = 3;
		rolls = 2;
		grid.createPlayer();
		currentLevel = 0;
		startLevel();
	}
	
	//implement
	private void endLevel() {
		cancelTasks();
		currentLevel++;
//		System.out.println("level ended");
	}

	//implement
	private void endGame() {
		cancelTasks();
//		System.out.println("game ended");
		System.exit(0);
	}

	private void cancelTasks(){
		timer.cancel();
		timer.purge();
	}
	
	private void death() {
//		System.out.println("death");
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

	public static void main(String args[]){
		Grid grid = new Grid(800, 750);
		GamePanel gamePanel = new GamePanel();
		GameFrame frame = new GameFrame(gamePanel);
		Game game = new Game(frame, grid);
		game.startGame();
	}
}

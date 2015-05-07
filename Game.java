import java.sql.Date;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game{
	private int currentLevel;
	private int score;
	private int lives;
	private int shields;
	private int counter;
	private long initialTime;
	private Grid grid;
	private Timer timer;
	private ArrayList<Level> levels;
	private boolean shoot;
	private GameFrame gameFrame;
	private boolean quadGun;

	//	private Enemy[] test;

	public Game(GameFrame frame, Grid grid){
		gameFrame = frame;
		ArrayList<Long> times = new ArrayList<Long>();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		//		test = new Enemy[20];
		for (int i = 0; i < 20; i++) {
			//			Action a1 = new Action(2000, true, -2, 0, false, false, null, true, 4000);
			//			Action a2 = new Action(4000, true, 2, 0, false, false, null, true, 4000);
			//			Action a3 = new Action(3000, true, 0, -2, false, false, null, true, 4000);
			//			Action a4 = new Action(5000, true, 0, 2, false, false, null, true, 4000);
			ArrayList<Action> acts1 = new ArrayList<Action>();
			//			acts1.add(a1);
			//			acts1.add(a2);
			//			acts1.add(a3);
			//			acts1.add(a4);
			Enemy e1 = new Enemy(new Coordinate(30*i + 100, 400), 30, 30, 0, 0, 5, 500, acts1, Powerup.QUAD_GUN);
			//			System.out.println("X Velocity: " + e1.getXVelocity());
			//			System.out.println("Y Velocity: " + e1.getYVelocity());
			enemies.add(e1);
			times.add(new Long(1000));
			//			test[i] = e1;
		}
		Level testLevel = new Level(enemies, times, 9999999);
		levels = new ArrayList<Level>();
		levels.add(testLevel);
		this.grid = grid;
	}

	public long getInitialTime(){return initialTime;}

	public void shoot(){
		if (shoot) {
			Player p = grid.getPlayer();
			//			Projectile p1 = new Projectile(new Coordinate(p.getCoordinate().getX() + 13, p.getCoordinate().getY()), false, false);
			Projectile p1 = new Projectile(new Coordinate(p.getCoordinate().getX() + 3 , p.getCoordinate().getY()), false, false);
			Projectile p2= new Projectile(new Coordinate(p.getCoordinate().getX() + 23 , p.getCoordinate().getY()), false, false);

			if (quadGun) {
				Projectile p3 = new Projectile(new Coordinate(p.getCoordinate().getX() + 3 , p.getCoordinate().getY()), true, true);
				Projectile p4= new Projectile(new Coordinate(p.getCoordinate().getX() + 23 , p.getCoordinate().getY()), true, false);
				grid.addProjectile(p3);
				grid.addProjectile(p4);
			}
			grid.addProjectile(p1);
			grid.addProjectile(p2);
			shoot = false;
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					shoot = true;
				}
			}, 200);
		}
	}

	public void nextFrame(long initialTime){
		//		System.out.println("start");

		counter++;
		if (counter == 3) {
			counter = 0;
			long elapsedTime = System.currentTimeMillis() - initialTime;
			//		System.out.println(elapsedTime);
			Player player = grid.getPlayer();
			Level level = levels.get(currentLevel);
			ArrayList<Long> times = level.getEnemySpawnTimes();
			ArrayList<Enemy> enemies = level.getEnemies();
			for (int i = 0; i < times.size(); i++) {
				long currentTime = times.get(i);
				if (currentTime < elapsedTime) {
					//				System.out.println("Enemy added: " + enemies.get(i).getCoordinate());
					grid.addEnemy(enemies.get(i));
					enemies.remove(i);
					times.remove(i);
				}
			}

			for (int i = 0; i < grid.getPowerups().size(); i++) {
				Powerup currentPowerup = grid.getPowerups().get(i);
				Coordinate lastCoo = currentPowerup.getCoordinate();
				Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentPowerup.getXVelocity()), (int) (lastCoo.getY() + currentPowerup.getYVelocity()));
				if (newCoo.getY() < 0) {
					grid.removePowerup(currentPowerup);
					i--;
				}
				else {
					currentPowerup.setCoordinate(new Coordinate((int) (lastCoo.getX()), (int) (lastCoo.getY() + currentPowerup.getYVelocity())));
					currentPowerup.getHitbox().setCoordinate(newCoo);
				}
			}

			for (int i = 0; i < grid.getProjectiles().size(); i++) {
				Projectile currentProjectile = grid.getProjectiles().get(i);
				//			System.out.println(currentProjectile.getWidth());
				Coordinate lastCoo = currentProjectile.getCoordinate();
				Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity()));
				if (newCoo.getX() + currentProjectile.getWidth() < 0 || newCoo.getX() > grid.getWidth() || newCoo.getY() < 0 || newCoo.getY() - currentProjectile.getHeight() > grid.getHeight()) {
					grid.removeProjectile(currentProjectile);
					i--;
				} else {
					currentProjectile.setCoordinate(new Coordinate((int) (lastCoo.getX() + currentProjectile.getXVelocity()), (int) (lastCoo.getY() + currentProjectile.getYVelocity())));
					currentProjectile.getHitbox().setCoordinate(newCoo);
				}
			}

			for (int i = 0; i < grid.getEnemies().size(); i++) {
				//			System.out.println("loop");
				Enemy currentEnemy = grid.getEnemies().get(i);
				//			System.out.println("Enemy: " + i);
				//			System.out.println("Enemy X Velocity: " + currentEnemy.getXVelocity());
				//			System.out.println("Enemy Y Velocity: " + currentEnemy.getYVelocity());
				//			System.out.println(currentEnemy.getHealth());
				if (!currentEnemy.isAlive()) {
					//				System.out.println("removed");
					grid.removeEnemy(currentEnemy);
					i--;
				} else {
					Coordinate lastCoo = currentEnemy.getCoordinate();
					ArrayList<Action> currentActions = currentEnemy.getActions();
					for(int j = 0; j < currentEnemy.getActions().size(); j++) {
						//						System.out.println("Enemy: " + i + " Action: " + j);
						Action currentAction = currentActions.get(j);
						long delay = currentAction.getDelay();
						if (delay < elapsedTime) {
							//												System.out.println("Action: " + i);
							//						System.out.println("X Velocity: " + currentAction.getXVelocity());
							//						System.out.println("Y Velocity: " + currentAction.getYVelocity());
							//						System.out.println("Shoot: " + currentAction.getFire());
							//						System.out.println("Fires At Player: " + currentAction.aimsAtPlayer());
							//						System.out.println("Loops: " + currentAction.getLoop());
							if (currentAction.changesVelocity()) {
								currentEnemy.setXVelocity(currentAction.getXVelocity());
								currentEnemy.setYVelocity(currentAction.getYVelocity());
							}
							if (currentAction.getFire()) {
								if (currentAction.aimsAtPlayer()) 
									grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), player.getCoordinate()));
								else
									grid.addProjectile(new Projectile(true, currentEnemy.getCoordinate(), currentAction.getTargetCoordinate()));
							}
							currentActions.remove(currentAction);
							j--;
							if (currentAction.getLoop()) {
								//								System.out.println("Added action to Enemy " + i + "'s action list. Size: " + currentActions.size());
								currentActions.add(currentAction.generateLoopedCopy());
							}

						}
					}
					Coordinate newCoo = new Coordinate((int) (lastCoo.getX() + currentEnemy.getXVelocity()), (int) (lastCoo.getY() + currentEnemy.getYVelocity()));
					if (newCoo.getX() + currentEnemy.getWidth() < 0 || newCoo.getX() > grid.getWidth() || newCoo.getY() < 0 || newCoo.getY() - currentEnemy.getHeight() > grid.getHeight()) {
						grid.removeEnemy(currentEnemy);
						i--;
					} else {
						//					System.out.println(newCoo);
						currentEnemy.setCoordinate(newCoo);
						currentEnemy.getHitbox().setCoordinate(newCoo);
					}
				}
				//			System.out.println(currentEnemy.getActions().size());
			}
			Coordinate playerCoo = player.getCoordinate();
			int netX = 0;
			int netY = 0;
			if (gameFrame.getLeft())
				netX -= 7;
			if (gameFrame.getRight())
				netX += 7;
			if (gameFrame.getUp())
				netY += 7;
			if (gameFrame.getDown())
				netY -= 7;
			//		System.out.println(gameFrame.getAlt());
			if (gameFrame.getSpace())
				shoot();
			if (player.isHittable() && gameFrame.getShift())
				shield();
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
					if (player.isHittable() && player.getHitbox().hit(p.getHitbox())) {
						death();
						grid.removeProjectile(p);
						i--;
					}
				}
				//			System.out.println("frame");
				for (int i = 0; i < grid.getEnemies().size(); i++) {
					//				System.out.println("Enemy: " + i);
					Enemy e = grid.getEnemies().get(i);
					//				System.out.println("Player Hitbox:" + player.getHitbox().getCoordinate());
					//				System.out.println("Enemy Hitbox:" + e.getHitbox().getCoordinate());
					//				System.out.println(player.getHitbox().hit(e.getHitbox()));
					if (player.isHittable() && player.getHitbox().hit(e.getHitbox())) {
						//					System.out.println("hit");
						grid.removeEnemy(e);
						i--;
						death();
					}
				}
			}
			for (int i = 0; i < grid.getPowerups().size(); i++) {
				Powerup p = grid.getPowerups().get(i);
				//Implement powerups
				if (player.getHitbox().hit(p.getHitbox())) {
					if (p.getType() == Powerup.QUAD_GUN) {
						if (quadGun)
							score += 1000;
						else
							quadGun = true;
					} else if (p.getType() == Powerup.ENEMY_CRASH) {
						score += grid.destroyAllEnemies();
					} else if (p.getType() == Powerup.EXTRA_LIFE) {
						lives++;
					} else if (p.getType() == Powerup.NO_ENEMY_BULLETS) {
						grid.removeAllEnemyProjectiles();
					} else if (p.getType() == Powerup.EXTRA_SHIELD) {
						shields++;
					} else if (p.getType() == Powerup.THOUSAND_POINTS) {
						score += 1000;
					}
					grid.removePowerup(p);
				}
			}
			for (int i = 0; i < grid.getEnemies().size(); i++) {
				Enemy currentEnemy = grid.getEnemies().get(i);
				for (int j = 0; j < grid.getFriendlyProjectiles().size(); j++) {
					Projectile currentProjectile = grid.getFriendlyProjectiles().get(j);
					if (currentEnemy.getHitbox().hit(currentProjectile.getHitbox())) {
						grid.removeProjectile(currentProjectile);
						j--;
						currentEnemy.hit();
						if (!currentEnemy.isAlive()) {
							score += currentEnemy.getPoints();
							currentEnemy.removePoints();
							if (currentEnemy.hasPowerup()) {
								grid.addPowerup(currentEnemy.getPowerup());
								currentEnemy.removePowerup();
							}
								
						}
					}
				}
			}
		}
		gameFrame.updateFrame(grid, score, lives, shields, grid.getProjectiles().size(), grid.getEnemies().size(), grid.getPowerups().size());
		//		for (int i = 0; i < 20; i++) {
		//			System.out.println(grid.getEnemies().indexOf(test[i]));
		//		}
		//		System.out.println("end");

	}

	private void shield() {
		if (shields > 0) {
			shields--;
			grid.getPlayer().setHittable(false);
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					grid.getPlayer().setHittable(true);
				}
			}, 3000);
		}
	}

	private void startLevel(){
		//		System.out.println("currentLevel < levels.size(): " + (currentLevel < levels.size()));
		shoot = true;
		counter = 0;
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
			}, new Date(initialTime), 10);
		} else {
			endGame();
		}
	}

	public void startGame() {
		//		System.out.println("game started");
		quadGun = false;
		score = 0;
		lives = 3;
		shields = 2;
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
			quadGun = false;
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

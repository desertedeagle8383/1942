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
		//		System.out.println(grid.getWidth());
		//		System.out.println(grid.getHeight());
		gameFrame = frame;
		ArrayList<Long> times = new ArrayList<Long>();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		//		test = new Enemy[20];

		//ORIGINAL TEST FORMATION

		//		for (int i = 0; i < 20; i++) {
		//			Action a1 = new Action(2000, -2, 0, true, 4000);
		//			Action a2 = new Action(4000, 2, 0, true, 4000);
		//			Action a3 = new Action(3000, 0, -2, true, 4000);
		//			Action a4 = new Action(5000, 0, 2, true, 4000);
		//			Action a5 = new Action(2000, true, null, true, 3000);
		//			Action a6 = new Action(3000, false, new Coordinate(0, 0), true, 3000);
		//			Action a7 = new Action(4000, false, 90, true, 3000);
		//			ArrayList<Action> acts1 = new ArrayList<Action>();
		//			acts1.add(a1);
		//			acts1.add(a2);
		//			acts1.add(a3);
		//			acts1.add(a4);
		//			acts1.add(a5);
		//			acts1.add(a6);
		//			acts1.add(a7);
		//			Enemy e1 = new Enemy(new Coordinate(30*i + 100, 400), 30, 30, 0, 0, 5, 500, acts1, Powerup.QUAD_GUN);
		//			//			System.out.println("X Velocity: " + e1.getXVelocity());
		//			//			System.out.println("Y Velocity: " + e1.getYVelocity());
		//			enemies.add(e1);
		//			times.add(new Long(1000));
		//			//			test[i] = e1;
		//		}

		//FORMATION 2

		//				ArrayList<ArrayList<Action>> acts1 = new ArrayList<ArrayList<Action>>();
		//				for (int i = 0; i < 15; i++) {
		//					Action a1 = new Action(5000, false, 0, true, 2000);
		//					Action a2 = new Action(5500, false, Math.PI/2, true, 2000);
		//					Action a3 = new Action(6000, false, Math.PI, true, 2000);
		//					Action a4 = new Action(6500, false, Math.PI*3/2, true, 2000);
		//					ArrayList<Action> act = new ArrayList<Action>(1);
		//					act.add(a1);
		//					act.add(a2);
		//					act.add(a3);
		//					act.add(a4);
		//					acts1.add(act);
		//				}
		//				Enemy e1 = new Enemy(new Coordinate(450, 700), 30, 30, 0, -1, 5, 500, acts1.get(0), Powerup.QUAD_GUN);
		//				Enemy e2 = new Enemy(new Coordinate(430, 700), 30, 30, 0, -1, 5, 500, acts1.get(1), Powerup.QUAD_GUN);
		//				Enemy e3 = new Enemy(new Coordinate(470, 700), 30, 30, 0, -1, 5, 500, acts1.get(2), Powerup.QUAD_GUN);
		//				Enemy e4 = new Enemy(new Coordinate(410, 700), 30, 30, 0, -1, 5, 500, acts1.get(3), Powerup.QUAD_GUN);
		//				Enemy e5 = new Enemy(new Coordinate(490, 700), 30, 30, 0, -1, 5, 500, acts1.get(4), Powerup.QUAD_GUN);
		//				Enemy e6 = new Enemy(new Coordinate(400, 700), 30, 30, 0, -1, 5, 500, acts1.get(5), Powerup.QUAD_GUN);
		//				Enemy e7 = new Enemy(new Coordinate(500, 700), 30, 30, 0, -1, 5, 500, acts1.get(6), Powerup.QUAD_GUN);
		//				Enemy e8 = new Enemy(new Coordinate(400, 700), 30, 30, 0, -1, 5, 500, acts1.get(7), Powerup.QUAD_GUN);
		//				Enemy e9 = new Enemy(new Coordinate(500, 700), 30, 30, 0, -1, 5, 500, acts1.get(8), Powerup.QUAD_GUN);
		//				Enemy e10 = new Enemy(new Coordinate(430, 700), 30, 30, 0, -1, 5, 500, acts1.get(9), Powerup.QUAD_GUN);
		//				Enemy e11 = new Enemy(new Coordinate(470, 700), 30, 30, 0, -1, 5, 500, acts1.get(10), Powerup.QUAD_GUN);
		//				Enemy e12 = new Enemy(new Coordinate(430, 700), 30, 30, 0, -1, 5, 500, acts1.get(11), Powerup.QUAD_GUN);
		//				Enemy e13 = new Enemy(new Coordinate(470, 700), 30, 30, 0, -1, 5, 500, acts1.get(12), Powerup.QUAD_GUN);
		//				Enemy e14 = new Enemy(new Coordinate(470, 700), 30, 30, 0, -1, 5, 500, acts1.get(13), Powerup.QUAD_GUN);
		//				Enemy e15 = new Enemy(new Coordinate(430, 700), 30, 30, 0, -1, 5, 500, acts1.get(14), Powerup.QUAD_GUN);
		//				times.add(new Long(500));
		//				times.add(new Long(1000));
		//				times.add(new Long(1000));
		//				times.add(new Long(1500));
		//				times.add(new Long(1500));
		//				times.add(new Long(2000));
		//				times.add(new Long(2000));
		//				times.add(new Long(2500));
		//				times.add(new Long(2500));
		//				times.add(new Long(3000));
		//				times.add(new Long(3000));
		//				times.add(new Long(3500));
		//				times.add(new Long(3500));
		//				times.add(new Long(4000));
		//				times.add(new Long(4000));
		//				enemies.add(e1);
		//				enemies.add(e2);
		//				enemies.add(e3);
		//				enemies.add(e4);
		//				enemies.add(e5);
		//				enemies.add(e6);
		//				enemies.add(e7);
		//				enemies.add(e8);
		//				enemies.add(e9);
		//				enemies.add(e10);
		//				enemies.add(e11);
		//				enemies.add(e12);
		//				enemies.add(e13);
		//				enemies.add(e14);
		//				enemies.add(e15);
		
		//Level 1
		ArrayList<Action> acts01 = new ArrayList<Action>();
		acts01.add(new Action(3000, true, null, true, 1500));
		Enemy e01 = new Enemy(new Coordinate(450, 779), 30, 30, 0, -3, 3, 500, acts01);
		times.add((long) 2000);
		enemies.add(e01);
		
		ArrayList<Action> acts02 = new ArrayList<Action>();
		acts02.add(new Action(7000, true, null, true, 1500));
		Enemy e02 = new Enemy(new Coordinate(210, 779), 30, 30, 0, -3, 3, 500, acts02);
		times.add((long) 6000);
		enemies.add(e02);
		
		ArrayList<Action> acts03 = new ArrayList<Action>();
		acts03.add(new Action(9000, true, null, true, 1500));
		Enemy e03 = new Enemy(new Coordinate(740, 779), 30, 30, 0, -3, 3, 500, acts03);
		times.add((long) 8000);
		enemies.add(e03);
		
		ArrayList<Action> acts04 = new ArrayList<Action>();
		acts04.add(new Action(11500, true, null, true, 500));
		Enemy e04 = new Enemy(new Coordinate(799, 779), 30, 30, -5, -5, 3, 500, acts04);
		times.add((long) 11000);
		enemies.add(e04);
		
		ArrayList<Action> acts05 = new ArrayList<Action>();
		acts05.add(new Action(12000, true, null, true, 500));
		Enemy e05 = new Enemy(new Coordinate(-29, 779), 30, 30, 5, -5, 3, 500, acts05);
		times.add((long) 11500);
		enemies.add(e05);
		
		ArrayList<Action> acts06 = new ArrayList<Action>();
		acts06.add(new Action(15000, 4, -4, false, 0));
		acts06.add(new Action(15500, 0, -6, false, 0));
		acts06.add(new Action(16000, -4, -4, false, 0));
		acts06.add(new Action(16500, -6, -0, false, 0));
		acts06.add(new Action(17000, -4, 4, false, 0));
		acts06.add(new Action(17500, 0, 6, false, 0));
		acts06.add(new Action(18000, 4, 4, false, 0));
		acts06.add(new Action(18500, 6, 0, false, 0));
		acts06.add(new Action(14000, true, null, true, 1000));
		Enemy e06 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts06);
		times.add((long) 13000);
		enemies.add(e06);
		
		ArrayList<Action> acts07 = new ArrayList<Action>();
		acts07.add(new Action(15500, 4, -4, false, 0));
		acts07.add(new Action(16000, 0, -6, false, 0));
		acts07.add(new Action(16500, -4, -4, false, 0));
		acts07.add(new Action(17000, -6, -0, false, 0));
		acts07.add(new Action(17500, -4, 4, false, 0));
		acts07.add(new Action(18000, 0, 6, false, 0));
		acts07.add(new Action(18500, 4, 4, false, 0));
		acts07.add(new Action(19000, 6, 0, false, 0));
		acts07.add(new Action(14500, true, null, true, 1500));
		Enemy e07 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts07);
		times.add((long) 13500);
		enemies.add(e07);
		
		ArrayList<Action> acts08 = new ArrayList<Action>();
		acts08.add(new Action(16000, 4, -4, false, 0));
		acts08.add(new Action(16500, 0, -6, false, 0));
		acts08.add(new Action(17000, -4, -4, false, 0));
		acts08.add(new Action(17500, -6, -0, false, 0));
		acts08.add(new Action(18000, -4, 4, false, 0));
		acts08.add(new Action(18500, 0, 6, false, 0));
		acts08.add(new Action(19000, 4, 4, false, 0));
		acts08.add(new Action(19500, 6, 0, false, 0));
		acts08.add(new Action(15000, true, null, true, 1500));
		Enemy e08 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts08);
		times.add((long) 14000);
		enemies.add(e08);
		
		ArrayList<Action> acts09 = new ArrayList<Action>();
		acts09.add(new Action(16500, 4, -4, false, 0));
		acts09.add(new Action(17000, 0, -6, false, 0));
		acts09.add(new Action(17500, -4, -4, false, 0));
		acts09.add(new Action(18000, -6, -0, false, 0));
		acts09.add(new Action(18500, -4, 4, false, 0));
		acts09.add(new Action(19000, 0, 6, false, 0));
		acts09.add(new Action(19500, 4, 4, false, 0));
		acts09.add(new Action(20000, 6, 0, false, 0));
		acts09.add(new Action(15500, true, null, true, 1500));
		Enemy e09 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts09);
		times.add((long) 14500);
		enemies.add(e09);
		
		ArrayList<Action> acts10 = new ArrayList<Action>();
		acts10.add(new Action(17000, 4, -4, false, 0));
		acts10.add(new Action(17500, 0, -6, false, 0));
		acts10.add(new Action(18000, -4, -4, false, 0));
		acts10.add(new Action(18500, -6, -0, false, 0));
		acts10.add(new Action(19000, -4, 4, false, 0));
		acts10.add(new Action(19500, 0, 6, false, 0));
		acts10.add(new Action(20000, 4, 4, false, 0));
		acts10.add(new Action(20500, 6, 0, false, 0));
		acts10.add(new Action(16000, true, null, true, 1500));
		Enemy e10 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts10, Powerup.QUAD_GUN);
		times.add((long) 15000);
		enemies.add(e10);
		
		ArrayList<Action> acts11 = new ArrayList<Action>();
		acts11.add(new Action(22000, 4, -4, false, 0));
		acts11.add(new Action(22500, 0, -6, false, 0));
		acts11.add(new Action(23000, -4, -4, false, 0));
		acts11.add(new Action(23500, -6, -0, false, 0));
		acts11.add(new Action(24000, -4, 4, false, 0));
		acts11.add(new Action(24500, 0, 6, false, 0));
		acts11.add(new Action(25000, 4, 4, false, 0));
		acts11.add(new Action(25500, 6, 0, false, 0));
		acts11.add(new Action(21000, true, null, true, 1000));
		Enemy e11 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts11);
		times.add((long) 20000);
		enemies.add(e11);
		
		ArrayList<Action> acts12 = new ArrayList<Action>();
		acts12.add(new Action(22500, 4, -4, false, 0));
		acts12.add(new Action(23000, 0, -6, false, 0));
		acts12.add(new Action(23500, -4, -4, false, 0));
		acts12.add(new Action(24000, -6, -0, false, 0));
		acts12.add(new Action(24500, -4, 4, false, 0));
		acts12.add(new Action(25000, 0, 6, false, 0));
		acts12.add(new Action(25500, 4, 4, false, 0));
		acts12.add(new Action(26000, 6, 0, false, 0));
		acts12.add(new Action(21500, true, null, true, 1500));
		Enemy e12 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts12);
		times.add((long) 20500);
		enemies.add(e12);
		
		ArrayList<Action> acts13 = new ArrayList<Action>();
		acts13.add(new Action(23000, 4, -4, false, 0));
		acts13.add(new Action(23500, 0, -6, false, 0));
		acts13.add(new Action(24000, -4, -4, false, 0));
		acts13.add(new Action(24500, -6, -0, false, 0));
		acts13.add(new Action(25000, -4, 4, false, 0));
		acts13.add(new Action(25500, 0, 6, false, 0));
		acts13.add(new Action(26000, 4, 4, false, 0));
		acts13.add(new Action(26500, 6, 0, false, 0));
		acts13.add(new Action(22000, true, null, true, 1500));
		Enemy e13 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts13);
		times.add((long) 21000);
		enemies.add(e13);
		
		ArrayList<Action> acts14 = new ArrayList<Action>();
		acts14.add(new Action(23500, 4, -4, false, 0));
		acts14.add(new Action(24000, 0, -6, false, 0));
		acts14.add(new Action(24500, -4, -4, false, 0));
		acts14.add(new Action(25000, -6, -0, false, 0));
		acts14.add(new Action(25500, -4, 4, false, 0));
		acts14.add(new Action(26000, 0, 6, false, 0));
		acts14.add(new Action(26500, 4, 4, false, 0));
		acts14.add(new Action(27000, 6, 0, false, 0));
		acts14.add(new Action(22500, true, null, true, 1500));
		Enemy e14 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts14);
		times.add((long) 21500);
		enemies.add(e14);
		
		ArrayList<Action> acts15 = new ArrayList<Action>();
		acts15.add(new Action(24000, 4, -4, false, 0));
		acts15.add(new Action(24500, 0, -6, false, 0));
		acts15.add(new Action(25000, -4, -4, false, 0));
		acts15.add(new Action(25500, -6, -0, false, 0));
		acts15.add(new Action(26000, -4, 4, false, 0));
		acts15.add(new Action(26500, 0, 6, false, 0));
		acts15.add(new Action(27000, 4, 4, false, 0));
		acts15.add(new Action(27500, 6, 0, false, 0));
		acts15.add(new Action(23000, true, null, true, 1500));
		Enemy e15 = new Enemy(new Coordinate(-29, 600), 30, 30, 6, 0, 3, 500, acts15, Powerup.QUAD_GUN);
		times.add((long) 22000);
		enemies.add(e15);
		
		Level level1 = new Level(enemies, times, 30000);
		levels = new ArrayList<Level>();
		levels.add(level1);
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
					//									System.out.println("Enemy added: " + enemies.get(i).getCoordinate());
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
								Coordinate currentCoo = currentEnemy.getCoordinate();
								Coordinate shootCoo = new Coordinate(currentCoo.getX() + (int) (currentEnemy.getWidth()/2), currentCoo.getY() - currentEnemy.getHeight());
								if (currentAction.aimsAtPlayer()) {
									grid.addProjectile(new Projectile(true, shootCoo, player.getCoordinate()));
								}
								else {
									if (currentAction.hasTarget()) {
										grid.addProjectile(new Projectile(true, shootCoo, currentAction.getTargetCoordinate()));
									} else {
										grid.addProjectile(new Projectile(true, shootCoo, currentAction.getAngle()));
									}
								}
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
		gameFrame.updateFrame(grid, score, lives, shields, grid.getEnemies().size());
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
		if (currentLevel == levels.size())
			endGame();
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

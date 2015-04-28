import java.util.ArrayList;

public class Grid {
	private int width;
	private int height;
	private ArrayList<Enemy> enemies;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Powerup> powerups;
	private ArrayList<Projectile> enemyProjectiles;
	private ArrayList<Projectile> friendlyProjectiles;
	private Player player;

	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		enemies = new ArrayList<Enemy>();
		projectiles = new ArrayList<Projectile>();
		powerups = new ArrayList<Powerup>();
		enemyProjectiles = new ArrayList<Projectile>();
		friendlyProjectiles = new ArrayList<Projectile>();
	}

	public void addPowerup(Powerup powerup){
		powerups.add(powerup);
	}
	public void removePowerup(Powerup powerup){
		powerups.add(powerup);
	}
	public void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}
	public void removeEnemy(Enemy enemy){
		enemies.remove(enemy);
	}
	public void addProjectile(Projectile projectile){
		projectiles.add(projectile);
		if (projectile.isEnemyProjectile()) {
			enemyProjectiles.add(projectile);
		} else {
			friendlyProjectiles.add(projectile);
		}
	}
	public void removeProjectile(Projectile projectile){
		projectiles.remove(projectile);
		if (projectile.isEnemyProjectile()) {
			enemyProjectiles.remove(projectile);
		} else {
			friendlyProjectiles.remove(projectile);
		}
	}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public ArrayList<Enemy> getEnemies(){return enemies;}
	public ArrayList<Projectile> getProjectiles(){return projectiles;}
	public ArrayList<Projectile> getEnemyProjectiles(){return enemyProjectiles;}
	public ArrayList<Projectile> getFriendlyProjectiles(){return friendlyProjectiles;}
	public ArrayList<Powerup> getPowerups(){return powerups;}
	public void createPlayer(){
		player = new Player();
	}
	public void removeAllEnemyProjectiles() {
		for (int i = 0; i < enemyProjectiles.size(); i++) {
			Projectile p = enemyProjectiles.get(i);
			enemyProjectiles.remove(p);
			projectiles.remove(p);
		}
	}
	public int destroyAllEnemies() {
		int total = 0;
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			total += e.getPoints();
			enemies.remove(e);
		}
		return total;
	}
	
	public Player getPlayer(){return player;}
}

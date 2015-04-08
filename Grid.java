import java.util.ArrayList;

public class Grid {
	private int width;
	private int height;
	private ArrayList<Enemy> enemies;
	private ArrayList<Projectile> projectiles;
	private Player player;

	public Grid(int width, int height){
		this.width = width;
		this.height = height;
	}
	public void addEnemy(Enemy enemy){
		enemies.add(enemy);
	}
	public void removeEnemy(Enemy enemy){
		enemies.remove(enemy);
	}
	public void addProjectile(Projectile projectile){
		projectiles.add(projectile);
	}
	public void removeProjectile(Projectile projectile){
		projectiles.remove(projectile);
	}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public ArrayList<Enemy> getEnemies(){return enemies;}
	public ArrayList<Projectile> getProjectiles(){return projectiles;}
	public void createPlayer(){
		player = new Player();
	}
	public Player getPlayer(){return player;}
}

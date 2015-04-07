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
    	for(int i = 0; i < enemies.size(); i++){
    		if (enemies.get(i) == enemy)
    			enemies.remove(i);
    	}
    }
    public void addProjectile(Projectile projectile){
    	projectiles.add(projectile);
    }
    public void removeProjectile(Projectile projectile){
    	for(int i = 0; i < projectiles.size(); i++){
    		if (projectiles.get(i) == projectile)
    			projectiles.remove(i);
    	}
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

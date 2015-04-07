import java.awt.Rectangle;

public class Hitbox {
	public boolean hit(Player player, Projectile projectile){
		// size of player image -> 30 x 30 pixels, size of projectile -> 10 x 10
		
		Rectangle playerBox = new Rectangle();
		Rectangle projectileBox = new Rectangle();
		
		playerBox.setBounds(player.getCoordinate().getX(), player.getCoordinate().getY(), 30, 30);
		projectileBox.setBounds(projectile.getCoordinate().getX(), projectile.getCoordinate().getY(), 10, 10);
		
		return playerBox.intersects(projectileBox);
	}
	public boolean hit(Enemy enemy, Projectile projectile){
		// size of enemy image -> 30 x 30 pixels, size of projectile -> 10 x 10
		
		Rectangle enemyBox = new Rectangle();
		Rectangle projectileBox = new Rectangle();
		
		enemyBox.setBounds(enemy.getCoordinate().getX(), enemy.getCoordinate().getY(), 30, 30);
		projectileBox.setBounds(projectile.getCoordinate().getX(), projectile.getCoordinate().getY(), 10, 10);
		
		return enemyBox.intersects(projectileBox);
	}
	public boolean hit(Player player, Enemy enemy){
		// size of enemy image -> 30 x 30 pixels, size of projectile -> 10 x 10
		
		Rectangle playerBox = new Rectangle();
		Rectangle enemyBox = new Rectangle();

		playerBox.setBounds(player.getCoordinate().getX(), player.getCoordinate().getY(), 10, 10);
		enemyBox.setBounds(enemy.getCoordinate().getX(), enemy.getCoordinate().getY(), 30, 30);

		return playerBox.intersects(enemyBox);
	}
}

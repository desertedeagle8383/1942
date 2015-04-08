
public class Projectile extends Thing{
	private boolean enemyProjectile;
	
	public Projectile(boolean enemy, Coordinate coordinate) {
		enemyProjectile = enemy;
		this.setCoordinate(coordinate);
	}
	public boolean isEnemyProjectile() {
		return enemyProjectile;
	}
}

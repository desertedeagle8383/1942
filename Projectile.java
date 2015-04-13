
public class Projectile extends Thing{
	private boolean enemyProjectile;
	
	public Projectile(boolean enemy, Coordinate coordinate, Coordinate targetCoordinate) {
		enemyProjectile = enemy;
		double angle;
		if (targetCoordinate.getX() - coordinate.getX() == 0) {
			if (targetCoordinate.getY() > coordinate.getY())
				angle = Math.PI/2;
			else 
				angle = -Math.PI/2;
		} else {
			angle = Math.atan((targetCoordinate.getY() - coordinate.getY())/(targetCoordinate.getX() - coordinate.getX()));
		}
		this.setCoordinate(coordinate);
		this.setXVelocity((int) (450*Math.cos(angle)));
		this.setYVelocity((int) (450*Math.sin(angle)));
	}
	
	public Projectile(boolean enemy, Coordinate coordinate) {
		enemyProjectile = enemy;
		this.setCoordinate(coordinate);
		this.setXVelocity(0);
		this.setYVelocity(450);
	}
	
	public boolean isEnemyProjectile() {
		return enemyProjectile;
	}
}


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
		setCoordinate(coordinate);
		setXVelocity((int) (10*Math.cos(angle)));
		setYVelocity((int) (10*Math.sin(angle)));
		setWidth(5);
		setHeight(5);
		setHitbox(new Hitbox(coordinate, 5, 5));
	}
	
	public Projectile(boolean enemy, Coordinate coordinate) {
		enemyProjectile = false;
		this.setCoordinate(coordinate);
		this.setXVelocity(0);
		this.setYVelocity(10);
	}
	
	public boolean isEnemyProjectile() {
		return enemyProjectile;
	}
}

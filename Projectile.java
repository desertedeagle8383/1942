public class Projectile extends Thing{
	private boolean enemyProjectile;
	private String filePath = "Z:\\programming\\workspace2\\1942\\src\\Projectile.png";
	
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
		setXVelocity((int) (20*Math.cos(angle)));
		setYVelocity((int) (20*Math.sin(angle)));
		setWidth(5);
		setHeight(5);
		setHitbox(new Hitbox(coordinate, 5, 5));
		setImage(filePath);
	}
	public Projectile(boolean enemy, Coordinate coordinate) {
		enemyProjectile = false;
		setCoordinate(coordinate);
		setXVelocity(0);
		setYVelocity(20);
		setWidth(5);
		setHeight(5);
		setHitbox(new Hitbox(coordinate, 5, 5));
		setImage(filePath);
	}
	public boolean isEnemyProjectile() {
		return enemyProjectile;
	}
}

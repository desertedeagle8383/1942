public class Projectile extends Thing{
	private boolean enemyProjectile;
	private String filePath1 = "Enemy_Projectile.png";
	private String filePath2 = "Friendly_Projectile.png";

	public Projectile(boolean enemy, Coordinate coordinate, Coordinate targetCoordinate) {
		enemyProjectile = enemy;
		setCoordinate(coordinate);
		double dx = targetCoordinate.getX() - coordinate.getX();
		double dy = targetCoordinate.getY() - coordinate.getY();
		double h = Math.sqrt(dy*dy + dx*dx);
		setXVelocity((int) (10*dx/h));
		setYVelocity((int) (10*dy/h));
		setWidth(8);
		setHeight(8);
		setHitbox(new Hitbox(coordinate, 8, 8));
		setImage(filePath1);
	}
	public Projectile(boolean enemy, Coordinate coordinate, double angle) {
		enemyProjectile = enemy;
		setCoordinate(coordinate);
		setXVelocity((int) (15*Math.cos(angle)));
		setYVelocity((int) (15*Math.sin(angle)));
		setWidth(8);
		setHeight(8);
		setHitbox(new Hitbox(coordinate, 8, 8));
		setImage(filePath1);
	}
	public Projectile(Coordinate coordinate, boolean angled, boolean left) {
		enemyProjectile = false;
		setCoordinate(coordinate);
		if (angled) {
			if (left)
				setXVelocity(-9);
			else
				setXVelocity(9);
			setYVelocity(11);
		} else {
			setXVelocity(0);
			setYVelocity(15);
		}
		setWidth(8);
		setHeight(8);
		setHitbox(new Hitbox(coordinate, 8, 8));
		setImage(filePath2);
	}
	public boolean isEnemyProjectile() {
		return enemyProjectile;
	}
}

public class Projectile extends Thing{
	private boolean enemyProjectile;
	private String filePath1 = "Z:\\programming\\workspace2\\1942\\src\\Enemy_Projectile.png";
	private String filePath2 = "Z:\\programming\\workspace2\\1942\\src\\Friendly_Projectile.png";

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

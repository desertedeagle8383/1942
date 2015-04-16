public class Player extends Thing{
	private boolean hittable;
	private String filePath = "Z:\\My Documents\\1942\\src\\Player.png";
	public Player() {
		setCoordinate(new Coordinate(400, 100));
		setXVelocity(0);
		setYVelocity(0);
		setWidth(30);
		setHeight(30);
		setHitbox(new Hitbox(new Coordinate(400, 100), 30, 30));
		setImage(filePath);
	}
	public boolean isHittable(){return hittable;}
	public void setHittable(boolean hittable){this.hittable = hittable;}
}

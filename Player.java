public class Player extends Thing{
	private boolean hittable;
	private String filePath1 = "Player.png";
	private String filePath2 = "Shielded_Player.png";
	public Player() {
		hittable = true;
		setCoordinate(new Coordinate(400, 100));
		setXVelocity(0);
		setYVelocity(0);
		setWidth(30);
		setHeight(30);
		setHitbox(new Hitbox(new Coordinate(400, 100), 30, 30));
		setImage(filePath1);
	}
	public boolean isHittable(){return hittable;}
	public void setHittable(boolean hittable){
		this.hittable = hittable;
		if (hittable) 
			setImage(filePath1);
		else
			setImage(filePath2);
	}
}

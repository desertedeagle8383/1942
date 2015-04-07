
public abstract class Plane extends Thing{
	private Hitbox hitbox; 
	private int health;
	
	public Hitbox getHitbox(){return hitbox;}
	public int getHealth(){return health;}
	public void hit(){
		health--;
	}
	public void fire(){
		
	}
}

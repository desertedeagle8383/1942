import java.awt.event.ActionListener;
import java.util.Timer;

public class Game{
	private int score;
    private int lives;
    private int rolls;
    private long initialTime;
    private Grid grid;
    private Timer timer;
    
    public Game(Grid grid){
    	score = 0;
    	lives = 3;
    	rolls = 2;
    	grid.createPlayer();
    	startTimer();
    }
    
    public int getScore(){return score;}
    public int getLives(){return lives;}
    public int getRolls(){return rolls;}
    public long getInitialTime(){return initialTime;}
    public Grid getGrid(){return grid;}
    
    public void shoot(){
    	Projectile newProjectile = new Projectile();
    	
    	newProjectile.setXVelocity(0);
    	newProjectile.setYVelocity(1);
    	grid.addProjectile(newProjectile);
    }
    
    public void nextFrame(){
    	//what to do here?
    }
    
    public void startTimer(){
    	timer = new Timer();
    	initialTime = System.currentTimeMillis();
    }
    
    public void cancelTasks(){
    	timer.purge();
    }
}

import java.util.ArrayList;

public class Level {
	private ArrayList<Enemy> enemyList;
	private ArrayList<Long> enemySpawnTimeList;
	private long levelTime;
	
	public Level (ArrayList<Enemy> enemies, ArrayList<Long> times, long time) {
		enemyList = enemies;
		enemySpawnTimeList = times;
		levelTime = time;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemyList;
	}
	public ArrayList<Long> getEnemySpawnTimes() {
		return enemySpawnTimeList;
	}
	public long getLevelLength() {
		return levelTime;
	}
}

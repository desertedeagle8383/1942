
public class Action {
	public final int CHANGE_X_VELOCITY = 123;
	public final int CHANGE_Y_VELOCITY = 321;
	public final int loop = 456;
	public final int CHANGE_BOTH = 987;
	public final int FIRE = 789;
	private long delay;
	private int actionType;
	
	public Action(int actionType){
		this.actionType = actionType;
	}
	public int getActionType(){return actionType;}
	public long getDelay(){return delay;}
}

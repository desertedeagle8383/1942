
public class Action {
	private int xVelocity;
	private int yVelocity;
	private boolean fire;
	private boolean loop;
	private boolean aimAtPlayer;
	private Coordinate target;
	private long delay;
	private long loopDelay;

	public Action(long time, int dx, int dy, boolean shoot, boolean fireAtPlayer, Coordinate targetCoo, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = shoot;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = targetCoo;
	}
	public int getXVelocity() {
		return xVelocity;
	}
	public int getYVelocity() {
		return yVelocity;
	}
	public boolean getFire() {
		return fire;
	}
	public long getDelay() {
		return delay;
	}
	public boolean getLoop() {
		return loop;
	}
	public long getLoopDelay() {
		return loopDelay;
	}
	public boolean aimsAtPlayer() {
		return aimAtPlayer;
	}
	public Coordinate getTargetCoordinate() {
		return target;
	}
	public Action generateLoopedCopy() {
		return new Action(delay+loopDelay, xVelocity, yVelocity, fire, aimAtPlayer, target, true, loopDelay);
	}
}

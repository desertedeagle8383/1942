
public class Action {
	private double xVelocity;
	private double yVelocity;
	private boolean fire;
	private boolean loop;
	private boolean aimAtPlayer;
	private Coordinate target;
	private long delay;
	private long loopDelay;

	public Action(long time, double dx, double dy, boolean shoot, boolean fireAtPlayer, Coordinate targetCoo, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = shoot;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = targetCoo;
	}
	public double getXVelocity() {
		return xVelocity;
	}
	public double getYVelocity() {
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
}

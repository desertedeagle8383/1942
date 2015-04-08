
public class Action {
	private double xVelocity;
	private double yVelocity;
	private boolean fire;
	private boolean loop;
	private long delay;
	private long loopDelay;

	public Action(double dx, double dy, boolean shoot, boolean repeat, long time, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = shoot;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
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
}

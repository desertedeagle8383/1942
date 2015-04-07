
public class Action {
	private double xVelocity;
	private double yVelocity;
	private boolean fire;
	private long delay;

	public Action(double dx, double dy, boolean shoot, long time) {
		xVelocity = dx;
		yVelocity = dy;
		fire = shoot;
		delay = time;
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
}

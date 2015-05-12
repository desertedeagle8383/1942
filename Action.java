
public class Action {
	private int xVelocity;
	private int yVelocity;
	private double angle;
	private boolean fire;
	private boolean loop;
	private boolean aimAtPlayer;
	private boolean changeVelocity;
	private Coordinate target;
	private long delay;
	private long loopDelay;

	public Action(long time, boolean changeV, int dx, int dy, boolean shoot, boolean fireAtPlayer, Coordinate targetCoo, double a, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = shoot;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = targetCoo;
		angle = a;
		changeVelocity = changeV;
	}
	public Action(long time, int dx, int dy, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = false;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = false;
		target = null;
		angle = 0;
		changeVelocity = true;
	}
	public Action(long time, boolean fireAtPlayer, Coordinate targetCoo, boolean repeat, long repeatDelay) {
		xVelocity = 0;
		yVelocity = 0;
		fire = true;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = targetCoo;
		angle = 0;
		changeVelocity = false;
	}
	public Action(long time, boolean fireAtPlayer, double a, boolean repeat, long repeatDelay) {
		xVelocity = 0;
		yVelocity = 0;
		fire = true;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = null;
		angle = a;
		changeVelocity = false;
	}
	public Action(long time, int dx, int dy, boolean fireAtPlayer, Coordinate targetCoo, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = true;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = targetCoo;
		changeVelocity = true;
	}
	public Action(long time, int dx, int dy, boolean fireAtPlayer, double a, boolean repeat, long repeatDelay) {
		xVelocity = dx;
		yVelocity = dy;
		fire = true;
		delay = time;
		loop = repeat;
		loopDelay = repeatDelay;
		aimAtPlayer = fireAtPlayer;
		target = null;
		angle = a;
		changeVelocity = true;
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
	public boolean changesVelocity() {
		return changeVelocity;
	}
	public boolean hasTarget() {
		return target != null;
	}
	public Coordinate getTargetCoordinate() {
		return target;
	}
	public double getAngle() {
		return angle;
	}
	public Action generateLoopedCopy() {
		return new Action(delay+loopDelay, changeVelocity, xVelocity, yVelocity, fire, aimAtPlayer, target, angle, true, loopDelay);
	}
}

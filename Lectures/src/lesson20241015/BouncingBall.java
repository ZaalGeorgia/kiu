package lesson20241015;

import std.StdDraw;

public class BouncingBall {
	public static void main(String[] args) {
		double rx = .480, ry = .860;
		double vx = .015, vy = .023;
		double radius = .05;
		StdDraw.setXscale(-1.0, +1.0);
		StdDraw.setYscale(-1.0, +1.0);
		while (true) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.filledSquare(0.0, 0.0, 1.0);
			if (Math.abs(rx + vx) + radius > 1.0)
				vx = -vx;
			if (Math.abs(ry + vy) + radius > 1.0)
				vy = -vy;
			rx += vx;
			ry = ry + vy;
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(rx, ry, radius);
			StdDraw.show(20);
		}
	}
}
package lesson20241015;

import std.StdAudio;
import std.StdDraw;

public class BouncingBallDeluxe {
	public static void main(String[] args) {
		double rx = .480, ry = .860;
		double vx = .015, vy = .023;
		double radius = .05;
		StdDraw.setXscale(-1.0, +1.0);
		StdDraw.setYscale(-1.0, +1.0);
		while (true) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.filledSquare(0.0, 0.0, 1.0);
			if (Math.abs(rx + vx) + radius > 1.0) {
				StdAudio.play("../data/pipebang.wav");
				vx = -vx;
			}
			if (Math.abs(ry + vy) + radius > 1.0) {
				StdAudio.play("../data/pipebang.wav");
				vy = -vy;
			}
			rx = rx + vx;
			ry = ry + vy;
			StdDraw.picture(rx, ry, "../data/TennisBall.png");
			StdDraw.show(20);
		}
	}
}
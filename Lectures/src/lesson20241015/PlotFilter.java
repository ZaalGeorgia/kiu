package lesson20241015;

import std.StdDraw;
import std.StdIn;

public class PlotFilter {
	public static void main(String[] args) {
		double xmin = StdIn.readDouble();
		double ymin = StdIn.readDouble();
		double xmax = StdIn.readDouble();
		double ymax = StdIn.readDouble();
		StdDraw.setXscale(xmin, xmax);
		StdDraw.setYscale(ymin, ymax);
		while (!StdIn.isEmpty()) {
			double x = StdIn.readDouble();
			double y = StdIn.readDouble();
			StdDraw.point(x, y);
		}
	}
}
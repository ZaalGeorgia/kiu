package columns;
import java.applet.*;
import java.awt.*;
import java.util.*;


class Figure {
	static int x=Columns.Width/2+1, y=1, c[]=new int[4];
	static Random r = new Random();

	Figure()
	{
		x = Columns.Width/2+1;
		y = 1;
		c[0] = 0;
		c[1] = (int)(Math.abs(r.nextInt())%7+1);
		c[2] = (int)(Math.abs(r.nextInt())%7+1);
		c[3] = (int)(Math.abs(r.nextInt())%7+1);
	}
}
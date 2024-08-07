package columns;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class View {
	
	final static public Color[] COLORS = new Color[] {Color.black,Color.cyan,Color.blue,Color.red,Color.green,
		    Color.yellow,Color.pink,Color.magenta,Color.white};
	
	static final int TopBorder=2;
	static final int LeftBorder=2;
	static final int BOX_SIZE=25;
	

	public Font font;
	public Graphics gr;
	
	void initView(Graphics gr) {
		this.gr = gr;
        gr.setColor(Color.black);
	}

	
	void drawField(int[][] field) {
	    int i,j;
	    for (i=1; i<=Model.Depth; i++) {
	        for (j=1; j<=Model.Width; j++) {
	            drawBox(j, i, field[j][i]);
	        }
	    }
	}

	void drawBox(int x, int y, int c) {
	    if (c==0) {
	        gr.setColor(Color.black);
	        gr.fillRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE, View.BOX_SIZE, View.BOX_SIZE);
	        gr.drawRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE, View.BOX_SIZE, View.BOX_SIZE);
	    }
	    else if (c==8) {
	        gr.setColor(Color.white);
	        gr.drawRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE+1, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE+1, View.BOX_SIZE-2, View.BOX_SIZE-2);
	        gr.drawRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE+2, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE+2, View.BOX_SIZE-4, View.BOX_SIZE-4);
	        gr.setColor(Color.black);
	        gr.fillRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE+3, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE+3, View.BOX_SIZE-6, View.BOX_SIZE-6);
	    }
	    else {
	        gr.setColor(COLORS[c]);
	        gr.fillRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE, View.BOX_SIZE, View.BOX_SIZE);
	        gr.setColor(Color.black);
	        gr.drawRect(View.LeftBorder+x*View.BOX_SIZE-View.BOX_SIZE, View.TopBorder+y*View.BOX_SIZE-View.BOX_SIZE, View.BOX_SIZE, View.BOX_SIZE);
	    }
	    //		g.setColor (Color.black);
	}

	void drawFigure(Figure f) {
		if (f == null)
			return;
		int[] c = f.getCells();
	    drawBox(f.x, f.y,c[0]);
	    drawBox(f.x, f.y+1,c[1]);
	    drawBox(f.x, f.y+2,c[2]);
	}

	void hideFigure(int x, int y) {
		drawBox(x, y, 0);
		drawBox(x, y+1, 0);
		drawBox(x, y+2, 0);
	}


	void showHelp(Graphics g) {
		g.setColor(Color.black);
	
		g.drawString(" Keys available:", 200 - View.LeftBorder, 102);
		g.drawString("Roll Box Up:     ", 200 - View.LeftBorder, 118);
		g.drawString("Roll Box Down:   ", 200 - View.LeftBorder, 128);
		g.drawString("Figure Left:     ", 200 - View.LeftBorder, 138);
		g.drawString("Figure Right:    ", 200 - View.LeftBorder, 148);
		g.drawString("Level High/Low: +/-", 200 - View.LeftBorder, 158);
		g.drawString("Drop Figure:   space", 200 - View.LeftBorder, 168);
		g.drawString("Pause:           P", 200 - View.LeftBorder, 180);
		g.drawString("Quit:     Esc or Q", 200 - View.LeftBorder, 190);
	}


	void showLevel(int level) {
		gr.setColor(Color.black);
		gr.clearRect(View.LeftBorder + 100, 390, 100, 20);
		gr.drawString("Level: " + level, View.LeftBorder + 100, 400);
	}


	void showScore(int score) {
		gr.setColor(Color.black);
		gr.clearRect(View.LeftBorder, 390, 100, 20);
		gr.drawString("Score: " + score, View.LeftBorder, 400);
	}


	void moveAndDrawFigure(Figure fig, int oldX, int oldY) {
		hideFigure(oldX, oldY);
		drawFigure(fig);
	}


	void highlightNeighbours(int a, int b, int c, int d, int i, int j) {
		drawBox(a, b, 8);
		drawBox(j, i, 8);
		drawBox(c, d, 8);
	}

}
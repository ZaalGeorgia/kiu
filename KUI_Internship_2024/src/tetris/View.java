package tetris;

public class View {
	
	static final int BOX_SIZE = 20;
	private Graphics graphics;

	public View(Graphics graphics) {
		this.graphics = graphics;
	}

	public void draw(TetrisModel model) {
		drawField(model);
		drawFigure(model);
	}

	private void drawFigure(TetrisModel model) {
		// TODO Auto-generated method stub
		
	}

	private void drawField(TetrisModel model) {
		var f = model.field;
		
		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f[r].length; c++) {
				drawBox(r,c,f[r][c]);
			}
		}
	}

	private void drawBox(int row, int col, int value) {
		graphics.drawBoxAt(col * BOX_SIZE, row * BOX_SIZE, value);
	}

}

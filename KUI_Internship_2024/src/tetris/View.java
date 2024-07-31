package tetris;

public class View {
	
	static final int BOX_SIZE = 30;
	static final int ORIGIN = 50;
	private Graphics graphics;

	public View(Graphics graphics) {
		this.graphics = graphics;
	}

	public void draw(TetrisModel model) {
		drawData(model.field, 0, 0, true);
		drawData(model.figure, model.position.y(), model.position.x(), false);
	}

	private void drawData(int[][] f, int row, int col, boolean drawBackground) {
		
		for (int r = 0; r < f.length; r++) {
			for (int c = 0; c < f[r].length; c++) {
				if (!drawBackground && f[r][c] == 0)
					continue;
				drawBox(r + row,c + col,f[r][c]);
			}
		}
	}

	private void drawBox(int row, int col, int value) {
		graphics.drawBoxAt(ORIGIN + col * BOX_SIZE, ORIGIN + row * BOX_SIZE, value);
	}

}

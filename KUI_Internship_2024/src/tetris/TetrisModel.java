package tetris;

public class TetrisModel implements GameEventsListener  {

	public static final int DEFAULT_HEIGHT = 20;
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_COLORS_NUMBER = 7;

	final private int width;
	final private int height;
	
	int[][] field;
	
	int maxColors;
	int[][] figure = FigureFactory.createNextFigure();
	public Pair position;

	public TetrisModel(int width, int height, int maxColors) {
		this.width = width;
		this.height = height;
		this.maxColors = maxColors;
		field = new int[height][width];
		position = new Pair(width/2-2, 0);
	}

	public Pair size() {
		return new Pair(width, height);
	}

	@Override
	public void slideDown() {
		position = new Pair(position.x(), position.y() + 1);
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void roate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub
		
	}

	public boolean isNewFiguresPositionValid(Pair newPosition) {
		
		for (int row = 0; row < figure.length; row++) {
			for (int col = 0; col < figure[row].length; col++) {
				if (figure[row][col] == 0)
					continue;
				int absCol = newPosition.x() + col;
				int absRow = newPosition.y() + row;
				if (absCol < 0 || absCol >= width)
					return false;
				if (absRow < 0 || absRow >= height)
					return false;
				if (field[absRow][absCol] != 0) 
					return false;
			}
		}
		
		return true;
	}


}

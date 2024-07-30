package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class TetrisModel implements GameEventsListener {

	public static final int DEFAULT_HEIGHT = 20;
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_COLORS_NUMBER = 7;

	final private int width;
	final private int height;

	int[][] field;

	int maxColors;
	int[][] figure;
	public Pair position;

	final List<ModelListener> listeners = new ArrayList<>();

	public void addListener(ModelListener listener) {
		listeners.add(listener);
	}

	public void removeListener(ModelListener listener) {
		listeners.remove(listener);
	}

	public TetrisModel(int width, int height, int maxColors) {
		this.width = width;
		this.height = height;
		this.maxColors = maxColors;
		field = new int[height][width];
		initFigure();
	}

	private void initFigure() {
		figure = FigureFactory.createNextFigure();
		position = new Pair(width / 2 - 2, 0);
	}

	public Pair size() {
		return new Pair(width, height);
	}

	@Override
	public void slideDown() {
		var newPosition = new Pair(position.x(), position.y() + 1);
		if (isNewFiguresPositionValid(newPosition)) {
			position = newPosition;
			notifyListeners();
		} else {
			pasteFigure();
			initFigure();
			notifyListeners();
			if (!isNewFiguresPositionValid(position)) {
				gameOver();
			}
		}
	}

	private void notifyListeners() {
		listeners.forEach(listener -> listener.onChange(this));
	}

	private void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		var newPosition = new Pair(position.x() - 1, position.y());
		if (isNewFiguresPositionValid(newPosition)) {
			position = newPosition;
			notifyListeners();
		}
	}

	@Override
	public void moveRight() {
		var newPosition = new Pair(position.x() + 1, position.y());
		if (isNewFiguresPositionValid(newPosition)) {
			position = newPosition;
			notifyListeners();
		}
	}

	@Override
	public void rotate() {
		int[][] f = new int[4][4];
		for (int r = 0; r < figure.length; r++) {
			for (int c = 0; c < figure[r].length; c++) {
				f[c][3 - r] = figure[r][c];
			}
		}
		figure = f;
		notifyListeners();
	}

	@Override
	public void drop() {
		// TODO Auto-generated method stub

		notifyListeners();
	}

	public boolean isNewFiguresPositionValid(Pair newPosition) {

		boolean[] result = new boolean[1];
		result[0] = true;

		walkThroughAllFigureCells(newPosition, (absPos, relPos) -> {
			if (result[0]) {
				result[0] = checkAbsPos(absPos);
			}
		});

		return result[0];
	}

	private void walkThroughAllFigureCells(Pair newPosition, BiConsumer<Pair, Pair> payload) {
		for (int row = 0; row < figure.length; row++) {
			for (int col = 0; col < figure[row].length; col++) {
				if (figure[row][col] == 0)
					continue;
				int absCol = newPosition.x() + col;
				int absRow = newPosition.y() + row;
				payload.accept(new Pair(absCol, absRow), new Pair(col, row));
			}
		}
	}

	private boolean checkAbsPos(Pair absPos) {
		var absCol = absPos.x();
		var absRow = absPos.y();
		if (absCol < 0 || absCol >= width)
			return false;
		if (absRow < 0 || absRow >= height)
			return false;
		if (field[absRow][absCol] != 0)
			return false;
		return true;
	}

	public void pasteFigure() {
		walkThroughAllFigureCells(position, (absPos, relPos) -> {
			field[absPos.y()][absPos.x()] = figure[relPos.y()][relPos.x()];
		});
	}

}

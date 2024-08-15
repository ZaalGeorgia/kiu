package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class TetrisModel implements GameEventsListener {

	public static final int DEFAULT_HEIGHT = 20;
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_COLORS_NUMBER = 7;

	int maxColors;
	public TetrisState state = new TetrisState();
	final List<ModelListener> listeners = new ArrayList<>();

	public void addListener(ModelListener listener) {
		listeners.add(listener);
	}

	public void removeListener(ModelListener listener) {
		listeners.remove(listener);
	}

	public TetrisModel() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLORS_NUMBER);
	}
	
	public TetrisModel(int width, int height, int maxColors) {
		this.state.width = width;
		this.state.height = height;
		this.maxColors = maxColors;
		state.field = new int[height][width];
		initFigure();
	}

	private void initFigure() {
		state.figure = FigureFactory.createNextFigure();
		state.position = new Pair(state.width / 2 - 2, 0);
	}

	public Pair size() {
		return new Pair(state.width, state.height);
	}

	@Override
	public void slideDown() {
		var newPosition = new Pair(state.position.x(), state.position.y() + 1);
		if (isNewFiguresPositionValid(newPosition)) {
			state.position = newPosition;
			notifyListeners();
		} else {
			pasteFigure();
			initFigure();
			notifyListeners();
			if (!isNewFiguresPositionValid(state.position)) {
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
		var newPosition = new Pair(state.position.x() - 1, state.position.y());
		if (isNewFiguresPositionValid(newPosition)) {
			state.position = newPosition;
			notifyListeners();
		}
	}

	@Override
	public void moveRight() {
		var newPosition = new Pair(state.position.x() + 1, state.position.y());
		if (isNewFiguresPositionValid(newPosition)) {
			state.position = newPosition;
			notifyListeners();
		}
	}

	@Override
	public void rotate() {
		int[][] f = new int[4][4];
		for (int r = 0; r < state.figure.length; r++) {
			for (int c = 0; c < state.figure[r].length; c++) {
				f[c][3 - r] = state.figure[r][c];
			}
		}
		state.figure = f;
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
		for (int row = 0; row < state.figure.length; row++) {
			for (int col = 0; col < state.figure[row].length; col++) {
				if (state.figure[row][col] == 0)
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
		if (isColumnPositionOutOfBoundaries(absCol))
			return false;
		if (isRowPositionOutOfBoundaries(absRow))
			return false;
		if (state.field[absRow][absCol] != 0)
			return false;
		return true;
	}

	private boolean isRowPositionOutOfBoundaries(int absRow) {
		return absRow < 0 || absRow >= state.height;
	}

	private boolean isColumnPositionOutOfBoundaries(int absCol) {
		return absCol < 0 || absCol >= state.width;
	}

	public void pasteFigure() {
		walkThroughAllFigureCells(state.position, (absPos, relPos) -> {
			state.field[absPos.y()][absPos.x()] = state.figure[relPos.y()][relPos.x()];
		});
	}

}

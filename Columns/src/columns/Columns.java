package columns;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

public class Columns extends Applet implements Runnable, ModelListener {

	static final int TimeShift = 250;
	static final int MinTimeShift = 200;

	int keyPressedCode;
	long lastTimeFigureMoved;
	boolean keyPressed = false;

	Model model = new Model();
	View view = new View();
	Thread thr = null;

	@Override
	public void init() {
		model.initModel();
		model.addListener(this);
		view.initView(getGraphics());
	}

	@Override
	public void start() {
		view.gr.setColor(Color.black);

		// setBackground (new Color(180,180,180));

		if (thr == null) {
			thr = new Thread(this);
			thr.start();
		}
	}

	@Override
	public void paint(Graphics g) {
		// ShowHelp(g);

		g.setColor(Color.black);

		view.showLevel(model.level);
		view.showScore(model.Score);
		view.drawField(model.newField);
		view.drawFigure(model.Fig);
		requestFocus();
	}

	@Override
	public void stop() {
		if (thr != null) {
			thr.stop();
			thr = null;
		}
	}

	
	@Override
	public void foundNeighboursAt(int a, int b, int c, int d, int i, int j) {
		view.drawBox(a, b, 8);
		view.drawBox(j, i, 8);
		view.drawBox(c, d, 8);
	}


	void Delay(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
		}
	}

	public boolean keyDown(Event e, int k) {
		keyPressed = true;
		keyPressedCode = e.key;
		return true;
	}

	public boolean lostFocus(Event e, Object w) {
		keyPressed = true;
		keyPressedCode = 'P';
		return true;
	}

	public void run() {
		model.initMatrixes();
		model.initMembers();
		requestFocus();

		do {
			lastTimeFigureMoved = System.currentTimeMillis();
			model.Fig = new Figure();
			view.drawFigure(model.Fig);
			while (true) {
				if (isItTimeToSlideDown()) {
					lastTimeFigureMoved = System.currentTimeMillis();
					view.hideFigure(model.Fig);
					if (!model.trySlideDown()) {
						break;
					}
					view.drawFigure(model.Fig);
				}
				model.DropScore = 0;
				do {
					processUserActions();
				} while (!isItTimeToSlideDown());
			}
			model.PasteFigure(model.Fig);
			do {
				model.removeSimilarNeighboringCells();
			} while (!model.noChanges);
		} while (!model.isFieldFull(this));
		gameOver();
	}

	private void gameOver() {
		// TODO Auto-generated method stub

	}

	private boolean isItTimeToSlideDown() {
		return (int) (System.currentTimeMillis() - lastTimeFigureMoved) > (Model.MaxLevel - model.level) * TimeShift
				+ MinTimeShift;
	}

	@Override
	public void fieldIsPacked(int[][] newField) {
		view.drawField(newField);
	}

	@Override
	public void scoreHasChanged(int score) {
		view.showScore(score);
	}

	@Override
	public void levelHasChanged(int level) {
		view.showLevel(level);
	}


	private void processUserActions() {
		Delay(50);
		if (keyPressed) {
			keyPressed = false;
			switch (keyPressedCode) {
			case Event.LEFT:
				if ((model.Fig.x > 1) && (model.newField[model.Fig.x - 1][model.Fig.y + 2] == 0)) {
					view.hideFigure(model.Fig);
					model.Fig.x--;
					view.drawFigure(model.Fig);
				}
				break;
			case Event.RIGHT:
				if ((model.Fig.x < Model.Width) && (model.newField[model.Fig.x + 1][model.Fig.y + 2] == 0)) {
					view.hideFigure(model.Fig);
					model.Fig.x++;
					view.drawFigure(model.Fig);
				}
				break;
			case Event.UP:
				model.Fig.rotateFigureCellsLeft();
				view.drawFigure(model.Fig);
				break;
			case Event.DOWN:
				model.Fig.rotateFigureCellsRight();
				view.drawFigure(model.Fig);
				break;
			case ' ':
				view.hideFigure(model.Fig);
				model.dropFigure(this, model.Fig);
				view.drawFigure(model.Fig);
				lastTimeFigureMoved = 0;
				break;
			case 'P':
			case 'p':
				while (!keyPressed) {
					view.hideFigure(model.Fig);
					Delay(500);
					view.drawFigure(model.Fig);
					Delay(500);
				}
				lastTimeFigureMoved = System.currentTimeMillis();
				break;
			case '-':
				if (model.level > 0)
					model.descreaseLevel();
				model.removedCellsCounter = 0;
				view.showLevel(model.level);
				break;
			case '+':
				if (model.level < Model.MaxLevel)
					model.increaseLevel();
				model.removedCellsCounter = 0;
				view.showLevel(model.level);
				break;
			}
		}
	}

}
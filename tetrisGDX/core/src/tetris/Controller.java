package tetris;

public class Controller implements ModelListener, GameEventsListener {
	
	private TetrisModel model;
	private View view;

	public Controller(TetrisModel model, View view) {
		this.model = model;
		model.addListener(this);
		this.view = view;
	}

	@Override
	public void onChange(TetrisModel model) {
		view.draw(model);
	}

	@Override
	public void slideDown() {
		model.slideDown();
	}

	@Override
	public void moveLeft() {
		model.moveLeft();
	}

	@Override
	public void moveRight() {
		model.moveRight();
	}

	@Override
	public void rotate() {
		model.rotate();
	}

	@Override
	public void drop() {
		model.drop();
	}

}

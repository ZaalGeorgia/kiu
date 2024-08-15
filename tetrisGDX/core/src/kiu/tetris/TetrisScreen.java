package kiu.tetris;

import com.badlogic.gdx.ScreenAdapter;

public class TetrisScreen extends ScreenAdapter {
	
	TetrisStage _stage;

	@Override
	public void show() {
		_stage = new TetrisStage();
		_stage.init();
	}

	@Override
	public void render(float delta) {
        _stage.act(delta);
        _stage.draw();
	}

	@Override
	public void resize(int width, int height) {
        _stage.getViewport().update(width, height, true);
	}
}

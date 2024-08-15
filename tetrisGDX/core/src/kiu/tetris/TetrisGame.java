package kiu.tetris;

import com.badlogic.gdx.Game;

public class TetrisGame extends Game {

	@Override
	public void create() {
		setScreen(new TetrisScreen());
	}


}

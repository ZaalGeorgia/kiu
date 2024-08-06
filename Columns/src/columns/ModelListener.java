package columns;

public interface ModelListener {

	void foundNeighboursAt(int i, int j, int k, int l, int i2, int j2);

	void fieldIsPacked(int[][] newField);

	void scoreHasChanged(int score);

	void levelHasChanged(int level);

}

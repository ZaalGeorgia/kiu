package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class Tetris {
	
	static final Color[] COLORS = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, 
			Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.YELLOW};
	
	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Tetris");
		
		JPanel panel  = new JPanel();
		panel.setPreferredSize(new Dimension(400, 700));
		
		frame.add(panel);
		
		frame.pack();
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		Graphics2D graphics = (Graphics2D) panel.getGraphics();
		
		TetrisModel model = new TetrisModel(TetrisModel.DEFAULT_WIDTH, TetrisModel.DEFAULT_HEIGHT, TetrisModel.DEFAULT_COLORS_NUMBER);
		
		View view = new View(new Graphics() {
			
			@Override
			public void drawBoxAt(int i, int j, int value) {
				graphics.setColor(COLORS[value]);
				graphics.fillRect(i, j, View.BOX_SIZE, View.BOX_SIZE);
			}
			
		});
		
		Controller controller = new Controller(model, view);
		
		
	}

}
package solitare;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Solitare {
	static DeckPile deckPile;
	static DiscardPile discardPile;
	static TablePile tableau[];
	static SuitPile suitPile[];
	static CardPile allPiles[];
	private static Graphics graphics;
	
	public static void main(String[] args) {
		initGame();
		initUI();
		
	}

	private static void initGame() {
		// first allocate the arrays
		allPiles = new CardPile[13];
		suitPile = new SuitPile[4];
		tableau = new TablePile[7];
		// then fill them in
		allPiles[0] = deckPile = new DeckPile(335, 5);
		allPiles[1] = discardPile = new DiscardPile(268, 5);
		for (int i = 0; i < 4; i++) {
			allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
		}
		for (int i = 0; i < 7; i++) {
			allPiles[6 + i] = tableau[i] = new TablePile(5 + 55 * i, 80, i + 1);
		}
	}

	private static void initUI() {
		JFrame frame = new JFrame("Solitare");
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(1000, 600));
		
		frame.add(panel);
		
		frame.pack();
		
		frame.setVisible(true);
		
		graphics = panel.getGraphics();
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				mouseDown(e.getX(), e.getY());
			}
		});
		
		
		repaint();
	}

	static public void repaint() {
		for (int i = 0; i < 13; i++) {
			allPiles[i].display(graphics);
		}
	}

	static public void mouseDown(int x, int y) {
		for (int i = 0; i < 13; i++) {
			if (allPiles[i].includes(x, y)) {
				allPiles[i].select(x, y);
				repaint();
			}
		}
	}
}

/*
<applet code="solitare.Solitare" width=700 height=500>
</applet>
*/

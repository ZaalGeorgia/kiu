package lesson20241001;

public class Deck {
	public static void main(String[] args) {
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] suit = { "♣", "♦", "♥", "♠" };
		String[] deck = new String[52];

		for (int s = 0; s < 4; s++) {
			for (int r = 0; r < 13; r++) {
//				deck[r + 13 * s] = rank[r] + suit[s];
				deck[4 * r + s] = rank[r] + suit[s];
			}
			for (int i = 0; i < 52; i++) {
				System.out.print(deck[i] + " ");
			}
			System.out.println();
		}

//		for (int s = 0; s < 4; s++) {
//			for (int r = 0; r < 13; r++) {
//				System.out.print(deck[r + 13 * s]);
//			}
//			System.out.println();
//		}

		System.out.println();

		int N = Integer.parseInt(args[0]);

		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random() * 52);
			System.out.print(deck[r]);
		}

		System.out.println();
		
		
		for (int i = 0; i < 10; i++) {
			int r = i + (int) (Math.random() * (52 - i));
			String t = deck[r];
			deck[r] = deck[i];
			deck[i] = t;
			System.out.print(deck[i]);
		}
		

	}
}
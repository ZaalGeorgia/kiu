package solitare;

class DeckPile extends CardPile {

	DeckPile(final int x, final int y) {
		// first initialize parent
		super(x, y);
		// then create the new deck
		// first put them into a local pile
		final CardPile pileOne = new CardPile(0, 0);
		final CardPile pileTwo = new CardPile(0, 0);
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 12; j++) {
				pileOne.push(new Card(i, j));
				count++;
			}
		}
		// then pull them out randomly
		for (; count > 0; count--) {
			final int limit = ((int) (Math.random() * 1000)) % count;
			// move down to a random location
			for (int i = 0; i < limit; i++) {
				pileTwo.push(pileOne.pop());
			}
			// then add the card found there
			push(pileOne.pop());
			// then put the decks back together
			while (!pileTwo.empty()) {
				pileOne.push(pileTwo.pop());
			}
		}
	}

	@Override
	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}
		Solitare.discardPile.push(this.pop());
	}
}
package poker;

public class Deck {

	private Card[] cards;
	
	// constructor
	public Deck() {
		int counter = 0;
		cards = new Card[52];
		for(int i = 0; i <= 3; i++) {
			for(int j = 1; j <= 13; j++) {
				Card c = new Card(j, i);
				cards[counter] = c;
				counter++;
			}
		}
	}
	
	// copy constructor
	public Deck(Deck other) {
		this.cards = other.cards;
	}

	// return the card in that position
	public Card getCardAt(int position) {
		return cards[position];
	}

	// return size of array
	public int getNumCards() {
		return cards.length;
	}

	// rearranges the deck
	public void shuffle() {
		Card[] shuffleTop;
		Card[] shuffleBot = new Card[cards.length / 2];
		Card[] shuffleFinal = new Card[cards.length];
		int counter = 0;
		// if cards is an odd length, give an extra card to the top half of the 
		// cut deck
		if (cards.length % 2 != 0) {
			shuffleTop = new Card[cards.length / 2 + 1];
			for (int i = 0; i < shuffleTop.length; i++) {
				shuffleTop[i] = cards[i];
			}
			
		// if deck is even length, split decks equally
		} else {
			shuffleTop = new Card[cards.length / 2];
			for (int i = 0; i < shuffleTop.length; i++) {
				shuffleTop[i] = cards[i];
			}
		}
		
		// set bottom half of deck
		for(int i = (cards.length %2 == 0) ? cards.length / 2 : 
			cards.length/2+1; i < cards.length; i++) {
			shuffleBot[counter] = cards[i];
			counter++;
		}
		
		// start shuffling
		counter = 0;
		for (int i = 0; i < shuffleTop.length; i++) {
			if (shuffleFinal.length % 2 == 0) {
				shuffleFinal[counter] = shuffleTop[i];
				shuffleFinal[counter+1] = shuffleBot[i];
			}
			if (shuffleFinal.length % 2 != 0) {
				if (i >= shuffleBot.length) {
					shuffleFinal[counter] = shuffleTop[i];
					break;
				} else {
					shuffleFinal[counter] = shuffleTop[i];
					shuffleFinal[counter + 1] = shuffleBot[i];
				}
			}
			counter = counter + 2;
		}
		cards = shuffleFinal;
	}

	// divides deck into two and switches their positions
	public void cut(int position) {
		Card[] cutDeck = new Card[cards.length];
		for (int i = 0; i < cards.length - position; i++) {
			cutDeck[i] = cards[position + i];
			for (int j = 0; j < position; j++) {
				cutDeck[cutDeck.length - position + j] = cards[j];
			}
		}
		cards = cutDeck;
	}

	// removes number number of cards from top of deck
	public Card[] deal(int numCards) {
		Card[] smaller = new Card[cards.length - numCards];
		Card[] dealt = new Card[numCards];
		for (int i = 0; i < cards.length - numCards; i++) {
			smaller[i] = cards[numCards + i];
			for (int j = 0; j < numCards; j++) {
				dealt[j] = cards[j];
			}
		}
		cards = smaller;
		return dealt;
	}
		
}

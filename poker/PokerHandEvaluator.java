package poker;

public class PokerHandEvaluator {

	public static boolean hasPair(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasTwoPair(Card[] cards) {
		Card temp = null;
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() > cards[j].getValue()) {
					temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
		int count = 0, save = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue() && 
						cards[j].getValue() != save) {
					count++;
					save = cards[j].getValue();
				}
			}
		}
		return (count == 2) ? true : false;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		int count;
		for (int i = 0; i < cards.length; i++) {
			count = 1;
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue() && 
						cards[i].getSuit() != cards[j].getSuit()) {
					count++;
				}
				if (count >= 3) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasStraight(Card[] cards) {
		boolean hasStraight = true;
		Card temp = null;

		if (PokerHandEvaluator.hasPair(cards) == false) {
			// rearranges cards to be in numerical order
			for (int i = 0; i < cards.length; i++) {
				for (int j = i + 1; j < cards.length; j++) {
					if (cards[i].getValue() > cards[j].getValue()) {
						temp = cards[i];
						cards[i] = cards[j];
						cards[j] = temp;
					}
				}
			}
			// checks if cards are face cards
			if (cards[0].getValue() == 1 && cards[4].getValue() == 13) {
				for (int i = 1; i < cards.length - 1; i++) {
					int j = i + 1;
					if (cards[j].getValue() != cards[i].getValue() + 1) {
						hasStraight = false;
					}
				}
			} else {
				// checks normally
				for (int i = 0; i < cards.length - 1; i++) {
					int j = i + 1;
					if (cards[j].getValue() != cards[i].getValue() + 1) {
						hasStraight = false;
					}
				}
			}
		} else {
			return false;
		}
		return hasStraight;
	}

	public static boolean hasFlush(Card[] cards) {
		int count = 0;
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].getSuit() == cards[i + 1].getSuit()) {
				count++;
			}
		}
		return (count >= 4) ? true : false;
	}

	public static boolean hasFullHouse(Card[] cards) {
		if (hasThreeOfAKind(cards) && hasTwoPair(cards)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		int count;
		for (int i = 0; i < cards.length; i++) {
			count = 1;
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					count++;
				}
				if (count >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			return true;
		} else {
			return false;
		}
	}
}

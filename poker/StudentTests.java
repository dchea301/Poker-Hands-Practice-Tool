package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	@Test
	public void testPair() {
		Card[] deck = new Card[2];
		for (int i = 0; i <= 1; i++) {
			deck[i] = new Card(2,i+1);
		}
	//	for(int i = 0; i < deck.length; i++) {
	//		System.out.println(deck[i].getValue());
	//}
		assertTrue(PokerHandEvaluator.hasPair(deck) == true);
	}
	
	@Test
	public void testTwoPair() {
		Card[] deck = new Card[4];
		Card[] error = new Card[4];
		int count = 0;
		for (int i = 0; i <= 1; i++) {
			deck[i] = new Card(2,i+1);
		}
		for (int j = 2; j < 4; j++) {
			deck[j] = new Card(3,count++);
		}
		count = 0;
		for (int q = 0; q < 4; q++) {
			error[q] = new Card(4, count++);
		}
		assertTrue(PokerHandEvaluator.hasTwoPair(deck) == true);
		assertFalse(PokerHandEvaluator.hasTwoPair(error) == true);
	}
	
	@Test
	public void testThreeOfAKind() {
		Card[] deck = new Card[3];
		Card[] error = new Card[3];
		for (int i = 0; i < 3; i++) {
			deck[i] = new Card(3,i+1);
		}
		for (int j = 0; j < 3; j++) {
			error[j] = new Card(j+1,j);
		}
		//for (int q = 0; q < error.length; q++) {
		//	System.out.println(error[q].getValue());
		//}
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(deck) == true);
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(error) == true);
	}
	@Test
	public void testhasStraight() {
		Card[] deck = new Card[5];
		for (int i = 1; i <= 4; i++) {
			deck[i] = new Card(i+9,1);
		}
		deck[0] = new Card(1, 1);
//		for(int i = 0; i < deck.length; i++) {
//			System.out.println(deck[i].getValue());
//		}
		assertTrue(PokerHandEvaluator.hasStraight(deck) == true);
	}
	
	@Test
	public void testFourOfAKind() {
		int count = 0;
		Card[] deck = new Card[4];
		for (int i = 0; i < 4; i++) {
			deck[i] = new Card(13,count);
			count++;
		}
		assertTrue(PokerHandEvaluator.hasFourOfAKind(deck) == true);
	}
	
	@Test
	public void testFullHouse() {
		Card[] deck = new Card[5];
		Card[] error = new Card[5];
		int count = 0; 
		for (int i = 0; i < 3; i++) {
			deck[i] = new Card(12,i+1);
			error[i] = new Card(10,i+1);
		}
		for (int d = 3; d < 5; d++) {
			deck[d] = new Card(11,count+1);
			error[d] = new Card(d, count+1);
			count++;
		}
		//for (int q = 0; q < deck.length; q++) {
		//	System.out.println(deck[q].getSuit());
		//}
		assertTrue(PokerHandEvaluator.hasFullHouse(deck) == true);
		assertFalse(PokerHandEvaluator.hasFullHouse(error) == true);
	}
	
	@Test
	public void testFlush() {
		Card[] deck = new Card[5];
		for (int i = 0; i < 5; i++) {
			deck[i] = new Card(i+3, 3);
		}
		assertTrue(PokerHandEvaluator.hasFlush(deck) == true);
	}
	
	@Test
	public void testStraightFlush() {
		Card[] deck = new Card[5];
		for (int i = 0; i < 5; i++) {
			deck[i] = new Card(i+4,2);
		}
		assertTrue(PokerHandEvaluator.hasStraightFlush(deck) == true);
	}
}
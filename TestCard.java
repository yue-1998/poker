import org.junit.jupiter.api.Test;

public class TestCard {

	@Test
	public void TestCase1() {
		Card card = new Card();
		String black[] = {"2H","3D","5S","9C","KD"};
		String white[] = {"2C","3H","4S","8C","AH"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "White wins");
	}
	
	@Test
	public void TestCase2() {
		Card card = new Card();
		String black[] = {"2H","4S","4C","2D","4H"};
		String white[] = {"2S","8S","AS","QS","3S"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "White wins");
	}
	
	@Test
	public void TestCase3() {
		Card card = new Card();
		String black[] = {"2H","3H","5H","9H","KH"};
		String white[] = {"2C","3H","4S","5C","6H"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "Black wins");
	}
	
	@Test
	public void TestCase4() {
		Card card = new Card();
		String black[] = {"2H","3D","5S","9C","KD"};
		String white[] = {"2D","3H","5C","9S","KH"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "Tie");
	}
	
	@Test
	public void TestCase5() {
		Card card = new Card();
		String black[] = {"6H","7H","8H","9H","10H"};
		String white[] = {"6D","7D","8D","9D","10D"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "Tie");
	}
}

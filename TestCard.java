import org.junit.jupiter.api.Test;

public class TestCard {

	@Test
	public void TestCase1() {
		Card card = new Card();
		// 散牌 vs 散牌
//		String black[] = {"2H","3D","5S","9C","KD"};
		String black[] = {"2H","6H","6H","7H","7H"};
		String white[] = {"2C","3H","4S","8C","AH"};
		String expectedResult = card.GetValue(black,white);
		System.out.println(expectedResult == "White wins");
	}
}

import java.util.ArrayList;
import java.util.HashMap;
public class Rand {

	public static void main(String[] args) {
		HashMap<Integer> map = new HashMap<Integer>();
		ArrayList<Boolean> deck = new ArrayList<Boolean>();
		for (int i = 0; i < 4; i++) {
			deck.add(true);
		}
		for (int i = 4; i < 52; i++) {
			deck.add(false);
		}
		

	}

}

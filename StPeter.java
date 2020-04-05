import java.util.Random;
public class StPeter {

	public static void main(String[] args) {
		Random rand = new Random();
		long biggest = 0, curr = 2, rolls = 0;
		while (true) {
			while (rand.nextInt(2) != 0) {
				curr *= 2;
			}
			rolls++;
			if (curr > biggest) {
				biggest = curr;
				System.out.println(curr + " " + rolls);
			}
			curr = 2;
			
		}
	}
}
import java.util.Random;
public class Prob {

	public static void main(String[] args) {
		Random rng = new Random();
		double x = 1000;
		double vol = rng.nextFloat();
		System.out.println(vol);
		double curr = 1;
		while (curr > vol) {
			x -= 0.001;
			curr -= Math.exp(-x) * 0.001;
		}
		System.out.println(x);
		
	}

}

public class Fizzbuzz {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int x = br.getInt(), y = br.getInt(), n = br.getInt();
		boolean done;
		for (int i=1; i < n+1; i++) {
			done = true;
			if (i%x == 0) {
				br.print("Fizz");
				done = false;
			}
			if (i%y == 0) {
				br.print("Buzz");
				done = false;
			}
			if (done) {br.print(i);}
			br.print("\n");
		}
		br.close();

	}

}

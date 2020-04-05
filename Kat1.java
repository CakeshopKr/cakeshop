import java.lang.Math;
public class Kat1 {

	public static void main(String[] args) {
		int a = 999999999;
		int b;
		System.out.println("start");
		while (true) {
			b = a/2 - 100000;
			while (a % b != 0) {
				b--;
				}
			
			if (b == 1) {System.out.println(a);}
			a++;
		}
	}

}



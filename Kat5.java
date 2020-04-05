import java.util.Stack;
public class Kat5 {
	public static void proc(int A, int start, int end) {
		if (start < end) {
			int mid1 = (start*2 + end) / 3;
			int mid2 = (start + end*2) /3;
			
			proc(A, start, mid1);
			proc(A, mid1 + 1, mid2);
			proc(A, mid2 + 1, end);
			
			for (int i=start; i<end; i++)
				A++;
		}
	}
	public static void main(String[] args) {
		
		int A = 0;
		
		proc(A, 0, 20);
		for (int i=0; i<5; i++)
			System.out.println("done");
		System.out.println("really done");
				

	}

}

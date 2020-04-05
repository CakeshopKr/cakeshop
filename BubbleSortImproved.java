// Improved Bubble Sort algorithm
public class BubbleSortImproved {

	public static void bubbleSort2(int[] a) {
		for (int i = 1; i < a.length; i++) {
			boolean isSorted = true;
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					isSorted = false;
				}
			}
			if (isSorted) return;
		}
	}
}


public class apaxaa {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		String word = br.getWord();
		int len = word.length();
		char old = ' ', next;
		for (int i = 0; i < len; i++) {
			next = word.charAt(i);
			if (Character.compare(next, old) != 0) {
				br.print(next);
			}
			old = word.charAt(i);
			
		}
		br.close();

	}

}

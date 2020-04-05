import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.ArrayList;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

public class Conform {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int thing = br.getInt();
		ArrayList<String> curr;
		for (int i = 0; i < thing; i++) {
			curr = new ArrayList<String>();
			for (int j = 0; j < 5; j++) {
				curr.add(br.getWord());
			}
			Collections.sort(curr);
			String subtotal = "";
			for (int j = 0; j < 5; j++) {
				subtotal += curr.get(j);
			}
			
			if (map.containsKey(subtotal)) {
				map.put(subtotal, map.get(subtotal) + 1);
			}
			else {map.put(subtotal, 1);}
		}
		
		int max = 1;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		
		int ans = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				ans += max;
			}
		}
			
		br.print(ans);
		br.close();
	}

}
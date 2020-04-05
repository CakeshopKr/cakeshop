import java.util.StringTokenizer;
import java.lang.Object;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

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

public class Classy2 {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int cases = br.getInt();
		String[] thing = new String[5];
		
		for (int c = 0; c < cases; c++) {
			int n = br.getInt();
			for (int k = 0; k < n; k++) {
				thing[k] = br.getWord();
			}
			//for (int k = 0; k < 5; k++) {
				//br.print(thing[k] + '\n');;
			//}
			String x = "hihi:";
			br.print(x[]);
		}
		
		br.close();

	}

}

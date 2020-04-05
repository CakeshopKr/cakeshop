import java.util.StringTokenizer;

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
public class WeakVertices {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
        boolean in = false, left = false;
        int n = br.getInt();
		int[][] matrix = new int[n][n];
		boolean[] list = new boolean[n];
		
		while (n != -1) {
			if (n==1) {br.println("0"); n = br.getInt(); continue;}
			if (n==2) {br.println("0 1"); n = br.getInt(); continue;}
			matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = br.getInt();					
				}
			}
			list = new boolean[n];
		
			for (int i = 0; i < n; i++) {
				if (list[i]) continue;
				in = false;
				left = true;
				for (int j = 0; j < n; j++) {
					if (in || !left) break;
					if (matrix[i][j] == 1) {
						for (int k = j+1; k < n; k++) {
							if (matrix[i][k] == 1) {
								left = true;
								if (matrix[j][k] == 1) {
									in = true;
									list[i] = true;
									list[j] = true;
									list[k] = true;
									break;
								}
							}
						}
					}
				}				
				if (!in) br.print(i + " ");
			}
			br.println();
			n = br.getInt();
		}
		br.close();
	}
}
/*
4
1 2 3 4
2 3 4 1
3 2 4 4
3 3 3 3
-1

9
0 1 1 1 0 0 0 0 0
1 0 0 0 0 0 1 0 0
1 0 0 1 0 1 0 0 0
1 0 1 0 0 1 1 0 0
0 0 0 0 0 0 1 1 0
0 0 1 1 0 0 0 0 0
0 1 0 1 1 0 0 1 0
0 0 0 0 1 0 1 0 1
0 0 0 0 0 0 0 1 0
-1
ans: 1 8
*/
//Liu Tianyi
//A0199682H

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
public class Island {
	
	static void dfs(int r, int c, char[][] map, boolean[][] visited, int row, int col) {
		if (visited[r][c] || map[r][c] == 'W') return;
		visited[r][c] = true;
		if (r > 0) dfs(r-1, c, map, visited, row, col);
		if (r < row) dfs(r+1, c, map, visited, row, col);
		if (c > 0) dfs(r, c-1, map, visited, row, col);
		if (c < col) dfs(r, c+1, map, visited, row, col);
	}

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int row = br.getInt(), col = br.getInt();
		char[][] map = new char[row][col];
		boolean[][] visited = new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			String word = br.getWord();
			for (int j = 0; j < col; j++) {
				map[i][j] = word.charAt(j);
			}
		}
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && map[i][j] == 'L') {
					ans++;
					dfs(i, j, map, visited, row-1, col-1);
				}
			}
		}
		br.print(ans);
		br.close();

	}

}
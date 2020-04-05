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

class element {
	char value;
	boolean visited;
	int rank;
	element parent;
	
	element(char in){
		this.value = in;
		this.visited = false;
		this.parent = this;
		this.rank = 0;
	}
	
	element findset() {
		if (this.parent == this) return this;
		else {
			this.parent = parent.findset();
			return this.parent;
		}
	}
	
	boolean issameset(element other) {
		return this.findset() == other.findset();
	}
	
	void unionset(element other) {
		if (!this.issameset(other)) {
			element x = this.findset(), y = other.findset();
			if (x.rank > y.rank) y.parent = x;
			else {
				x.parent = y;
				if (x.rank == y.rank) y.rank++;
			}
		}
	}
	
}

public class BinaryTravel {

	static void dfs(int r, int c, int prevr, int prevc, element[][] map, char chara) {
		if (map[r][c].visited || map[r][c].value != chara) return;
		map[r][c].visited = true;
		map[r][c].unionset(map[prevr][prevc]);
		
		dfs(r-1, c, r, c, map, chara);
		dfs(r+1, c, r, c, map, chara);
		dfs(r, c-1, r, c, map, chara);
		dfs(r, c+1, r, c, map, chara);
	}

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int row = br.getInt(), col = br.getInt();
		element[][] map = new element[row+2][col+2];
		
		for (int i = 0; i < col+2; i++) {
			map[0][i] = new element('W');
		}
		for (int i = 1; i < row+1; i++) {
			String word = br.getWord();
			map[i][0] = new element('W');
			for (int j = 0; j < col; j++) {
				map[i][j+1] = new element(word.charAt(j));
			}
			map[i][col+1] = new element('W');
		}
		for (int i = 0; i < col+2; i++) {
			map[row+1][i] = new element('W');
		}
		
		for (int i = 1; i < row+1; i++) {
			for (int j = 1; j < col+1; j++) {
			dfs(i, j, i, j, map, map[i][j].value);
			}
		}
		
		int n = br.getInt();
		for (int i = 0; i < n; i++) {
			int a = br.getInt(), b = br.getInt();
			if (map[a][b].issameset(map[br.getInt()][br.getInt()])) {
				if (map[a][b].value == '0') br.println("binary");
				else br.println("decimal");
				
			}
			else br.println("neither");
		}
		br.close();

	}

}
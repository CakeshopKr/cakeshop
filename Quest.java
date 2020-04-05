import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
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

class info {
	int energy, gold;
	info(int a, int b) {
		this.energy = a;
		this.gold = b;
	}
}

class questcomparer implements Comparator<info> {
	public int compare(info a, info b) {
		if (a.energy < b.energy || (a.energy == b.energy && a.gold < b.gold)) {return -1;}
		else if (a.energy == b.energy && a.gold == b.gold) {return 0;} 
		else {return 1;}
	}
}

public class Quest {
	
	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int total = br.getInt();
		String word;
		TreeMap<info, Integer> questboard = new TreeMap<info, Integer>(new questcomparer());
		
		for (int i = 0; i < total; i++) {
			word = br.getWord();
			
			if (word.equals("add")) {
				int ener = br.getInt(), gold = br.getInt();
				info dummy = new info(ener, gold);
				if (questboard.containsKey(dummy)) {
					//int a = questboard.get(dummy);
					//questboard.put(dummy, a + 1);
					questboard.put(dummy, questboard.get(dummy) + 1);
				}
				else {questboard.put(dummy, 1);}
			}
			
			else {
				int query = br.getInt();
				info dummy, curr;
				long G = 0;
				while (query > 0) {
					dummy = new info(query, 100001);
					curr = questboard.lowerKey(dummy);
					if (curr == null) {break;}
					query -= curr.energy;
					G += curr.gold;
					if (questboard.get(curr) == 1) {questboard.remove(curr);}
					else {questboard.put(curr, questboard.get(curr) - 1);}
						
				}
				br.println(G);
			}
		}
		
		br.close();

	}

}
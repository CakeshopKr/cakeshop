package mainpackage;

//Liu Tianyi
//A0199682H

import java.util.Collections;
import java.util.LinkedList;

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

class Edge implements Comparable<Edge> {
	int a, b, weight;
	
	Edge(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.weight = c;
	}
	
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
}

class UFDS {
	int[] p;
	int[] rank;
	
	UFDS(int n) {
		this.p = new int[n];
		this.rank = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
			rank[i] = 0;
		}
	}
	
	int findset(int a) {
		if (p[a] == a) return a;
		else {
			p[a] = findset(p[a]);
			return p[a];
		}
	}
	
	boolean issameset(int a, int b) {
		return findset(a) == findset(b);
	}
	
	void unionset(int a, int b) {
		if (rank[p[a]] > rank[p[b]]) p[p[b]] = p[a];
		else {
			p[p[a]] = p[b];
			if (rank[p[a]] == rank[p[b]]) rank[p[b]]++;
		}
		
	}
}

public class Template {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int n = br.getInt();
		LinkedList<Edge> list = new LinkedList<Edge>();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				int w = br.getInt();
				if (i < j) {
					list.add(new Edge(i, j, w));
				}
			}
		}
		Collections.sort(list);
		UFDS set = new UFDS(n+1);
		int counter = 0;
		while (counter < n-1) {
			Edge nextedge = list.poll();
			if (!set.issameset(nextedge.a, nextedge.b)) {
				set.unionset(nextedge.a, nextedge.b);
				br.println(nextedge.a + " " + nextedge.b);
				counter++;
			}
		}
		
		br.close();

	}

}

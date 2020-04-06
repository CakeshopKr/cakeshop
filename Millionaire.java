//Liu Tianyi
//A0199682H
//6 Apr 20

import java.util.PriorityQueue;

class Vertex {
	int value, row, col, best;
	boolean confirmed;
	
	Vertex(int a, int b, int c) {
		this.value = a;
		this.row= b;
		this.col = c;
		this.confirmed = false;
		this.best = 1000000001;
	}
}

class Pair implements Comparable<Pair> {
	Vertex v;
	int d;
	
	Pair(Vertex v, int d) {
		this.v = v;
		this.d = d;
	}
	
	public int compareTo(Pair other) {
		return this.d - other.d;
	}
}

public class Millionaire {
	public static final int INF = 1000000001;
	
	static void relax(Pair curr, Vertex next) {
		if (next.value - curr.v.value < next.best) next.best = next.value - curr.v.value;
		if (curr.d > next.best) next.best = curr.d;
	}

	public static void main(String[] args) {
		
		Kattio br = new Kattio(System.in);
		int row = br.getInt(), col = br.getInt();
		Vertex[][] map = new Vertex[row][col];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = new Vertex(br.getInt(), i, j);
				q.add(new Pair(map[i][j], INF));
			}
		}
		map[0][0].best = 0;
		q.add(new Pair(map[0][0], 0));
		while (!q.isEmpty()) {
			Pair curr = q.remove();
			if (curr.v.confirmed) continue;
			curr.v.confirmed = true;
			if (curr.v == map[row-1][col-1]) {
				br.print(curr.d);
				break;
			}

			Vertex next;
			if (curr.v.row > 0) {
				next = map[curr.v.row-1][curr.v.col];
				if (!next.confirmed) {
					int prev = next.best;
					relax(curr, next);
					if (prev != next.best) q.add(new Pair(next, next.best));
				}
			}
			
			if (curr.v.row < row-1) {
				next = map[curr.v.row+1][curr.v.col];
				if (!next.confirmed) {
					int prev = next.best;
					relax(curr, next);
					if (prev != next.best) q.add(new Pair(next, next.best));
				}
			}
			
			if (curr.v.col > 0) {
				next = map[curr.v.row][curr.v.col-1];
				if (!next.confirmed) {
					int prev = next.best;
					relax(curr, next);
					if (prev != next.best) q.add(new Pair(next, next.best));
				}
			}
			
			if (curr.v.col < col-1) {
				next = map[curr.v.row][curr.v.col+1];
				if (!next.confirmed) {
					int prev = next.best;
					relax(curr, next);
					if (prev != next.best) q.add(new Pair(next, next.best));
				}
			}
	
		}
		
		br.close();

	}

}

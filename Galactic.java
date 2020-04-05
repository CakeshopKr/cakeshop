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

class Node {
	Node left, right, parent;
	int index, score, penalty, height, size;
	
	Node(int ind, int a, int b) {
		this.score = a;
		this.penalty = b;
		this.index = ind;
	}
	
	String info() {
		return Integer.toString(this.index) + ", " + Integer.toString(this.score) + ", " + Integer.toString(this.penalty);
	}
	
}

class BinaryTree {
	Node root;
	Node[] list;
	
	BinaryTree(int n) {
		this.list = new Node[n + 1];
		for (int i = 1; i < n + 1; i++) {
			list[i] = new Node(i, 0, 0);
		}
	}
	
	int max(int a, int b) {
		a = (a > b) ? a : b;
		return a;
	}
	
	int height(Node team) {
		//System.out.println("height");

		if (team == null) {return -1;}
		else {
			int a = (team.left == null) ? -1 : team.left.height;
			int b = (team.right == null) ? -1 : team.right.height;
			return max(a, b) + 1;
		}
	}
	
	int size(Node team) {
		//System.out.println("size");

		if (team == null) {return 0;}
		else {
			int a = (team.left == null) ? 0 : team.left.size;	
			int b = (team.right == null) ? 0 : team.right.size;
			return 1 + a + b;
		}
	}
	
	Boolean comparer(Node teama, Node teamb) {
		if (teama.score == teamb.score && teama.penalty == teamb.penalty) {
			return teama.index < teamb.index;
		}
		return teama.score > teamb.score || (teama.score == teamb.score && teama.penalty < teamb.penalty);
	}
	
	//t.right must be != null
	void rotateleft(Node t) {
		Node w = t.right;
		w.parent = t.parent;
		t.parent = w;
		t.right = w.left;
		if (w.left != null) w.left.parent = t;
		w.left = t;
		if (w.parent != null) {
			if (w.parent.right == t) {w.parent.right = w;}
			else {w.parent.left = w;}
		}
		if (t == this.root) {this.root = w;}
		t.height = height(t);
		w.height = height(w);
	}
	
	//t.left must be != null
	void rotateright(Node t) {
		Node w = t.left;
		w.parent = t.parent;
		t.parent = w;
		t.left = w.right;
		if (w.right != null) w.right.parent = t;
		w.right = t;
		if (w.parent != null) {
			if (w.parent.right == t) {w.parent.right = w;}
			else {w.parent.left = w;}
		}
		if (t == this.root) {this.root = w;} 
		t.height = height(t);
		w.height = height(w);
	}
	
	int bf(Node t) {
		int a = (t.left == null) ? -1 : t.left.height;	
		int b = (t.right == null) ? -1 : t.right.height;		
		return a - b;
	}
	
	void insert(Node team) {
		team.parent = null;
		team.left = null;
		team.right = null;
		team.height = 0;
		team.size = 1;
		if (this.root == null) {
			this.root = team;
		}
		else {
			//traverses down where the node should go
			Node curr = this.root, prev = curr;
			while (curr != null) {
				prev = curr;
				curr = (comparer(curr, team)) ? curr.left : curr.right;
			}
			team.parent = prev;
			if (comparer(prev, team)) {prev.left = team;}
			else {prev.right = team;}
			
			//updates the lineage for height
			fixavl(prev);
		}
	}
	
	void fixavl(Node prev) {
		while (prev != null) {
			prev.height = height(prev);
			prev.size = size(prev);
			if (bf(prev) == 2) {
				if (bf(prev.left) == -1) {rotateleft(prev.left);}
				rotateright(prev);
				prev = prev.parent;
				
			}
			else if (bf(prev) == -2) {
				if (bf(prev.right) == 1) {rotateright(prev.right);}
				rotateleft(prev);
				prev = prev.parent;
			}
			prev = prev.parent;
		}
	}
	
	Node lowest(Node from) {
		Node low = from;
		if (low == null) {return null;}
		else {
			while (low.left != null) {low = low.left;}
			return low;
		}
	}
	
	void remove(Node team) {
		if (team.left == null && team.right == null) {
			if (this.root == team) {this.root = null;}
			else {
				if (team.parent.right == team) {team.parent.right = null;}
				else {team.parent.left = null;}
				fixavl(team.parent);
			}
		}
		
		else if (team.left != null && team.right != null) {
			Node child = team.right;
			while (child.left != null) {child = child.left;}
			this.list[team.index] = child;
			this.list[child.index] = team; 
			int tindex = team.index, tscore = team.score, tpenalty = team.penalty;
			team.index = child.index;
			team.score = child.score;
			team.penalty = child.penalty;
			child.index = tindex;
			child.score = tscore;
			child.penalty = tpenalty;
			
			remove(child);
		}
		
		else {
			if (team == this.root) {
				if (team.left != null) {
					this.root = team.left;
					team.left.parent = null;
					team.left = null;
				}
				else {
					this.root = team.right;
					team.right.parent = null;
					team.right = null;
				}
				fixavl(this.root);
			}
			else {
				Node temp = (team.left != null) ? team.left : team.right;
				if (team.parent.right != null) {
					if (team.parent.right.index == team.index) {
						team.parent.right = temp;
						temp.parent = team.parent;
						}	
					}
				else{
					team.parent.left = temp;
					temp.parent = team.parent;
					}
				fixavl(team.parent);
			}
		}	
	}
	
	Node successor(Node curr) {
		Node temp = curr;
		if (curr.right != null) {return lowest(curr.right);}
		while (temp.parent != null) {
			if (temp.parent.left == temp) {return temp.parent;}
			temp = temp.parent;
		}
		return null;
	}

}
public class Galactic {

	public static void main(String[] args) {
		Kattio br = new Kattio(System.in);
		int nn = br.getInt(), n = br.getInt();
		BinaryTree tree = new BinaryTree(nn);
		boolean[] intree = new boolean[nn+1];
		int rank = 1;
			
		for (int i = 0; i < n; i++) {
			int newteam = br.getInt(), newpenal = br.getInt();
			if (intree[newteam]) {tree.remove(tree.list[newteam]);}
			tree.list[newteam].score++;
			tree.list[newteam].penalty += newpenal;
			
			if (newteam == 1) {
				Node low = tree.lowest(tree.root);
				while(low != null && tree.comparer(tree.list[1], low)) {
					rank--;
					intree[low.index] = false;
					Node temp = tree.successor(low);
					tree.remove(low);
					low = temp;
				}
			}
			
			else if (newteam != 1 && tree.comparer(tree.list[newteam], tree.list[1])) {
				if (!intree[newteam]) {rank++;}
				intree[newteam] = true;
				tree.insert(tree.list[newteam]);
			}
			
		br.println(rank);
			
		}
				
		br.close();

	}

}
/*
3 4
2 7
3 5
1 6
1 9

CREATES BUG
2 1
5 2
9 4
7 2
9 4
9 1
7 4

5 1
10 2
3 0
10 1
7 0
10 2
7 1
*/
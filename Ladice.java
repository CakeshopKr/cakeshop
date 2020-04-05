import java.io.BufferedOutputStream;
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 

class UnionFind {
	int[] p;
	int[] rank;
	int[] end;
	
	//1 based indexing!!!!
	UnionFind(int n) {
		p = new int[n+1];
		rank = new int[n+1];
		end = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			p[i] = i;
			rank[i] = 0;
			end[i] = i;
		}
	}
	
	int findset (int i) {
		if (p[i] == i) {return i;}
		else {
			p[i] = findset(p[i]);
			return p[i];
		}
	}
	
	boolean issameset(int i, int j) {
		return findset(i) == findset(j);
	}
	
	//adding left to right, right end preserved
	void unionset (int i, int j) {
		if (!issameset(i, j)) {
			int x = findset(i), y = findset(j);
			end[x] = end[y];
			if (rank[x] > rank[y]) p[y] = x;
			else {
				p[x] = y;
				if (rank[x] == rank[y]) rank[y] += 1;
			}
		}
	}
	
}

public class Ladice {
	
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 

	public static void main(String[] args) throws IOException {
		Reader br = new Reader();
		int n1 = br.nextInt(), n2 = br.nextInt();
		boolean[] occupied = new boolean[n2 + 1];
		UnionFind u = new UnionFind(n2);
		BufferedOutputStream out = new BufferedOutputStream(System.out);
		byte[] token = "LADICA\n".getBytes(), token2 = "SMECE\n".getBytes();
		

		for (int i = 0; i < n1; i++) {
			int a = br.nextInt(), b = br.nextInt();
			
			if (!occupied[a]) {
				occupied[a] = true;
				u.unionset(a, b);
				out.write(token);
			}
			
			else if (!occupied[b]) {
				occupied[b] = true;
				u.unionset(b, a);
				out.write(token);
			}
			
			else if (!occupied[u.end[u.findset(a)]]) {
				occupied[u.end[u.findset(a)]] = true;
				u.unionset(a, b);
				out.write(token);
			}
			
			else if (!occupied[u.end[u.findset(b)]]) {
				occupied[u.end[u.findset(b)]] = true;
				u.unionset(b, a);
				out.write(token);
			}
			
			else {out.write(token2);}
		}
		
		br.close();
		out.close();

	}

}
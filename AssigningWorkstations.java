import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

import java.util.PriorityQueue;
import java.util.Comparator;

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

class Student {
    int starttime, duration;
    
    public Student(int a, int b) {
        this.starttime = a;
        this.duration = b;
    }
}

class StudentComparator implements Comparator<Student>{
    public int compare(Student p1, Student p2) {
        if (p1.starttime > p2.starttime) {
            return 1;
        }
        else {return -1;}
    }
}

public class AssigningWorkstations{
    
    

    public static void main(String[] args) {
        Kattio br = new Kattio(System.in);
        int n = br.getInt(), m = br.getInt(), saves = 0;
        PriorityQueue<Integer> coms = new PriorityQueue<Integer>(n);
        PriorityQueue<Student> studs = new PriorityQueue<Student>(n, new StudentComparator());
        PriorityQueue<Integer> inuse = new PriorityQueue<Integer>(n);

        
        for (int i = 0; i < n; i++) {
            studs.add(new Student(br.getInt(), br.getInt()));
        }
        
        Student nextstudent;
        Integer nextcom;
        for (int i = 0; i < n; i++) {
            nextstudent = studs.poll();
            
            while (true) {
                nextcom = inuse.peek();
                if(nextcom == null) {break;}
                if(nextcom <= nextstudent.starttime) {
                    coms.add(inuse.poll());
                }
                else {break;}
            }
        
            while (true) {
                nextcom = coms.poll();
                if (nextcom == null) {
                    inuse.add(nextstudent.starttime + nextstudent.duration);
                    break;
                }

                if (nextcom + m >= nextstudent.starttime) {
                    inuse.add(nextstudent.starttime + nextstudent.duration);
                    saves++;
                    break;
                }
            }           
        }
        
        
        br.print(saves);
        br.close();

    }

}

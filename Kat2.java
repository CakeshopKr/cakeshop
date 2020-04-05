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
import java.util.HashMap;

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

public class Kat2 {
    public static void main(String[] args) {
        Kattio br = new Kattio(System.in);
        int bign = br.getInt();
        String command, n;
        HashMap<Integer, String> front = new HashMap<Integer, String>();
        HashMap<Integer, String> back = new HashMap<Integer, String>();
        int ffront = -1;
        int bfront = 1;
        int fback = -1;
        int bback = 1;
        int sfront = 1;
        int sback = 1;
        Boolean equal = true;
        int counter = 1;

        //first 2 entries
        br.getWord();
        String first = br.getWord();
        front.put(0, first);

        for (int i = 0; i < bign - 1; i++) {
            command = br.getWord();
            if (command.equals("get")) {
                br.println(first);
                br.getInt();
                counter++;
                continue;
            }
            else if (command.equals("push_front")) {
                front.clear();
                front.put(0, br.getWord());
                back.put(0, first);
            }

            else {
                back.put(0, br.getWord());
            }
            break;

        }

        //rest of the entries
        bign -= counter + 1;

        for (int i = 0; i < bign; i++) {
            command = br.getWord();
            n = br.getWord();

            if (command.equals("push_back")) {
                back.put(bback, n);
                bback++;
                sback++;

                if (equal) {
                    fback++;
                    front.put(bfront, back.get(fback));
                    back.remove(fback);
                    sback--;
                    sfront++;
                    bfront++;
                }
                equal = !equal;
            }

            else if (command.equals("push_front")) {
                front.put(ffront, n);
                ffront--;
                sfront++;

                if (!equal) {
                    bfront--;
                    back.put(fback, front.get(bfront));
                    front.remove(bfront);
                    sfront--;
                    sback++;
                    fback--;
                }
                equal = !equal;
                
            }

            else if (command.equals("push_middle")) {
                if (equal) {
                    front.put(bfront, n);
                    bfront++;
                    sfront++;
                }
                else {
                    back.put(fback, n);
                    fback--;
                    sback++;
                }
                equal = !equal;
                
            }

            else {
                int k = Integer.parseInt(n);
                if (k <= bfront - ffront - 2) {
                    br.println(front.get(ffront + 1 + k));
                }

                else{
                    br.println(back.get(fback + 2 + k - bfront + ffront));
                }

                
            }
        }

        br.close();

    }
}

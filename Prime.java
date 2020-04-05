public class Prime {

  public static void main(String[] args) {
    long curr = 1000000000;
    boolean no = true;
    while (true) {
      no = false;
      for (int i = 2; i < curr; i++) {
        if (curr % i == 0) {no = true; break;}
      }
      if (!no) {System.out.println(curr);}
      curr++;
    }  
  }
}
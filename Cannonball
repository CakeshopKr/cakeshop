//Liu Tianyi
//A0199682H

import java.lang.Math;

public class Cannonball {
    
    public static double dist(double[] a, double[] b) {
        return Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
    }
    
    public static double runtime(double[] a, double[] b) {
        return dist(a,b)/5;
    }
    
    public static double inf = 1000000000;

    public static void main(String[] args) {
        Kattio br = new Kattio(System.in);
        double[] a = new double[2], b = new double[2];
        a[0] = br.getDouble();
        a[1] = br.getDouble();
        b[0] = br.getDouble();
        b[1] = br.getDouble();
        int n = br.getInt();
        double[][] cannons = new double[n+2][2];
        cannons[0] = a;
        cannons[1] = b;
        for (int i=2; i<n+2; i++) {
            cannons[i][0] = br.getDouble();
            cannons[i][1] = br.getDouble();
        }
        
        double[][] matrix = new double[n+2][n+2];
        for (int i=0; i<n+2; i++) {
            for (int j=0; j<n+2; j++) {
                if (i == 0) {
                    matrix[i][j] = dist(cannons[i], cannons[j]) / 5;
                }
                else if (i == 1 || j == 0){
                    matrix[i][j] = 0;
                }
                else {
                    double dis = dist(cannons[i], cannons[j]);
                    matrix[i][j] = Math.min(Math.abs(dis - 50) / 5 + 2, dis / 5);
                }

            }
        }
        
        for (int k=0; k<n+2; k++)
            for (int i=0; i<n+2; i++)
                for (int j=0; j<n+2; j++)
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
        
        br.print(matrix[0][1]);
        br.close();

    }

}

package implementation;
/**
 * 10818
 * 최소, 최대
 * Java
 */

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
         
        int min = 1000000;
        int max = -1000000;
        int input;
        for(int i=0;i<n;i++) {
            input = scan.nextInt();
            if(input > max) max = input;
            if(min > input) min = input;
        }

        System.out.println(min + " " + max);

        scan.close();
    }
}

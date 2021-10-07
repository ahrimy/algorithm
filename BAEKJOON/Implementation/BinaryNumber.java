/**
 * 3460
 * 이진수
 * Java
 */

import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for(int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int index = 0;
            while(n > 0) {
                if(n % 2 == 1) System.out.print(index + " ");
                n /= 2;
                index++;
            }
            System.out.println();
        }
        scan.close();
    }    
}

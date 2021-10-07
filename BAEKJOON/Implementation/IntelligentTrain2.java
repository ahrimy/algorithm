/**
 * 2460
 * 지능형 기차2
 * Java
 */

import java.util.Scanner;

public class IntelligentTrain2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int max = 0;
        int total = 0;
        for(int i=0;i<10;i++) {
            total -= scan.nextInt();
            total += scan.nextInt();
            if(total > max) max = total;
        }
        System.out.println(max);
        scan.close();
    }
}

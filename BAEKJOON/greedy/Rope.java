package greedy;
/**
 * 2217
 * 로프
 * Java
 */

import java.util.Arrays;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ropes = new int[n];
        for(int i=0;i<n;i++) {
            ropes[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(ropes);

        int count = 1;
        long value = ropes[n-count];
        long max = value;
        while(count < n) {
            count++;
            value = ropes[n-count] * count;
            if(value > max) max = value;
        }
        System.out.println(max);
        
    }
}

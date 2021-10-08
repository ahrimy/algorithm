package sort;
/**
 * 2693
 * N번째 큰 수
 * Java
 */

import java.util.Arrays;
import java.util.Scanner;

public class NthBiggestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr;
        int index = 7;
        for(int i = 0; i < n; i++) {
            arr = new int[10];
            for(int j=0;j<10;j++) {
                arr[j] = scan.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[index]);
        }
        scan.close();
    }
}

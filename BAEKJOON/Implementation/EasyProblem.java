/**
 * 1292
 * 쉽게 푸는 문제
 * Java
 */

import java.util.Scanner;

public class EasyProblem {
    public static void main(String[] args) {
        int[] sum = new int[10001];
        sum[1] = 1;
        int num = 2;
        for(int i=2;i<1000;i = i+(num++)) {
            for(int j=0;j<num;j++) {
                sum[i + j] = num + sum [i + j -1];
            }
        }

        Scanner scan = new Scanner(System.in);
        int total = sum[scan.nextInt()-1];
        total = sum[scan.nextInt()] - total;

        System.out.println(total);
        scan.close();
    }
}

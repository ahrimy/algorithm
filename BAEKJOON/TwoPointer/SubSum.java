package TwoPointer;
/**
 * 1806
 * 부분합
 * Java
 */

import java.util.Scanner;

public class SubSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        
        int min = 100001;
        int left = 0;
        int right = 0;
        int total = 0;
        while(true) {
            if(total >= s) {
                if(right-left < min) min = right - left;
                total -= arr[left++];
            }else if(right == n) {
                break;
            }else {
                total += arr[right++];
            }
        }

        if(min == 100001) System.out.println(0);
        else System.out.println(min);

    }
}

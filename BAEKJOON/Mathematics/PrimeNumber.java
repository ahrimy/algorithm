
/**
 * 2581
 * 소수
 * Java
 */

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();

        int count = 0;
        int total = 0;
        int min = 10000;
        for(int i=start;i<=end;i++) {
            if(isPrimeNumber(i)) {
                count++;
                total += i;
                if(min > i) min = i;
            }
        }
        if(count == 0) System.out.println(-1);
        else {
            System.out.println(total);
            System.out.println(min);
        }
        scan.close();
    }

    public static boolean isPrimeNumber(int n) {
        boolean isPrime = true;
        if(n == 1) return false;
        for(int i=2;i*i<=n;i++) {
            if(n%i==0) {
                isPrime = false;
                break;    
            }
        }   
        return isPrime;
    }
}

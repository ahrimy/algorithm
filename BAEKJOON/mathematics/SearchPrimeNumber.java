package mathematics;
/**
 * 1978
 * 소수 찾기
 * Java
 */

import java.util.Scanner;

public class SearchPrimeNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        
        int count = 0;
        for(int i=0;i<n;i++) {
            if(isPrimeNumber(scan.nextInt())) count++;
        }
        System.out.println(count);
        scan.close();
    }
    public static boolean isPrimeNumber(int n) {
        boolean isPrime = true;
        if(n == 1) return false;
        for(int i=2;i*i<=n;i++) {
            if(n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }   
}

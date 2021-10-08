package bruteforce;
/**
 * 2501
 * 약수 구하기
 * Java
 */

import java.util.Scanner;

public class GetDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;
        int i = 0;
        while(i <= n && count < k) {
            if(n % ++i  == 0) count++;
        }

        scanner.close();
        if(count != k) i = 0;
        System.out.println(i);
    }
}

package implementation;
/**
 * 10870
 * 피보나치 수 5
 * Java
 */

import java.util.Scanner;

public class Fibonacci5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int answer = fibonacci(n);
        System.out.println(answer);
        scan.close();
    }

    public static int fibonacci(int n) {
        if(n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

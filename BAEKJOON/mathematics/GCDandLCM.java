package mathematics;
/**
 * 2609
 * 최대공약수와 최소공배수
 * Java
 */


import java.util.Scanner;

public class GCDandLCM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();

        int gcd = gcd(a, b);
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b, gcd));
    }
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;	// 나머지를 구해준다.
            
            // GCD(a, b) = GCD(b, r)이므로 변환한다.
            a = b;		
            b = r;
        }
        return a;
        /*
        if(b == 0) return a;
        // GCD(a, b) = GCD(b, r)이므로 (r = a % b)
        return gcd(b, a % b);
        */
    }
    public static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}

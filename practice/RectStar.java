/**
 * 연습문제
 * 직사각형 별찍기
 * Java
 */

import java.util.Scanner;
import java.lang.StringBuffer;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuffer row = new StringBuffer();
        for(int i=0;i<a;i++){
            row.append("*");
        }
        for(int i=0;i<b;i++){
            System.out.println(row);
        }
    }
}

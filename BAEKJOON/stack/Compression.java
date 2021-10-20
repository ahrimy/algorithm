package stack;
/**
 * 1662
 * 압축
 * Java
 */

import java.util.Scanner;
import java.util.Stack;

public class Compression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        scan.close();
        Stack<Integer> lenStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();  
        int length = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(') {
                lenStack.add(length-1);
                length = 0;
                countStack.add(Integer.parseInt(str.substring(i-1, i)));
            } else if(str.charAt(i) == ')') {
                int prevLen = lenStack.pop();
                int count =  countStack.pop();
                length = length * count + prevLen;
            } else {
                length++;
            }
        }
        System.out.println(length);
    }
}

package bruteforce;
/**
 * 14888
 * 연산자 끼워넣기
 * Java
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InsertOperator {
    public static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] numbers = new int[n];
        for(int i=0;i<n;i++) {
            numbers[i] = scan.nextInt();
        }

        int count;
        String[] operators = {"+", "-", "*", "/"};
        List<String> operatorList = new ArrayList<>();
        for(int i=0;i<4;i++) {
            count = scan.nextInt();
            for(int j=0;j<count;j++) {
                operatorList.add(operators[i]);
            }
        }
        dfs(numbers, operatorList, new boolean[operatorList.size()],numbers[0], 0, operatorList.size(), n-1);

        Collections.sort(results);
        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));
        scan.close();
    }
    public static void dfs(int[] numbers, List<String> operatorList, boolean[] visited, int total, int depth, int n, int r) {
        if(depth == r) {
            results.add(total);
            return;
        }

        for(int i=0;i<n;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, operatorList, visited, calculate(operatorList.get(i), total, numbers[depth+1]), depth+1, n, r);
            visited[i] = false;
        }
    }
    public static int calculate(String operator, int a, int b) {
        int result = 0;
        switch(operator) {
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            case "/":
                result = a/b;
        }
        return result;
    }
}
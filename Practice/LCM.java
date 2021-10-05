/**
 * 연습문제
 * N개의 최소공배수
 * Java
 */

public class LCM {
    public int solution(int[] arr) {
        int answer = 1;
        int[][] divisors = new int[arr.length][101];
        int divisor;
        for(int i=0;i<arr.length;i++) {
            divisor = 2;
            while(arr[i] > 1) {
                if(arr[i] % divisor == 0) {
                    divisors[i][divisor]++;
                    arr[i] /= divisor;
                }else {
                    divisor++;
                }
            }
        }
        int max;
        for(int i=2;i<101;i++) {
            max = 0;
            for(int j=0;j<arr.length;j++) {
                if(divisors[j][i] > max) max = divisors[j][i];
            }
            answer *= Math.pow(i, max);
        }
        return answer;
    }
}

/**
 * 연습문제
 * 소수 찾기
 * Java
 */

public class PrimeNumber {
    public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;i++){
            if(isPrimeNumber(i)) answer++;
        }
        return answer;
    }
    
    public boolean isPrimeNumber(int n){
        boolean isPrime = true;
        
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
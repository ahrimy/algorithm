/**
 * 연습문제
 * 두 정수 사이의 합
 * Java
 */

class SumOfNums {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b){
            return (long)a;
        }
        if(a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i=a;i<=b;i++){
            answer += i;
        }
        return answer;
    }
}
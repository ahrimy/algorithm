/*
 * Weekly Challenge
 * 1주차 부족한 금액 계산하기
 * Java
 */

public class Week1 {
    public long solution(int price, int money, int count) {
        
        long totalPrice = 0;
        for(int i=1;i<=count;i++){
            totalPrice += price * i;
        }

        long answer = 0;
        if(totalPrice > money) answer = totalPrice - money;
        return answer;
    }
}
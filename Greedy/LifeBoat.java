/*
 * 탐욕법(Greedy)
 * 구명 보트 
 * Java
 */

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int last = people.length - 1;
        int first = 0;
        int sum;
        while(first <= last) {
            sum = people[last];
            while(sum + people[first] <= limit && first < last) {
                sum += people[first++];
            }
            last--;
            answer++;
        }
        return answer;
    }
}

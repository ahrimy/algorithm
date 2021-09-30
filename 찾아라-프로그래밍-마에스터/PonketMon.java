/**
 * 찾아라 프로그래밍 마에스터
 * 폰켓몬
 * Java
 */

import java.util.HashSet;

public class PonketMon {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        return Math.min(set.size(), nums.length/2);
    }
}

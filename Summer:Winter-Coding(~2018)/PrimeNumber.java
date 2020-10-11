package summer_winter_coding2018;
/*
 * Summer/Winter Coding(~2018)
 * 소수 만들기
 * Java
 */
import java.util.HashSet;
import java.util.Set;

public class PrimeNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		int nums[] = { 1, 2, 3, 4 };
		s.solution(nums);
	}
}

class Solution {
	public int solution(int[] nums) {
		int answer = -1;

		Set<int[]> list = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {

					if (check(nums[i], nums[j], nums[k])) {
						System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
						int[] temp = { nums[i], nums[j], nums[k] };
						list.add(temp);
						System.out.println(list.size());
					}
				}
			}
		}
		answer = list.size();

		return answer;
	}

	public boolean check(int num1, int num2, int num3) {
		int sum = num1 + num2 + num3;
		boolean check = true;
		for (int i = 2; i < sum; i++) {
			if (sum % i == 0) {
				check = false;
				break;
			}
		}
		return check;
	}
}

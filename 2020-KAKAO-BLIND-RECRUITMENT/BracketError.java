/*
 * 2020 KAKAO BLIND RECRUITMENT
 * 괄호 변환
 * Java
 */
public class BracketError {
	public static void main(String[] args) {
		Solution s = new Solution();
		String p = "))((()";

		String answer = s.solution(p);
		System.out.println(answer);
	}
}

class Solution {
	public String solution(String p) {
		String answer = "";

		answer = split(p).toString();
		System.out.println(answer);
		return answer;
	}

	public StringBuilder split(String p) {

		int open = 0;
		int close = 0;
		StringBuilder u = new StringBuilder("");
		StringBuilder v = new StringBuilder("");
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				open++;
			} else {
				close++;
			}
			if (open == close) {
				u.append(p.substring(0, i + 1));
				v.append(p.substring(i + 1));
				break;
			}
		}
		if (v.length() > 0) {
			v = split(v.toString());
		}
		StringBuilder s = new StringBuilder("");
		if (isCorrect(u.toString())) {
			s.append(u);
			s.append(v);
		} else {
			s.append("("+v+")");
			s.append(correction(u.substring(1,u.length()-1)));
			
		}
		return s;

	}

	public boolean isCorrect(String u) {
		int cnt = 0;
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				cnt++;
			} else {
				cnt--;
			}
			if (cnt < 0) {
				return false;
			}
		}
		return true;
	}

	public StringBuilder correction(String u) {
		StringBuilder temp = new StringBuilder("");
		for (int i = 0; i < u.length(); i++) {
			if (u.charAt(i) == '(') {
				temp.append(")");
			} else {
				temp.append("(");
			}
		}

		return temp;
	}
}
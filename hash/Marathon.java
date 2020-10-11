package hash;

/*
 * 해시
 * 완주하지 못한 선수
 * Java
 * */
import java.util.HashMap;

public class Marathon {

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> checks = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			if (checks.get(participant[i]) == null) {
				checks.put(participant[i], 1);
			} else {
				int num = checks.get(participant[i]);
				checks.put(participant[i], num + 1);
			}
		}
		for (int i = 0; i < completion.length; i++) {
			int num = checks.get(completion[i]);
			checks.put(completion[i], num - 1);
		}
		for (String key : checks.keySet()) {
			int num = checks.get(key);
			if (num != 0) {
				answer = key;
			}
		}
		return answer;
	}

}

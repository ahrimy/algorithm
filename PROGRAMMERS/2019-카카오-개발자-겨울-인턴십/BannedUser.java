/*
 * 2019 카카오 개발자 겨울 인턴십
 * 불량 사용자
 * Java
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BannedUser {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] user_id = { "frodo", "frida", "arodo", "crodo", "cfodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "fr*d*", "*rodo", "c*o*o", "******", "******" };
		s.solution(user_id, banned_id);
	}
}

class Solution {
	public static Set<Set <String>> list = new HashSet<Set<String>>();

	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		bfs(new HashSet<String>(), user_id, banned_id);
		answer = Solution.list.size();
		System.out.println(answer);
		return answer;
	}

	public void bfs(Set<String> current_set,String[] user_id,String[] banned_id) {
		Iterator <String> iterator = current_set.iterator();
		if (current_set.size() == banned_id.length) {
			if(!list.contains(current_set)){
				list.add(new HashSet<>(current_set));
			}
			while(iterator.hasNext()){
				System.out.print(iterator.next()+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<user_id.length;i++){
			int j= 0;
			if(current_set.size()>banned_id.length){
				break;
			}
			if(user_id[i].length()!=banned_id[current_set.size()].length()){
				continue;
			}
			if(current_set.contains(user_id[i])){
				continue;
			}
			for(j=0;j<user_id[i].length();j++){
				if(banned_id[current_set.size()].charAt(j)=='*'){
					continue;
				}
				if(banned_id[current_set.size()].charAt(j)!=user_id[i].charAt(j)){
					break;
				}
			}
			if(j==user_id[i].length()){
				current_set.add(user_id[i]);
				bfs(current_set,user_id,banned_id);
				current_set.remove(user_id[i]);
			}
		}
		
	}
}

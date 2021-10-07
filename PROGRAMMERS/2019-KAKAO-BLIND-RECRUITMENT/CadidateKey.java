/*
 * 2019 KAKAO BLIND RECRUITMENT
 * 후보키
 * Java
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class CadidateKey {

	ArrayList<HashSet<Integer>> candidateKey;
	
	public int solution(String[][] relation){
		candidateKey = new ArrayList<>();
		int max = relation[0].length;
		
		for(int i = 1 ; i <= max ; i++) {
			makeKeySet(0, max - 1, 0, i, new HashSet<>(), relation);
		}
		
		return candidateKey.size();
	}

    // attr: 현재 선택된 column
    // maxAttr: 가장 큰 column
    // idx: 현재 선택된 column 개수
    // size: 선택하려는 column 개수
    // keySet: 확인중인 key set
    // relation
	private void makeKeySet(int attr, int maxAttr, int idx, int size, HashSet<Integer> keySet, String[][] relation) {
		if(idx == size) {
            
            // key 의 최소성 확인
			for(HashSet<Integer> key : candidateKey) {
				if(keySet.containsAll(key)) {
					return;
				}
			}
			
            // key 가 유일성을 만족하는지 확인
			if(isUnique(keySet, relation)) {
				candidateKey.add(keySet);
			} 
            
			return;
		}
		
		for(int i = attr ; i <= maxAttr ; ++i) {
            // i 번째 열 key 로 추가
			HashSet<Integer> newKeySet = new HashSet<>(keySet);
			newKeySet.add(i);
			makeKeySet(i, maxAttr, idx + 1, size, newKeySet, relation);
		}
	}

	private boolean isUnique(HashSet<Integer> keySet, String[][] relation) {
		HashMap<String, String> map = new HashMap<>();
		
		for(int row = 0 ; row < relation.length ; row++) {
			String key = "";
			
			for(int column : keySet) {
                // key set 의 column 으로 만들어진 key
				key += relation[row][column];
			}
			
			if(map.containsKey(key)) return false;
			else map.put(key, key);
		}	
		return true;
	}
}
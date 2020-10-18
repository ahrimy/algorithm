/**
 * 해시
 * 전화번호 목록
 * Java
 */

import java.util.HashSet;
import java.util.Iterator;


class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		HashSet<String> list = new HashSet<>();
		for (int i = 0; i < phone_book.length; i++) {
			list.add(phone_book[i]);
		}
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String prefix=it.next();
			int length = prefix.length();
			for (int i = 0; i < phone_book.length; i++) {
				if (!phone_book[i].equals(prefix)&&(phone_book[i].length()>length)) {
					String temp = phone_book[i].substring(0, length);
					if (temp.equals(prefix)) {
						return false;
					}
				}
			}
		}

		return answer;
	}
}
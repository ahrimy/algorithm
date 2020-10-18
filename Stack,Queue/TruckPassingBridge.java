/**
 * 스택 / 큐
 * 다리를 지나는 트럭
 * Java
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.Queue;
class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> trucks = new LinkedList<Integer>();
		for (int i = 0; i < truck_weights.length; i++) {
			trucks.offer(truck_weights[i]);
		}
		Queue<Integer> onBridge = new LinkedList<Integer>();
		ArrayList<Integer> time = new ArrayList<Integer>();
		int truckCnt = truck_weights.length;
		while (truckCnt > 0) {
			for (int i = 0; i < time.size(); i++) {
				if (time.get(i) == bridge_length) {
					onBridge.poll();
					time.remove(i);
					truckCnt--;
					break;
				}
			}
			int total = 0;
			Iterator<Integer> it = onBridge.iterator();
			while (it.hasNext()) {
				int temp = it.next();
				total += temp;

			}
			if (!trucks.isEmpty()) {
				if (total + trucks.peek() <= weight) {
					int temp = trucks.poll();
					onBridge.offer(temp);
					time.add(0);
				}
			}
			for (int i = 0; i < time.size(); i++) {
				int temp = time.get(i);
				time.set(i, temp + 1);
			}

			answer++;

		}

		return answer;
	}
}
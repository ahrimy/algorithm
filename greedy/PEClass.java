package greedy;

/*
 * Å½¿å¹ý(Greedy)
 * Ã¼À°º¹
 * Java
 */
public class PEClass {
	public static void main(String[] args) {
		PEClass p = new PEClass();
		int n = 15;
		int[] lost = { 2, 3, 4, 7, 9, 11 ,13,14};
		int[] reserve = { 1, 3, 5, 10,12,14 };

		p.solution(n, lost, reserve);
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int lostStudent = lost.length;
		int extraStudent = reserve.length;
		
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < extraStudent; j++) {
				if (lost[i] == reserve[j]) {
					reserve = remove(j, reserve);
					lost = remove(i,lost);
					i--;
					break;
				}
			}
			extraStudent = reserve.length;
		}
		lostStudent = lost.length;
		
		
		int[] temp = new int[lostStudent];
		for (int i = 0; i < lostStudent; i++) {
			for (int j = 0; j < extraStudent; j++) {
				if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
					temp[i]++;
				}
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				for (int j = 0; j < extraStudent; j++) {
					if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
						reserve = remove(j, reserve);
						extraStudent = reserve.length;
						temp[i]--;
						lostStudent--;
						break;
					}
				}
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 2) {
				for (int j = 0; j < extraStudent; j++) {
					if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
						reserve = remove(j, reserve);
						extraStudent = reserve.length;
						temp[i]--;
						lostStudent--;
						break;
					}
				}
			}
		}

		answer = n - lostStudent;
		return answer;
	}

	public int[] remove(int index, int[] arr) {
		int[] temp = new int[arr.length - 1];
		for (int i = 0; i < index; i++) {
			temp[i] = arr[i];
		}
		for (int i = index; i < temp.length; i++) {
			temp[i] = arr[i + 1];
		}
		arr = temp;
		return arr;
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}
}

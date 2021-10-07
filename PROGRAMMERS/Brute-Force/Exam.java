/*
 * 완전탐색
 * 모의고사
 * Java
 */
public class Exam {
	   public int[] solution(int[] answers) {
	        int[] answer = {};

	        int score[] = new int[3];

	        int[] pattern1 = {1,2,3,4,5};
	        int[] pattern2 = {2,1,2,3,2,4,2,5};
	        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5,};

	        int cnt1 = 0;
	        int cnt2 = 0;
	        int cnt3 = 0;
	        for(int i=0;i<answers.length;i++,cnt1++,cnt2++,cnt3++){
	            if(i%pattern1.length==0){
	                cnt1=0;
	            }
	            if(i%pattern2.length==0){
	                cnt2=0;
	            }
	            if(i%pattern3.length==0){
	                cnt3=0;
	            }
	            if(pattern1[cnt1]==answers[i]){
	                score[0]++;
	            }
	            if(pattern2[cnt2]==answers[i]){
	                score[1]++;
	            }
	            if(pattern3[cnt3]==answers[i]){
	                score[2]++;
	            }
	        }
	        int maxScore = 0;
	        for(int i=0;i<3;i++){
	            if(maxScore<score[i]){
	                maxScore = score[i];
	            }
	        }
	        int cnt = 0;
	        for(int i=0;i<3;i++){
	            if(score[i]==maxScore){
	                int[] temp = new int[cnt+1];
	                for(int j=0;j<cnt;j++){
	                    temp[j] = answer[j];
	                }
	                temp[cnt++] = i+1;
	                answer = temp;
	            }
	        }
	        return answer;
	    }
}

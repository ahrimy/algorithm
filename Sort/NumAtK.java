/*
 * 정렬
 * K번째수
 * Java
 */
public class NumAtK {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};  
		solution(array,commands);
	}
	public static int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        for(int i=0;i<commands.length;i++){
	        	int[] temp = new int[commands[i][1]-commands[i][0]+1];
	        	for(int j=commands[i][0]-1;j<commands[i][1];j++){
	        		temp[j-commands[i][0]+1] = array[j];
	        	}
	        	sort(temp);
	        	answer[i] = temp[commands[i][2]-1];
	        }
	    	for(int i=0;i<answer.length;i++){
	    		System.out.print(answer[i]+" ");
	    	}
	    	System.out.println();
	        return answer;
	    }
	    
	    public static void sort(int[] array){
	    	for(int i=0;i<array.length;i++){
	    		for(int j=0;j<array.length-i-1;j++){
	    			if(array[j]>array[j+1]){
	    				int temp = array[j];
	    				array[j] = array[j+1];
	    				array[j+1] = temp;
	    			}
	    		}
	    	}
	    	for(int i=0;i<array.length;i++){
	    		System.out.print(array[i]+" ");
	    	}
	    	System.out.println();
	    }
}

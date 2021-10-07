class Solution {
    public static int count;
    public static String[] words;
    public static String target;
    public static String begin;
    public int solution(String begin, String target, String[] words) {
        boolean isConvertable = false;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                isConvertable = true;
                break;
            }
        }
        if(!isConvertable){
            return 0;
        }
        boolean[] visited = new boolean[words.length];
        for(int i=0;i<visited.length;i++){
            visited[i] = false;
        }
        Solution.words = words;
        Solution.begin = begin;
        Solution.target = target;
        Solution.count = words.length;
        
        this.dfs(-1, 0, visited);

        int answer = Solution.count;
        return answer;
    }

    public void dfs(int index, int count, boolean[] visited){
        String word;
        if(index > -1){
            visited[index] = true;
            word = words[index];   
            if(word.equals(target)){
               if(Solution.count > count){
                Solution.count = count;
               }
                visited[index] = false;
                return;
            }
        }else{
            word = begin;
        }
        
        for(int i=0;i<words.length;i++){
            if(visited[i]){
                continue;
            }
            if(compare(word, words[i])){
                dfs(i, count+1, visited);
            }
        }
        if(index > -1){
            visited[index] = false;
        }
    }
    public boolean compare(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
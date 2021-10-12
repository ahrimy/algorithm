package bruteforce;
/**
 * 1062
 * 가르침
 * Java
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Teaching {

    public static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] words = new String[n];
        
        if(k < 5) {
            System.out.println(0);
            return;
        } else if(k == 26) { 
            System.out.println(n);
            return;
        }

        for(int i=0;i<n;i++) {
            String str = br.readLine();
            words[i] = str.substring(4, str.length()-4);
        }

        boolean[] visited = new boolean[26];
        visited['a' - 97] = true;
        visited['c' - 97] = true;
        visited['i' - 97] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;

        combination(words, visited, 0, 0, 26,  k - 5);
        System.out.println(max);
    }

    public static void combination(String[] words, boolean[] visited, int count, int start, int n, int r) {
        if(count == r) {
            int total = 0;
            for(String word : words) {
                boolean readable = true;
                for(int j=0;j<word.length();j++) {
                    if(!visited[word.charAt(j) - 97]) {
                        readable = false;
                        break;
                    };
                }
                if(readable) total++;
            }
            if(total > max) max = total;
            return ;
        }

        for(int i=start;i<n;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            combination(words, visited, count+1, i+1, n, r);
            visited[i] = false;
        }
        return ;
    }
}

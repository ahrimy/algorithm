import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        ArrayList<Integer> value = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if(v <= k){
                value.add(v);
            }
        }
        int answer = 0;
        for(int i = value.size()-1; i >= 0; i--){
            answer += k/value.get(i);
            k = k%value.get(i);
        }

        bw.write(answer + "\n");
        bw.close();
    }
}
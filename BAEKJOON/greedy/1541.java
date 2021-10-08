package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] list = br.readLine().split("-");
        int[] sum = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            String [] temp = list[i].split("\\+");
            for(int j=0; j<temp.length; j++){
                sum[i] += Integer.parseInt(temp[j]);
            }
        }
        int answer = sum[0];
        for(int i = 1; i<sum.length; i++){
            answer -= sum[i];
        }

        bw.write(answer + "\n");
        bw.close();
    }
}

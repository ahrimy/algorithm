import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] task = new int[n];
        for (int i = 0; i < n; i++) {
            task[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(task);

        int total = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            total = total + now + task[i];
            now += task[i];
        }

        bw.write(total + "\n");
        bw.close();
    }
}
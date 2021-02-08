import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(arr);

        for (int value : arr) {
            bw.write(value + "\n");
        }
        bw.close();
    }
}

/**
 * Scanner, System.out.println 사용하면 시간초과
 */
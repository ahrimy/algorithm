package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort10989 {
    public final static int MAX_NUM = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr = sort(arr);

        for (int value : arr) {
            bw.write(value + "\n");
        }
        bw.close();
    }

    public static int[] sort(int[] arr) {
        int[] temp = new int[arr.length];
        int[] count = new int[MAX_NUM + 1];
        for (int value : arr) {
            count[value]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int value : arr) {
            temp[--count[value]] = value;
        }
        return temp;
    }
}

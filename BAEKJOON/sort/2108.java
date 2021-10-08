package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort2108 {
    public final static int MAX_NUM = 8000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[MAX_NUM + 1];
        int total = 0;
        int[] answer = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        count = counting(arr, count);
        answer[2] = mode(count);
        arr = sorting(arr, count);

        answer[0] = mean(total, n);
        answer[1] = median(arr);
        answer[3] = range(arr);

        for (int value : answer) {
            bw.write(value + "\n");
        }
        bw.close();
    }

    public static int[] counting(int[] arr, int[] count) {
        for (int value : arr) {
            count[value + 4000]++;
        }
        return count;
    }

    public static int[] sorting(int[] arr, int[] count) {
        int[] temp = new int[arr.length];

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int value : arr) {
            temp[--count[value + 4000]] = value;
        }
        return temp;
    }

    public static int range(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }

    public static int mean(int total, int n) {
        return (int) Math.rint((double) total / n);
    }

    public static int median(int[] arr) {
        return arr[arr.length / 2];
    }

    public static int mode(int[] count) {
        int max = 0;
        int first = MAX_NUM + 1;
        int second = MAX_NUM + 1;
        for (int value : count) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                if (first > MAX_NUM) {
                    first = i - 4000;
                    continue;
                }
                second = i - 4000;
                break;
            }
        }
        return second > MAX_NUM ? first : second;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort1427 {
    public final static int MAX_NUM = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String answer = sort(str);

        bw.write(answer + "\n");
        bw.close();
    }

    public static String sort(String str) {
        String temp = "";
        int[] count = new int[MAX_NUM + 1];
        for (int i = 0; i < str.length(); i++) {
            int value = Integer.parseInt(str.substring(i, i + 1));
            count[value]++;
        }
        int index = 0;
        int countIdx = 0;
        while (index < str.length()) {
            if (count[countIdx] == 0) {
                countIdx++;
                continue;
            }
            temp = String.valueOf(countIdx) + temp;
            count[countIdx]--;
            index++;
        }
        return temp;
    }
}

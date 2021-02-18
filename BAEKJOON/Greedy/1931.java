import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            list.add(new Meeting(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        Collections.sort(list);

        int now = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            Meeting m = list.get(i);
            if(m.start >= now){
                now = m.end;
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.close();
    }
}

class Meeting implements Comparable<Meeting> {
    int start, end, duration;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
        this.duration = end-start;
    }

    @Override
    public int compareTo(Meeting m) {
        if (this.end > m.end) {
            return 1; 
        } else if (this.end == m.end) {
            if (this.start > m.start) { 
                return 1;
            }
        }
        return -1;
    }
}
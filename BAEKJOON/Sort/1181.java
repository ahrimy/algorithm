import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        ArrayList<Word> list = new ArrayList<>();
        for (String value : set) {
            list.add(new Word(value));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Word w = list.get(i);
            bw.write(w.str + "\n");
        }
        bw.close();
    }
}

class Word implements Comparable<Word> {
    String str;
    int length;

    public Word(String str) {
        this.str = str;
        this.length = str.length();
    }

    @Override
    public int compareTo(Word w) {
        if (this.length > w.length) {
            return 1;
        } else if (this.length == w.length) {
            int i = 0;
            while(i<this.length) {
                if (this.str.charAt(i) != w.str.charAt(i)) {
                    break;
                }
                i++;
            }
            if(this.str.charAt(i) > w.str.charAt(i)){
                return 1;
            }

        }
        return -1;
    }
}
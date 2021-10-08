package sort;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            list.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            bw.write(p.x + " " + p.y + "\n");
        }
        bw.close();
    }
}

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x > p.x) {
            return 1; // x에 대해서는 오름차순
        } else if (this.x == p.x) {
            if (this.y > p.y) { // y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }
}
package sort;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class Sort11651 {
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
        if (this.y > p.y) {
            return 1; 
        } else if (this.y == p.y) {
            if (this.x > p.x) { 
                return 1;
            }
        }
        return -1;
    }
}
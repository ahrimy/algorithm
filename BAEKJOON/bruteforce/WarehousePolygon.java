package bruteforce;
/**
 * 2304
 * 창고 다각형
 * Java
 */

import java.util.List;
import java.util.Scanner;

public class WarehousePolygon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] data = new int[1001];

        int startIndex = 1000;
        int endIndex = 0;
        int max = 0;
        for(int i=0;i<n;i++) {
            int l = sc.nextInt();
            int h = sc.nextInt();
            data[l] = h;
            if(h > max) max = h;
            if(l < startIndex) startIndex = l;
            if(l > endIndex) endIndex = l;
        }

        int total = 0;
        int prev = data[startIndex];
        int leftHighest = startIndex;
        while(leftHighest <= endIndex && data[leftHighest] < max) {
            if(prev < data[leftHighest]) prev = data[leftHighest];
            total += prev;
            leftHighest++;
        }
        prev = data[endIndex];
        int rightHighest = endIndex;
        while(rightHighest >= startIndex && data[rightHighest] < max) {
            if(prev < data[rightHighest]) prev = data[rightHighest];
            total += prev;
            rightHighest--;
        }
        total += (rightHighest - leftHighest + 1) * max;

        System.out.println(total);


    }
}

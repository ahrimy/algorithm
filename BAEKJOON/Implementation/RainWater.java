package Implementation;

/**
 * 14719
 * 빗물
 * Java
 */

import java.util.Scanner;

public class RainWater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        int total = height * width;
        boolean[][] noWater = new boolean[height][width];
        for(int i=0;i<width;i++) {
            int blockHeight = scanner.nextInt();
            for(int j=1;j<=blockHeight;j++) {
                noWater[height - j][i] = true;
            }
            total -= blockHeight;
        }

        for(int i=0;i<height;i++) {
            int index = 0;
            while(index < width && !noWater[i][index]){
                total--;
                noWater[i][index++] = true;
            }
            index = width-1;
            while(index >= 0 && !noWater[i][index]){
                total--;
                noWater[i][index--] = true;
            }
        }
        System.out.println(total);
        scanner.close();
    }
}

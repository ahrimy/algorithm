package greedy;
/**
 * 1700
 * 멀티탭 스케줄링
 * Java
 */
import java.util.Scanner;

public class PowerBarScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] powerBar = new int[n];
        int[] order = new int[k];

        for(int i=0;i<k;i++) {
            order[i] = scanner.nextInt();
        }

        int count = 0;
        for(int i=0;i<k;i++) {
            boolean isExists = false;
            for(int j=0;j<n;j++) {
                if(powerBar[j] == order[i]) {
                    isExists = true;
                    break;
                }
            }
            if(isExists) continue;
            for(int j=0;j<n;j++) {
                if(powerBar[j] == 0) {
                    powerBar[j] = order[i];
                    isExists = true;
                    break;
                }
            }
            if(isExists) continue;
            int position = 0;
            int max = i + 1;
            for(int j=0;j<n;j++) {
                int index = i + 1;
                while(index < k && order[index] != powerBar[j]) index++;
                if(index > max) {
                    position = j;
                    max = index;
                }
            }
            if(powerBar[position] > 0 && powerBar[position] != order[i]) count++;
            powerBar[position] = order[i];
        }
        System.out.println(count);

        scanner.close();
    }
}

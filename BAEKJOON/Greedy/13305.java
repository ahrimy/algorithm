import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

class _13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] distance = br.readLine().split(" ");
        String[] price = br.readLine().split(" ");
        
        long total = 0;
        long curDistance = Long.parseLong(distance[0]);
        long cost = Long.parseLong(price[0]);
        for (int i = 1; i < n-1; i++) {
            if(cost > Long.parseLong(price[i])){
                total += (curDistance*cost);
                cost = Long.parseLong(price[i]);
                curDistance = 0;
            }
           curDistance += Long.parseLong(distance[i]);
        }
        total += (curDistance*cost);

        bw.write(total + "\n");
        bw.close();
    }
}

/**
 * int 안됨
 * long으로
 */
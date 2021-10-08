package dp;

import java.io.*;

class _9184 {
    public static int[][][] result = new int[21][21][21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        while(!input.equals("-1 -1 -1")){
            String[] temp = input.split(" ");
            int[] n = {Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2])};
            bw.write("w("+n[0]+", "+n[1]+", "+n[2]+") = ");
            bw.write(w(n[0],n[1],n[2])+"\n");
            input = br.readLine();
        }
        bw.close();
    }
    public static int w(int a,int b,int c){
        if(a <= 0 || b<= 0 || c<=0){
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        }
        if(result[a][b][c] > 0){
            return result[a][b][c];
        }
        if(a<b && b<c){
            result[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        result[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return result[a][b][c];
    }
}

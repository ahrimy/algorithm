
import java.io.*;

class _9461 {
    public static long[] p = new long[101];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        for(int i=0;i < t;i++){
            int n = Integer.parseInt(br.readLine());
            recursive(n);
             bw.write(p[n]+"\n");
        }
        bw.close();
    }
    public static void recursive(int n){
        if(p[n] > 0){
            return;
        }
        if(p[n-2] == 0){
            recursive(n-2);
        }
        if(p[n-3] == 0){
            recursive(n-3);
        }
        p[n] = p[n-2] + p[n-3];
    }
}

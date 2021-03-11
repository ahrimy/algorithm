import java.io.*;

class _2156 {
    public static int[][] count = new int[41][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] result = fibonacci(n);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.close();
    }
    public static int[] fibonacci(int n){
        if(n > 1 && count[n][1] == 0){
            int[] first = fibonacci(n-1);
            int[] second = fibonacci(n-2);
            count[n][0]  = first[0] + second[0];
            count[n][1]  = first[1] + second[1];
        }
        return count[n];
    }
}

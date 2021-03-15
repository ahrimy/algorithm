import java.io.*;

class _11054{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        String[] temp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            list[i] = Integer.parseInt(temp[i]);
        }
    }
}
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        Recursion r = new Recursion();
        String[] answer = new String[a];
        for(int i=0;i<answer.length;i++){
            answer[i]="";
        }
        for(int i=0; i<a; i++){
            int b = scan.nextInt();
            int c = scan.nextInt();
            r.recursion(b,c,"",answer,i);
        }
        for(int i=0;i<a;i++){
            System.out.println(answer[i]);
        }
    }
}
class Recursion{
    public void recursion(int A, int B){
        String[] command = {"D","S","L","R"};
        Map<String,Integer> map = new HashMap<String,Integer>();
        int depth = 0;
        while(){
            
        }
    }
    private int action(int A, String command){
        int result = 0;
        switch(command){
            case "D":
                result = command_D(A);
                break;
            case "S":
                result = command_S(A);
                break;
            case "L":
                result = command_L(A);
                break;
            default:
                result = command_R(A);
                break;
        }
        return result;
    }
    private int command_D(int A){
        return (A*2)>9999?(A*2)%10000:A*2;
    }
    private int command_S(int A){
        return A>1?A-1:9999;
    }
    private int command_L(int A){
        return (A%1000)*10 + (A/1000);
    }
    private int command_R(int A){
        return (A%10)*1000 + (A/10);
    }
}
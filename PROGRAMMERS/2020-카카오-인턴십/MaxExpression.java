/**
 * 2020 카카오 인턴십
 * 수식 최대화 
 * Java
 */

public class MaxExpression {
    long max = 0;
    
    public long solution(String expression) {
        String[] operator = {"+", "-", "*"};
        perm(expression, operator, 0, 3);
        return max;
    }
    
    public void perm(String expression, String[] operator, int index, int n) {
        if(index == n) {
            max = Math.max(max, getResult(expression, operator));
            return;
        }
        
        for (int i = index; i < n; i++) {
            swap(operator, index, i);
            perm(expression, operator,index + 1, n);
            swap(operator, index, i);
        }
    }
    
    public void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public long getResult(String expression, String[] operator) {
        String[] last = expression.split("\\"+operator[2]);
        for(int i=0;i<last.length;i++) {
            String[] second = last[i].split("\\"+operator[1]);
            
            for(int j=0;j<second.length;j++) {
                String[] first = second[j].split("\\"+operator[0]);
                second[j] = first[0];
                for(int k=1;k<first.length;k++) {
                    second[j] = calculate(operator[0], second[j], first[k]);
                }
            }
            last[i] = second[0];
            for(int j=1;j<second.length;j++) {
                last[i] = calculate(operator[1], last[i], second[j]);
            }
        }
        String total = last[0];
        for(int i=1;i<last.length;i++) {
            total = calculate(operator[2], total, last[i]);
        }
        return Math.abs(Long.parseLong(total));
    }
    public String calculate(String operator, String a, String b) {
        long numA = Long.parseLong(a);
        long numB = Long.parseLong(b);
        
        if(operator.equals("+")) {
            return String.valueOf(numA + numB);
        } else if(operator.equals("-")) {
            return String.valueOf(numA - numB);
        } else {
            return String.valueOf(numA * numB);
        }
    }
}

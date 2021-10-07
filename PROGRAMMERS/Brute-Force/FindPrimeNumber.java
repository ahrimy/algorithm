/*
 * 완전탐색
 * 소수 찾기
 * Java
 */

import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String[] number_list = new String[numbers.length()];
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<numbers.length();i++){
            number_list[i]=String.valueOf(numbers.substring(i,i+1));
        }
        for(int i=1;i<=numbers.length();i++){
            permutation(number_list, 0, numbers.length(), i,set);
        }
        
        for(int value : set) {
            int count = 0;
            for(int i=1;i<=value/2;i++){
                if(value%i==0){
                    count++;
                }
            }
            if(count == 1){
                answer++;
            }
        }
        
        return answer;
    }
    private void permutation(String[] arr, int depth, int n, int r,Set<Integer> set) {
        if (depth == r) {
            String str = "";
            for(int i=0;i<r;i++){
                str+=arr[i];
            }
            set.add(Integer.parseInt(str));
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r,set);
            swap(arr, depth, i);
        }
    }
 
    private void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}

/*
 * Weekly Challenge
 * 8주차
 * Java
 */

public class Week8 {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        int bigger;
        int smaller;
        for(int[] size : sizes) {
            bigger = Math.max(size[0], size[1]);
            smaller = Math.min(size[0], size[1]);
            if(width < bigger) width = bigger;
            if(height < smaller) height = smaller;  
        }
        return width * height;
    }
}

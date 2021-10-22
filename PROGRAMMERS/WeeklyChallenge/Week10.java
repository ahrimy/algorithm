/*
 * Weekly Challenge
 * 10주차 교점에 별 만들기
 * Java
 */

import java.util.Set;
import java.util.HashSet;

public class Week10 {
    public String[] solution(int[][] line) {
        Set<long[]> list = new HashSet<>();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for(int i=0;i<line.length;i++) {
            for(int j=i+1;j<line.length;j++) {
                // 이거 안바꿔주면 계산 과정에서 Int 범위 초과됨
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                long adbc = a*d - b*c;
                if(adbc == 0) continue;
                
                long bfed = b*f - e*d;
                if(bfed % adbc != 0) continue;
                long x = bfed / adbc;
                
                long ecaf = e*c - a*f;
                if(ecaf % adbc != 0) continue;
                long y = ecaf / adbc;
                
                
                long[] result = new long[2];
                result[0] = x;
                result[1] = y;
                list.add(result);
                if(result[0] > maxX) maxX = result[0];
                if(result[1] > maxY) maxY = result[1];
                if(result[0] < minX) minX = result[0];
                if(result[1] < minY) minY = result[1];

            }
        }

        int h = (int)(maxY - minY) + 1;
        int w = (int)(maxX - minX) + 1;
        String[] answer = new String[h];
        StringBuilder[] builders = new StringBuilder[h];
        for(int i=0;i<h;i++) {
            builders[i] = new StringBuilder();
            for(int j=0;j<w;j++) {
                builders[i].append(".");
            }
        }
        for(long[] l : list) {
            int col = (int)(l[0] - minX);
            int row = (h-1) - (int)(l[1]-minY);
            builders[row].setCharAt(col, '*');
        }
        for(int i=0;i<h;i++) answer[i] = builders[i].toString();
        return answer;
    }
}

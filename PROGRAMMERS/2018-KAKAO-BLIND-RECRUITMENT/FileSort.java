/*
 * 2018 KAKAO BLIND RECRUITMENT
 * [3차] 파일명 정렬
 * Java
 */
import java.util.Arrays;

public class FileSort {
    public String[] solution(String[] files) {
        File[] fileList = new File[files.length];
        for(int i=0;i<files.length;i++) {
            String head = files[i].replaceAll("\\d+.*", "").toLowerCase();  
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<5;j++) {
                if(head.length() + j >= files[i].length() || !Character.isDigit(files[i].charAt(head.length() + j))) break;
                sb.append(files[i].charAt(head.length() + j));
            }
            fileList[i] = new File(i, head, Integer.valueOf(sb.toString()), files[i]);
        }
        
        Arrays.sort(fileList, (a, b) -> {
            if(a.head.compareTo(b.head) > 0) return 1;
            if(a.head.compareTo(b.head) < 0) return -1;
            if(a.number > b.number) return 1;
            if(a.number < b.number) return -1;
            if(a.index > b.index) return 1;
            if(a.index < b.index) return -1;
            return 0;
        });
        String[] answer = new String[files.length];
        for(int i=0;i<files.length;i++) {
            answer[i] = fileList[i].origin;
        }
        return answer;
    }
}

class File {
    int index;
    String head;
    int number;
    String origin;
    
    public File(int index, String head, int number, String origin) {
        this.index = index;
        this.head = head;
        this.number = number;
        this.origin = origin;
    }
}

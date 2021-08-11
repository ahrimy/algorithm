/**
 * 해시
 * 베스트앨범
 * Java
 */
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        ArrayList<Integer> bestList = new ArrayList<>();
        int playsTotal = 0;
        for(int i=0;i<genres.length;i++){
            playsTotal = total.getOrDefault(genres[i], 0) + plays[i];
            total.put(genres[i], playsTotal);
        }
        
        Song[] list = new Song[genres.length];
        for(int i=0;i<genres.length;i++){
            list[i] = new Song(genres[i], total.get(genres[i]), i, plays[i]);
        }
        
        Arrays.sort(list);
       
        int current;
        for(int i=0;i<list.length;i++){
            current = count.getOrDefault(list[i].getGenre(), 0);
            if(current == 2) continue;
            bestList.add(list[i].getId());
            count.put(list[i].getGenre(), current+1);
        }
        int[] answer = new int[bestList.size()];
        for(int i=0;i<bestList.size();i++){
            answer[i] = bestList.get(i);
        }
        
        return answer;
    }
}

class Song implements Comparable<Song> {
    private String genre;
    private int genreTotal;
    private int id;
    private int plays;
    
    public Song(String genre, int genreTotal, int id, int plays){
        this.genreTotal = genreTotal;
        this.genre = genre;
        this.id = id;
        this.plays = plays;
    }

    public String getGenre(){
        return this.genre;
    }
    public int getId(){
        return this.id;
    }
    
    
    @Override
    public int compareTo(Song song) {
         if (this.genreTotal > song.genreTotal) {
             return -1;
         }
        if (this.genreTotal < song.genreTotal) {
             return 1;
         }
        if(this.plays > song.plays){
            return -1;
        }
        if(this.plays < song.plays){
            return 1;
        }        
        if(this.id < song.id){
            return -1;
        }
        if(this.id > song.id){
            return 1;
        }
        return 0;
     }
}
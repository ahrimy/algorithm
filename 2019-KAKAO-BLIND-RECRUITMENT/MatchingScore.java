/*
 * 2019 KAKAO BLIND RECRUITMENT
 * 매칭 점수
 * Java
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class MatchingScore {

    public int solution(String word, String[] pages) {

        String[] urls = new String[pages.length]; // url 저장 (map key)
        HashMap<String, Integer> indexMap = new HashMap<>(); // index 저장
        HashMap<String, ArrayList<String>> linkMap = new HashMap<>(); // 외부 link 저장
        HashMap<String, double[]> scoreMap = new HashMap<>(); // 점수 저장
        
        word = word.toLowerCase();
        
        Matcher matcher;
        Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(\\S*)\"");
        Pattern linkPattern = Pattern.compile("<a href=\"https://(\\S*)\"");
        
        
        String url;
        String body;
        String[] words;
        ArrayList<String> links;
        double[] score; // total(기본점수 + 링크점수), 기본점수, 외부 링크 수
        int index = 0;
        for(String page: pages){
            // url 검색
            matcher = pattern.matcher(page);
            if(matcher.find()) {
                url = matcher.group(1);
                body = page.split("<body>")[1].split("</body>")[0];
                links = new ArrayList<String>();
                score = new double[3];
                
                // 외부 링크 검색
                matcher = linkPattern.matcher(page);
                while(matcher.find()){
                    links.add(matcher.group(1));
                }
                
                // 단어 단위로 파싱
                words = body.replaceAll("<a href=\"\\S*\">|<\\/a>", "").replaceAll("[^a-zA-Z]", " ").trim().replaceAll("\\s+", ",").toLowerCase().split(",");
                
                // 일치하는 단어 개수 계산
                for(String w : words){
                    if(w.equals(word)) score[1]++;
                }
                
                urls[index] = url;
                score[2] = links.size();
                score[0] = score[1];
                scoreMap.put(url, score);
                indexMap.put(url, index++);
                linkMap.put(url, links);
            }
        }
        
        double[] linkScore; // 외부 링크에 해당되는 점수 데이터
        // 링크 점수 계산
        for(String key: indexMap.keySet()){
            score = scoreMap.get(key);
            links = linkMap.get(key); // 외부 링크 리스트
            for(String link: links){
                if(scoreMap.containsKey(link)){
                    linkScore = scoreMap.get(link);
                    // 현재 페이지의 점수를 외부 링크 페이지에 나눠줌
                    linkScore[0] += score[1] / score[2];
                    scoreMap.put(link,linkScore);
                }
            }
        }
        
        // total 순서로 정렬 -> index 순서로 정렬
        Arrays.sort(urls, (a, b) -> {
            if(scoreMap.get(a)[0] == scoreMap.get(b)[0]){
                return indexMap.get(a) - indexMap.get(b);
            }
            if(scoreMap.get(b)[0] > scoreMap.get(a)[0]) return 1;
            if(scoreMap.get(b)[0] < scoreMap.get(a)[0]) return -1;
            return 0;
        });
    
        return indexMap.get(urls[0]);
    }
    
}

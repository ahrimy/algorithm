/*
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * 로또의 최고 순위와 최저 순위
 * JavaScript
 */

function solution(lottos, win_nums) {
    let win = 0;
    let unknown = 0;
    lottos.forEach((lotto) => {
        if(win_nums.includes(lotto)) win++;
        if(lotto === 0) unknown++;
    })
    
    const best = win+unknown > 0 ? 7 - win - unknown : 6
    const worst = win > 0 ? 7 - win : 6
    return [best, worst];
}
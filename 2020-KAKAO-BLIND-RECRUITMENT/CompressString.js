function solution(s) {
    var answer = s.length;
    for(var i=1;i<=s.length/2;i++){
        var newstr = '';
        var prev = s.substring(0,i);
        var count = 1;
        for(var j=i;j<s.length;j=j+i){
            if(prev === s.substring(j,j+i)){
                count++;
                continue;
            }
            newstr += count > 1 ? count : '';
            newstr += prev;
            count = 1;
            prev = s.substring(j,j+i);
        }
        newstr += count > 1 ? count : '';
        newstr += prev;

        if(answer > newstr.length){
            answer = newstr.length;
        }
    }

    return answer;
}

/**
 * 월간 코드 챌린지 시즌 1
 * 두 개 뽑아서 더하기
 * JavaScript
 */

function solution(numbers) {
  var answer = [];
  var result = [];
  for (var i = 0; i < numbers.length; i++) {
    result = add(numbers[i], numbers.slice(i + 1), result);
  }
  answer = result.sort(function (a, b) {
    return a - b;
  });
  return answer;
}
function add(a, numbers, result) {
  if (numbers.length === 0) {
    return result;
  }
  var added_result = a + numbers[0];
  if (!result.includes(added_result)) {
    result.push(added_result);
  }
  return add(a, numbers.slice(1), result);
}

function solution(n) {
  let answer = [];

  function hanoi(num, start, temp, end) {
    //원판이 한 개일 때에는 바로 옮기면 됩니다.
    if (num === 1) {
      answer.push([start, end]);
      return NaN;
    }

    //원반이 n-1개를 경유기둥으로 옮기고
    hanoi(num - 1, start, end, temp);
    //가장 큰 원반은 목표기둥으로
    answer.push([start, end]);
    //경유기둥과 시작기둥을 바꿉니다.
    hanoi(num - 1, temp, start, end);
  }

  hanoi(n, 1, 2, 3);

  console.log(answer);
  console.log(answer.length);

  return answer;
}

// 맨날까먹는다증말

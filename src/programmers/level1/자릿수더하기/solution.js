function solution(n)
{
    let answer = 0;

    let arr = n.toString().split('').map(v => parseInt(v));
  
    answer = arr.reduce((acc, cur) => acc + cur, 0);

    return answer;
}
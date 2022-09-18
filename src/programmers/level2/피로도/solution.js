/**
 * @param {number} k 유저의 현재 피로도
 * @return {number} 유저가 탐험할 수 있는 최대 던전 수
 */
function solution(k, dungeons) {
  let answer = -1;

  const n = dungeons.length;
  let checked = Array.from({ length: n }, () => false);
  let order = Array.from({ length: n }, () => 0);
  let orders = [];

  // 순열 구하기
  function DFS(L) {
    if (L === n) {
      orders.push([...order]);
      return;
    } else {
      for (let i = 0; i < n; i++) {
        if (checked[i]) continue;

        checked[i] = true;
        order[L] = i;
        DFS(L + 1);
        checked[i] = false;
      }
    }
  }

  DFS(0);

  orders.forEach((order) => {
    answer = Math.max(getMaxDungeons(order, dungeons, k), answer);
  });

  return answer;
}

function getMaxDungeons(order, dungeons, k) {
  // k : 유저의 현재 피로도
  // [최소 필요 피로도, 소모 피로도]
  let cnt = 0;
  for (const i of order) {
    const [min, takes] = dungeons[i];
    // 최소 필요 피로도 보다 작은 경우 탐험을 끝냅니다
    if (k < min) break;
    else {
      cnt++;
      // 소모 피로도 만큼 현재 피로도에서 마이너스
      k -= takes;
    }
  }
  return cnt;
}

// 완탐

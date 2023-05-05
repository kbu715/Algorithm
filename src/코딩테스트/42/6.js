function solution(numServer, logs) {
  const queue = new Array(numServer).fill(0); // 각 서버에 대한 큐를 초기화합니다.
  const roundRobinQueue = [...Array(numServer).keys()]; // Round Robin 알고리즘에 사용할 큐를 초기화합니다.

  let leastConnectionServer = 0; // Least Connection 알고리즘에 사용할 변수를 초기화합니다.
  let leastConnectionCount = queue[0];

  for (let i = 0; i < logs.length; i++) {
    const regex = /[^0-9]/g;
    const [requestTime, processingTime] = logs[i]
      .split(" ")
      .map((v) => +v.replace(regex, ""));

    // Round Robin 알고리즘으로 서버를 할당합니다.
    const roundRobinServer = roundRobinQueue.shift();
    queue[roundRobinServer] += processingTime;
    roundRobinQueue.push(roundRobinServer);

    // Least Connection 알고리즘으로 서버를 할당합니다.
    let server = leastConnectionServer;
    for (let j = 1; j < numServer; j++) {
      const nextServer = (leastConnectionServer + j) % numServer;
      if (queue[nextServer] < leastConnectionCount) {
        server = nextServer;
        leastConnectionCount = queue[nextServer];
      }
    }
    queue[server] += processingTime;
    leastConnectionServer = server;

    // Round Robin 알고리즘과 Least Connection 알고리즘 중 더 빠른 시간으로 기록합니다.
    if (queue[roundRobinServer] < queue[leastConnectionServer]) {
      leastConnectionServer = roundRobinServer;
      leastConnectionCount = queue[leastConnectionServer];
    }
  }
}

// console.log(solution(3, ['0 3', '1 9', '2 6'])); // 12
// console.log(solution(2, ["0 5", "1 4", "2 4", "3 4"])); // 9

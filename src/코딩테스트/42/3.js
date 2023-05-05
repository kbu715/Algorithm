function solution(numServer, logs) {
  // 로그 문자열 파싱
  const requests = logs.map((log) => {
    const [time, duration] = log.split(" ");
    return { time: +time, duration: +duration };
  });

  // Round Robin 알고리즘
  const roundRobin = () => {
    const start = Date.now();
    let index = 0;
    const serverStatus = new Array(numServer).fill(0);
    for (let i = 0; i < requests.length; i++) {
      const request = requests[i];
      let assigned = false;
      while (!assigned) {
        const serverId = index % numServer;
        const serverLoad = serverStatus[serverId];
        if (serverLoad === 0) {
          serverStatus[serverId]++;
          assigned = true;
        } else {
          index++;
        }
      }
    }
    const end = Date.now();
    return end - start;
  };

  // Least Connection 알고리즘
  const leastConnection = () => {
    const start = Date.now();
    const serverStatus = new Array(numServer).fill(0);
    for (let i = 0; i < requests.length; i++) {
      const request = requests[i];
      let serverId = 0;
      let minLoad = Infinity;
      for (let j = 0; j < numServer; j++) {
        if (serverStatus[j] < minLoad) {
          serverId = j;
          minLoad = serverStatus[j];
        }
      }
      serverStatus[serverId]++;
    }
    const end = Date.now();
    return end - start;
  };

  // 처리 시간 측정
  const roundRobinTime = roundRobin();
  const leastConnectionTime = leastConnection();

  // 더 빠른 알고리즘 반환
  if (roundRobinTime < leastConnectionTime) {
    return ["RoundRobin", roundRobinTime - leastConnectionTime];
  } else {
    return ["LeastConnection", leastConnectionTime - roundRobinTime];
  }
}

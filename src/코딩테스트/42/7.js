function solution(numServers, logs) {
  // Round Robin 알고리즘 구현
  const roundRobin = () => {
    let serverIdx = 0;
    return (reqIdx) => {
      const server = serverIdx++ % numServers;
      return { server, reqIdx };
    };
  };

  // Least Connection 알고리즘 구현
  const leastConnection = () => {
    const connections = new Array(numServers).fill(0);
    return (reqIdx) => {
      let minConnections = Infinity;
      let server = 0;
      for (let i = 0; i < numServers; i++) {
        if (connections[i] < minConnections) {
          minConnections = connections[i];
          server = i;
        }
      }
      connections[server]++;
      return {
        server,
        reqIdx,
        finishTime: logs[reqIdx][0] + logs[reqIdx][1],
      };
    };
  };

  const rr = roundRobin();
  const lc = leastConnection();
  const rrResults = new Array(logs.length);
  const lcResults = new Array(logs.length);

  // 각 알고리즘을 사용하여 요청 할당 및 처리 시간 계산
  for (let i = 0; i < logs.length; i++) {
    const { server: rrServer, reqIdx: rrReqIdx } = rr(i);
    const { server: lcServer, reqIdx: lcReqIdx, finishTime } = lc(i);
    const [reqTime, procTime] = logs[i];
    const rrFinishTime =
      rrResults[rrReqIdx - 1] !== undefined
        ? Math.max(rrResults[rrReqIdx - 1], reqTime) + procTime
        : reqTime + procTime;
    const lcFinishTime =
      lcResults[lcReqIdx - 1] !== undefined
        ? Math.max(lcResults[lcReqIdx - 1], reqTime) + procTime
        : reqTime + procTime;
    rrResults[rrReqIdx] = rrFinishTime;
    lcResults[lcReqIdx] = finishTime > lcFinishTime ? finishTime : lcFinishTime;
  }

  // 각 알고리즘의 처리 시간 총합을 계산하여 반환
  const rrTotal = rrResults.reduce((acc, cur) => acc + cur, 0);
  const lcTotal = lcResults.reduce((acc, cur) => acc + cur, 0);
  return lcTotal - rrTotal;
}

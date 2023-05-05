function solution(numServer, logs) {
  const roundRobinCompletionTime = new Array(numServer).fill(0); // 각 서버의 마지막 요청 처리 완료 시각
  const leastConnectionConnections = new Array(numServer).fill(0); // 각 서버의 현재 할당된 요청 개수
  const leastConnectionCompletionTime = new Array(numServer).fill(0); // 각 서버의 마지막 요청 처리 완료 시각
  const responseTimeDiff = new Array(logs.length).fill(0); // 각 요청에 대한 두 알고리즘의 응답 시간 차이

  for (let i = 0; i < logs.length; i++) {
    const regex = /[^0-9]/g;
    const [requestTime, processingTime] = logs[i]
      .split(" ")
      .map((v) => +v.replace(regex, ""));

    // Round Robin 알고리즘
    const roundRobinServer = i % numServer; // 다음 할당할 서버의 번호
    const roundRobinStartTime = Math.max(
      roundRobinCompletionTime[roundRobinServer],
      requestTime
    ); // 서버에 할당된 요청의 처리 완료 시각과 새 요청의 요청 시각 중 큰 값
    roundRobinCompletionTime[roundRobinServer] =
      roundRobinStartTime + processingTime; // 서버에 할당된 요청의 처리 완료 시각 업데이트
    const roundRobinResponseTime =
      roundRobinCompletionTime[roundRobinServer] - requestTime;

    // Least Connection 알고리즘
    let leastConnectionServer = 0;
    let leastConnectionCount = leastConnectionConnections[0];
    for (let j = 1; j < numServer; j++) {
      if (leastConnectionConnections[j] < leastConnectionCount) {
        leastConnectionCount = leastConnectionConnections[j];
        leastConnectionServer = j;
      }
    }
    const leastConnectionStartTime = Math.max(
      leastConnectionCompletionTime[leastConnectionServer],
      requestTime
    );
    leastConnectionConnections[leastConnectionServer]++;
    leastConnectionCompletionTime[leastConnectionServer] =
      leastConnectionStartTime + processingTime;
    const leastConnectionResponseTime =
      leastConnectionCompletionTime[leastConnectionServer] - requestTime;

    responseTimeDiff[i] = roundRobinResponseTime - leastConnectionResponseTime;
  }

  const roundRobinTotalTime = roundRobinCompletionTime.reduce(
    (acc, cur) => Math.max(acc, cur),
    0
  ); // Round Robin 알고리즘의 총 처리 시간
  const leastConnectionTotalTime = leastConnectionCompletionTime.reduce(
    (acc, cur) => Math.max(acc, cur),
    0
  ); // Least Connection 알고리즘의 총 처리 시간
  const totalTimeDiff = leastConnectionTotalTime - roundRobinTotalTime; // 두 알고리즘의 총 처리 시간 차이

  console.log(totalTimeDiff);
}

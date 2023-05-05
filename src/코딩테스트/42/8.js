const regex = /[^0-9]/g;

function roundRobin(numServer, logs) {
  let serverIdx = 0;
  const serverLoad = new Array(numServer).fill(0);
  let totalTime = 0;

  for (let i = 0; i < logs.length; i++) {
    const [requestTime, duration] = logs[i]
      .split(" ")
      .map((v) => +v.replace(regex, ""));

    // console.log(requestTime, duration);
    const server = serverIdx % numServer;

    const startTime = Math.max(requestTime, serverLoad[server]);
    totalTime += startTime - requestTime + duration;
    console.log(totalTime);
    serverLoad[server] = startTime + duration;
    serverIdx++;
  }

  return totalTime;
}

function leastConnection(numServer, logs) {
  const serverLoad = new Array(numServer).fill(0);
  let totalTime = 0;

  for (let i = 0; i < logs.length; i++) {
    const [requestTime, duration] = logs[i]
      .split(" ")
      .map((v) => +v.replace(regex, ""));

    // console.log(requestTime, duration);
    let minLoad = Infinity;
    let minServer = 0;

    for (let j = 0; j < numServer; j++) {
      if (serverLoad[j] < minLoad) {
        minLoad = serverLoad[j];
        minServer = j;
      }
    }

    const startTime = Math.max(requestTime, serverLoad[minServer]);
    totalTime += startTime - requestTime + duration;
    console.log(totalTime);
    serverLoad[minServer] = startTime + duration;
  }

  return totalTime;
}

function solution(numServer, logs) {
  const roundRobinTime = roundRobin(numServer, logs);
  const leastConnectionTime = leastConnection(numServer, logs);

  if (roundRobinTime < leastConnectionTime) {
    return [1, leastConnectionTime - roundRobinTime];
  } else {
    return [2, roundRobinTime - leastConnectionTime];
  }
}

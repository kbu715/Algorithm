function solution(priorities, location) {
  let list = priorities.map((priority, index) => {
    return {
      index: index,
      priority: priority,
    };
  });

  // 프린터 대기열
  let queue = [];

  while (list.length > 0) {
    let firstElem = list.shift();
    let hasHighPriority = list.some((ele) => ele.priority > firstElem.priority);
    if (hasHighPriority) {
      list.push(firstElem);
    } else {
      queue.push(firstElem);
    }
  }

  return queue.findIndex((element) => element.index === location) + 1;
}

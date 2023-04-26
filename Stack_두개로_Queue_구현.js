// 1. instack, outstack 2개 생성

// 2. instack은 enqueue, outstack은 dequeue 담당

// - enqueue() : instack에 push()를 하여 데이터를 저장합니다
// - dequeue() : 만약 outstack이 비어있다면 instack.pop()을 하고 outstack.push()를 하여 instack에서
// outstack으로 모든 데이터를 옮겨 넣습니다. 이 결과로 가장 먼저 왔던 데이터는 outstack의 top에 위치하게 됩니다.
// outstack.pop()을 하면 가장 먼저 왔던 데이터가 가장 먼저 추출됩니다 (FIFO)

class Queue {
  constructor() {
    this.instack = [];
    this.outstack = [];
  }

  enqueue(element) {
    this.instack.push(element);
  }

  dequeue() {
    if (!this.outstack.length) {
      while (this.instack.length) {
        this.outstack.push(this.instack.pop());
      }
    }
    return this.outstack.pop();
  }
}

// 시간 복잡도
// enqueue: O(1)
// dequeue:
// worst case(outstack이 빈 경우) : O(n)
// best case(outstack이 비어있지 않은 경우) : O(1)

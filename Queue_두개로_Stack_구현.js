// push에 사용할 queue: q1
// pop에 사용할 queue: q2

// 1. push() : q1으로 enqueue()를 하여 데이터를 저장합니다
// 2. pop() :
// a. q1에 저장된 데이터의 갯수가 1 이하로 남을 때까지 dequeue()를 한 후, 추출된 데이터를 q2에 enqueue()합니다.
// 결과적으로 가장 최근에 들어온 데이터를 제외한 모든 데이터는 q2로 옮겨집니다.
// b. q1에 남아 있는 하나의 데이터를 dequeue()해서 가장 최근에 저장된 데이터를 반환합니다.
// c. 다음에 진행될 pop()을 위와 같은 알고리즘으로 진행하기 위해 q1과 q2의 이름을 swap합니다.

class Stack {
  constructor() {
    this.q1 = [];
    this.q2 = [];
  }

  push(element) {
    this.q1.push(element);
  }

  pop() {
    while (this.q1.length > 1) {
      this.q2.push(this.q1.shift());
    }

    let temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;

    return this.q2.pop();
  }
}

// 시간 복잡도

// push : O(1)
// pop : q1에 저장되어 있는 n개의 원소중에 n-1개를 q2로 옮겨야 하므로 O(n)

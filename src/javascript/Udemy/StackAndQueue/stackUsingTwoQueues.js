class Stack {
  constructor() {
    this.q1 = new Queue();
    this.q2 = new Queue();
  }
  push(val) {
    this.q1.enqueue(val);
    return this;
  }
  pop() {
    while (this.q1.size > 1) {
      this.q2.enqueue(this.q1.dequeue());
    }

    let temp = this.q1;
    this.q1 = this.q2;
    this.q2 = temp;

    return this.q2.dequeue();
  }
}

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }
  enqueue(data) {
    var node = new Node(data);

    if (!this.first) {
      this.first = node;
      this.last = node;
    } else {
      this.last.next = node;
      this.last = node;
    }

    return ++this.size;
  }

  dequeue() {
    if (!this.first) return null;

    var temp = this.first;
    if (this.first == this.last) {
      this.last = null;
    }
    this.first = this.first.next;
    this.size--;
    return temp.value;
  }
}

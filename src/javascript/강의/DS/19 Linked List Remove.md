# Linked List Remove (index)

```javascript
class Node {
    constructor(value) {
        this.value = value
        this.next = null
    }
}

class LinkedList {
    constructor() {
        this.head = null
        this.size = 0
    }

    isEmpty() {
        return this.size === 0
    }

    getSize() {
        return this.size
    }

    // O(1)
    prepend(value) {
        const node = new Node(value)
        if (this.isEmpty()) {
            this.head = node
        } else {
            node.next = this.head
            this.head = node
        }
        this.size++
    }

    // O(n)
    append(value) {
        const node = new Node(value)
        if (this.isEmpty()) {
            this.head = node
        } else {
            let prev = this.head // previous
            while (prev.next) {
                prev = prev.next
            }
            prev.next = node
        }
        this.size++
    }

    insert(value, index) {
        // 1. invalid index
        if (index < 0 || index > this.size) {
            return
        }
        // 2. index 0
        if (index === 0) {
            this.prepend(value)
        } else {
            // 3. index > 0
            const node = new Node(value)
            let prev = this.head
            for (let i = 0; i < index-1; i++) {
                prev = prev.next
            }
            node.next = prev.next
            prev.next = node

            this.size++
        }

    }

    removeFrom(index) {
        if (index < 0 || index >= this.size) {
            return null
        }
        let removeNode
        if (index === 0) {
            removeNode = this.head
            this.head = this.head.next
        } else {
            let prev = this.head
            for (let i = 0; i < index - 1; i++) {
                prev = prev.next
            }
            removeNode = prev.next
            prev.next = removeNode.next
        }
        this.size--

        return removeNode.value
    }

    print() {
        if (this.isEmpty()) {
            console.log('List is empty')
        } else {
            let current = this.head
            let listValues = ''
            while (current) {
                listValues += `${current.value} `
                current = current.next
            }
            console.log(listValues)
        }
    }
}

const list = new LinkedList()

list.insert(10, 0)
list.print()

list.insert(20, 0)
list.print()

list.insert(30, 1)
list.print()

list.insert(40, 2)
list.print()
console.log(list.getSize())

console.log(list.removeFrom(10))

console.log(list.removeFrom(0))

list.print()

console.log(list.removeFrom(1))

list.print()
```
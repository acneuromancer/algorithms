class MinHeap {
  constructor() {
    this.heap = [null];
  }

  insert(num) {
    this.heap.push(num);
    if (this.heap.length > 2) {
      let idx = this.heap.length -1;
      while(this.heap[idx] < this.heap[Math.floor(idx/2)]) {
        if (idx >= 1) {
          [this.heap[Math.floor(idx/2)], this.heap[idx]] = [this.heap[idx], this.heap[Math.floor(idx/2)]];
          if (Math.floor(idx/2) > 1) {
            idx = Math.floor(idx/2);
          } else {
            break;
          }
        }
      }
    }
  }

  getValues() {
    return this.heap;
  }

}

class MaxHeap {
  constructor() {
    this.heap = [null];
  }

  insert(num) {
    this.heap.push(num);
    if (this.heap.length > 2) {
      let idx = this.heap.length - 1;
      while(this.heap[idx] > this.heap[Math.floor(idx/2)]) {
        if (idx >= 1) {
          [this.heap[Math.floor(idx/2)], this.heap[idx]] = [this.heap[idx], this.heap[Math.floor(idx/2)]];
          if (Math.floor(idx/2) > 1) {
            idx = Math.floor(idx/2);
          } else {
            break;
          }
        }
      }
    }
  }

  getValues() {
    return this.heap;
  }
}


let minHeap = new MinHeap();
minHeap.insert(10);
minHeap.insert(5);
minHeap.insert(-1);
console.log('Min heap: ' + minHeap.getValues());

let maxHeap = new MaxHeap();
maxHeap.insert(10);
maxHeap.insert(5);
maxHeap.insert(100);
console.log('Max heap: ' + maxHeap.getValues());

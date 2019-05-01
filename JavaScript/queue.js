function Queue() {
  collection = [];

  this.getValues = function() {
    return collection;
  }

  this.size = function() {
    return collection.length;
  }

  this.isEmpty = function() {
    return collection.length === 0;
  }

  this.enqueue = function(element) {
    collection.push(element);
  }

  this.dequeue = function() {
    return collection.shift();
  }

  this.front = function() {
    return collection[0];
  }
}

let q = new Queue();
q.enqueue(-1);
q.enqueue(10);
q.enqueue(5);

console.log(q.getValues());
console.log(q.front());

while (!q.isEmpty()) {
  console.log(q.dequeue());
}

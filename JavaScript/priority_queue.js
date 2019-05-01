function PriorityQueue() {
  var collection = [];

  this.size = function() {
    return collection.length;
  }

  this.print = function() {
    console.log(collection);
  }

  this.isEmpty = function() {
    return this.size() === 0;
  }

  this.front = function() {
    return collection[0];
  }

  this.enqueue = function(element) {
    if (this.isEmpty()) {
      collection.push(element);
    } else {
      var added = false;
      for (var i = 0; i < collection.length; i++) {
        if (element[1] < collection[i][1]) {
          collection.splice(i, 0, element);
          added = true;
          break;
        }
      }
      if (!added) {
        collection.push(element);
      }
    }
  }

  this.dequeue = function() {
    var value = collection.shift();
    return value[0];
  }
}


var pq = new PriorityQueue();
pq.enqueue(['New York', 1]);
pq.enqueue(['Washington', 3]);
pq.enqueue(['London', 2]);
pq.print();

console.log('Front: ' + pq.front());

while (pq.size() != 0) {
  console.log('dequeue: ' + pq.dequeue());
}

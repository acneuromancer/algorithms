function Stack() {
  this.count = 0;
  this.storage = {};

  this.size = function() {
    return this.count;
  }

  this.push = function(data) {
    this.storage[this.count++] = data;
  }

  this.pop = function() {
    if (this.count === 0) {
      return undefined;
    } else {
      this.count--;
      let retVal = this.storage[this.count];
      delete this.storage[this.count];
      return retVal;
    }
  }

  this.peek = function() {
    return this.storage[this.count-1];
  }
}


let myStack = new Stack();
myStack.push(-10);
myStack.push(50);
myStack.push(100);

console.log('Size: ' + myStack.size());
console.log('Peek: ' + myStack.peek());
console.log('Size: ' + myStack.size());

while (myStack.size() != 0) {
  console.log(myStack.pop());
}

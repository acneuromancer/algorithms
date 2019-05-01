// A set implementation in JavaScript from freeCodeCamp

function MySet() {
  var collection = [];

  this.has = function(element) {
    return collection.indexOf(element) !== -1;
  }

  this.add = function(element) {
    if (!this.has(element)) {
      collection.push(element);
      return true;
    } else {
      return false;
    }
  }

  this.size = function() {
    return collection.length;
  }

  this.getValues = function() {
    return collection;
  }

  this.remove = function(element) {
    if (collection === undefined || collection.indexOf(element) === -1) {
      return false;
    } else {
      let index = collection.indexOf(element);
      collection.splice(index, 1);
      return true;
    }
  }
}


let set = new MySet();
console.log(set.add(-1));
console.log(set.add(-1));
console.log(set.add(-10));
console.log(set.add(5));
console.log(set.add(100));
console.log(set.add(100));
console.log(set.getValues());
console.log('Removing 5: ', set.remove(5));
console.log(set.getValues());

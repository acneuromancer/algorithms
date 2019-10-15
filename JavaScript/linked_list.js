// Linked list data structure

function LinkedList() {
  var length = 0;
  var head = null;
  var tail = null;

  var Node = function(element) {
    this.element = element;
    this.next = null;
  };

  this.size = function() {
    return length;
  };

  this.isEmpty = function() {
    return length == 0;
  };

  this.head = function() {
    return head;
  };

  this.tail = function() {
    return tail;
  };

  this.peekFirst = function() {
    return head.element;
  };

  this.peekLast = function() {
    return tail.element;
  };

  this.get = function(index) {
    if (index >= length || index < 0) {
      console.log("Index out of boundary.");
      return undefined;
    }

    var i = 0;
    var currentNode = head;

    while(i != index) {
      currentNode = currentNode.next;
      ++i;
    }

    return currentNode;
  };

  this.add = function(element) {
    var node = new Node(element);

    if (head === null) {
      head = tail = node;
    } else {
      var currentNode = head;
      while(currentNode.next) {
        currentNode = currentNode.next;
      }
      currentNode.next = node;
      tail = node;
    }

    length++;

    return element;
  };

  this.insert = function(element) {
    var node = new Node(element);

    if (head === null) {
      this.head = node;
    } else {
      node.next = head;
      head = node;
    }

    ++length;

    return element;
  };

  this.removeFirst = function() {
    if (head === null) {
      console.log("Empty list");
      return undefined;
    }

    var retValue = head.element;
    head.element = null;
    head = head.next;
    --length;

    if (this.isEmpty()) {
      tail = null;
    }

    return retValue;
  };

  this.removeLast = function() {
    if (head === null) {
      console.log("Empty list");
      return undefined;
    }

    var currentNode = head;
    var prevNode = head;

    while(currentNode.next) {
      prevNode = currentNode;
      currentNode = currentNode.next;
    }

    var retValue = currentNode.element;
    prevNode.next = currentNode = null;
    --length;

    if (this.isEmpty()) {
      tail = head = null;
    } else {
      tail = prevNode;
    }

    return retValue;
  };

  this.print = function() {
    if (head === null) {
      console.log("Empty list");
      return;
    }

    var currentNode = head;

    while(currentNode) {
      console.log(currentNode);
      currentNode = currentNode.next;
    }
  };

}

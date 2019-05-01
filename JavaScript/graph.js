// Graphs: Breadth first search

function BFS(graph, root) {
  var nodesLen = {};

  for (var i = 0; i < graph.length; i++) {
    nodesLen[i] = Infinity;
  }

  nodesLen[root] = 0;
  var queue = [root];
  var current;

  while(queue.length != 0) {
    current = queue.shift();
    var curConnected = graph[current];
    var neighbourIdx = [];
    var idx = curConnected.indexOf(1);
    while(idx != -1) {
      neighbourIdx.push(idx);
      idx = curConnected.indexOf(1, idx+1);
    }

    for (var j = 0; j < neighbourIdx.length; j++) {
      if (nodesLen[neighbourIdx[j]] == Infinity) {
        nodesLen[neighbourIdx[j]] = nodesLen[current] + 1;
        queue.push(neighbourIdx[j]);
      }
    }
  }

  return nodesLen;
}

var bfsGraph = [
  [0, 1, 1, 1, 0],
  [0, 0, 1, 0, 0],
  [1, 1, 0, 0, 0],
  [0, 0, 0, 1, 0],
  [0, 1, 0, 0, 0]
];

console.log(BFS(bfsGraph, 1));

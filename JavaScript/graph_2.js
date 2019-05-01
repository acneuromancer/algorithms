class Graph {

    constructor(numVertices) {
        this.numVertices = numVertices;
        this.adjList = [];

        for (let i = 0; i < numVertices; i++) {
            this.adjList.push(new Array());
        }
    }

    addEdge(v, w) {
        if (v >= this.numVertices || v < 0 || w >= this.numVertices || w < 0) {
            return false;
        }
        this.adjList[v].push(w);
        return true;
    }

    getNumVertices() { 
        return this.numVertices;
    }
    
    getAdjList() {
        return this.adjList;
    }

    DFS(vertex, visited = []) {
        visited.push(vertex);

        for (var i = 0; i < this.adjList[vertex].length; i++) {
            var v = this.adjList[vertex][i];
            if (!visited.includes(v)) {
                this.DFS(v, visited);
            } 
        }

        return visited;
    }

}

let g = new Graph(4);
g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 2);
g.addEdge(2, 0);
g.addEdge(2, 3);
g.addEdge(3, 3);

console.log(g.getAdjList());
console.log(g.DFS(2));


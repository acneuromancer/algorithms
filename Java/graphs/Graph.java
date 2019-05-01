package algorithms.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int numVertices;
    private LinkedList<LinkedList<Integer>> adjList;

    Graph(int numVertices) {
        this.numVertices = numVertices;

        adjList = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new LinkedList<Integer>());
        }
    }

    public boolean addEdge(int v, int w) {
        if (v >= numVertices || v < 0 || w >= numVertices || w < 0) {
            return false;
        }
        adjList.get(v).add(w);
        return true;
    }

    public void printEdges() {
        int line = 0;

        Iterator<LinkedList<Integer>> iter = adjList.listIterator();
        while(iter.hasNext()) {
            System.out.println(line++ + " " + iter.next());
        }
    }

    public LinkedList<Integer> BFS(int start) {
        LinkedList<Integer> visited = new LinkedList<>();
        visited.add(start);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(queue.size() != 0) {
            int vertex = queue.poll();

            Iterator<Integer> iter = adjList.get(vertex).listIterator();
            while(iter.hasNext()) {
                int next = iter.next();
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return visited;
    }

    public LinkedList<Integer> DFS(int start) {
        LinkedList<Integer> visited = new LinkedList<>();
        return _DFS(start, visited);
    }

    private LinkedList<Integer> _DFS(int vertex, LinkedList<Integer> visited) {
        visited.add(vertex);

        Iterator<Integer> iter = adjList.get(vertex).listIterator();
        while(iter.hasNext()) {
            int next = iter.next();
            if (!visited.contains(next)) {
                _DFS(next, visited);
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printEdges();

        System.out.println(g.BFS(0));
        System.out.println(g.BFS(2));

        System.out.println(g.DFS(2));
    }

}

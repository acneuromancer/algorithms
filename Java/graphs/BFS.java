package algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private Queue<Integer> queue;

    public BFS() {
        this.queue = new LinkedList<Integer>();
    }

    public void bfs(int adjacency_matrix[][], int source) {
        int num_of_nodes = adjacency_matrix[source].length - 1;
        boolean[] visited = new boolean[num_of_nodes + 1];
        int i, element;

        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            element = queue.remove();
            i = element;
            System.out.println(i + " ");
            while (i <= num_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        final int[][] adjacency_matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        final int source = 1;

        new BFS().bfs(adjacency_matrix, source);
    }
    
}

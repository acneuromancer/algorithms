package algorithms.graphs;

import java.util.Stack;

public class DFS {

    private Stack<Integer> stack;

    public DFS() {
        stack = new Stack<Integer>();
    }

    public void dfs(int adjacency_matrix[][], int source) {
        int num_of_nodes = adjacency_matrix[source].length - 1;
        boolean visited[] = new boolean[num_of_nodes+1];
        int element = source;
        int i = source;
        System.out.println(element + " ");
        visited[source] = true;
        stack.push(source);

        while(!stack.isEmpty()) {
            element = stack.peek();
            i = element;
            while(i <= num_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    element = i;
                    i = 1;
                    System.out.println(element + " ");
                    continue;
                }
                i++;
            }
            stack.pop();
        }
    }

    public static void main(String[] args) {
        final int adjacency_matrix[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        final int source = 1;

        DFS dfs = new DFS();
        dfs.dfs(adjacency_matrix, source);
    }

}

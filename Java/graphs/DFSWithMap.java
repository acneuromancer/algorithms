package algorithms.graphs;

import java.util.*;

public class DFSWithMap {

    private List<Character> dfs(Map<Character, List<Character>> graph, Character vertex) {
        List<Character> path = new LinkedList<>();
        path = dfsRecursive(graph, vertex, path);
        return path;
    }

    private List<Character> dfsRecursive(Map<Character, List<Character>> graph, Character vertex, List<Character> path) {
        path.add(vertex);

        for (Character neighbour : graph.get(vertex)) {
            if (!path.contains(neighbour)) {
                path = dfsRecursive(graph, neighbour, path);
            }
        }

        return path;
    }


    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList(new Character[] {'B', 'C'}));
        graph.put('B', Arrays.asList(new Character[] {'A', 'D', 'E'}));
        graph.put('C', Arrays.asList(new Character[] {'A', 'F'}));
        graph.put('D', Arrays.asList(new Character[] {'B'}));
        graph.put('E', Arrays.asList(new Character[] {'B', 'F'}));
        graph.put('F', Arrays.asList(new Character[] {'C', 'E'}));

        DFSWithMap app = new DFSWithMap();

        List<Character> path = app.dfs(graph, 'A');

        System.out.println(path);
    }

}

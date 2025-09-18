package kr.co.oreb.algorithm.chapter05;

import java.util.Set;

public class DFS {

    public void dfs(int[][] graph, int vertex, Set<Integer> visited) {

        visited.add(vertex);

        System.out.print(vertex + " ");

        int[] adjacent = graph[vertex - 1];

        for (int node : adjacent) {

            if (!visited.contains(node)) {
                dfs(graph, node, visited);
            }

        }

    }

}

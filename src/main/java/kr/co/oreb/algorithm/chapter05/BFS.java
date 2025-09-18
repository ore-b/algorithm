package kr.co.oreb.algorithm.chapter05;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class BFS {

    public void bfs(int[][] graph, int vertex, HashSet<Integer> visited) {

        Queue<Integer> queue = new ArrayDeque<>();

        visited.add(vertex);
        queue.add(vertex);

        while (!queue.isEmpty()) {

            vertex = queue.poll();

            System.out.print(vertex + " ");

            int[] adjacent = graph[vertex - 1];

            for (int node : adjacent) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    queue.add(node);
                }
            }
        }

    }

}

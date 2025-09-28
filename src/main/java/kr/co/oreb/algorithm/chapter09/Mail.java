package kr.co.oreb.algorithm.chapter09;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import kr.co.oreb.algorithm.chapter09.dto.Edge;
import kr.co.oreb.algorithm.chapter09.dto.State;

public class Mail {

    public void execute() {

        int cityCount = 3;
        int edgeCount = 2;
        int start = 1;
        int inf = 100_000_000;

        //최단거리를 저장 할 배열
        int[] dist = new int[cityCount + 1];
        Arrays.fill(dist, inf);

        List<List<Edge>> graph = List.of(
            List.of(),
            List.of(new Edge(2, 4), new Edge(3, 2)),
            List.of(),
            List.of());

        //자기자신까지 거리는 0
        dist[start] = 0;

        //누적거리를 담을 큐(누적 거리가 짧은 state 가 우선)
        PriorityQueue<State> queue = new PriorityQueue<>();

        queue.add(new State(start, dist[start]));

        while (!queue.isEmpty()) {

            State cur = queue.poll();

            if (dist[cur.node] < cur.dist) {
                continue;
            }

            //현재 노드와 인접한 간선정보
            for (Edge edge : graph.get(cur.node)) {

                //edge.to 의 현재까지의 최단거리
                int best = dist[edge.to];

                //현재 노드의 누적거리 + edge 까지의 거리
                int newBest = dist[cur.node] + edge.weight;

                if (newBest < best) {
                    dist[edge.to] = newBest;
                    queue.add(new State(edge.to, newBest));
                }
            }

        }

        int resultCityCount = 0;
        int resultDist = inf;

        for (int i = 1; i < dist.length; i++) {

            if (i == start) {
                continue;
            }

            if (dist[i] < inf) {
                resultCityCount++;

                if (resultDist >= inf) {
                    resultDist = dist[i];
                } else {
                    resultDist = Math.max(resultDist, dist[i]);
                }


            }
        }

        System.out.println(resultCityCount);
        System.out.println(resultDist);

    }

}

package kr.co.oreb.algorithm.chapter09;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import kr.co.oreb.algorithm.chapter09.dto.Edge;
import kr.co.oreb.algorithm.chapter09.dto.State;

public class Dijkstra2 {

    private static final int INF = 100_000_000;

    public void execute(List<List<Edge>> graph, int start) {

        //최단거리를 저장할 배열
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, INF);

        //방문체크 할 배열
        boolean[] visited = new boolean[graph.size()];

        //시작 노드까지의 거리는 0
        dist[start] = 0;

        //우선순위큐(누적거리가 가장 작은 state 부터 뱉어낸다)
        PriorityQueue<State> queue = new PriorityQueue<>();

        //시작노드 간선정보
        queue.add(new State(start, 0));

        while (!queue.isEmpty()) {

            //간선 길이가 짧은 edge 가 우선
            State cur = queue.poll();

            //현재 노드 방문확인
            if (visited[cur.node]) {
                continue;
            }

            // 우선순위큐에 오래된(누적 거리 더 긴) 엔트리가 들어 있을 수 있으니 한 번 더 방어
            if (cur.dist > dist[cur.node]) {
                continue;
            }

            //현재 노드 방문체크
            visited[cur.node] = true;

            //현재 노드와 인접한 간선정보
            List<Edge> edges = graph.get(cur.node);

            for (Edge edge : edges) {

                //edge.node 의 현재까지의 최단거리
                int best = dist[edge.to];

                //현재 노드의 최단거리 + edge.cost 로 새로운 최단거리 구하기
                int newDist = dist[cur.node] + edge.getWeight();

                if (newDist < best) {
                    //새로운 최단거리가 best 보다 더 작다면
                    //dist 갱신
                    dist[edge.to] = newDist;
                    //다익스트라 알고리즘은 가중치가 0이상 이라서 (newDist < best) 인 경우, 경로는 더 작아질 수 없다
                    //때문에 (newDist < best) 경우에만 queue 에 담는다
                    queue.add(new State(edge.to, newDist));
                }


            }
        }

        System.out.println(Arrays.toString(dist));
    }

}

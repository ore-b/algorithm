package kr.co.oreb.algorithm.chapter09;

import java.util.Arrays;
import java.util.List;
import kr.co.oreb.algorithm.chapter09.dto.Edge;

public class Dijkstra {

    private static final int INF = 1_000_000_000;

    private int[] dist;

    private boolean[] visited;

    //노드 갯수
    private int n;


    public void execute(List<List<Edge>> graph, int start, int goal) {

        n = graph.size();
        dist = new int[graph.size()];
        visited = new boolean[graph.size()];
        Arrays.fill(dist, INF);

        dijkstra(graph, start, goal);

        System.out.println(Arrays.toString(dist));
    }

    private void dijkstra(List<List<Edge>> graph, int start, int goal) {

        //시작노드 초기화
        dist[start] = 0;
        visited[start] = true;

        for (Edge e : graph.get(start)) {
            //시작 노드와 인접한 노드들 거리 갱신
            dist[e.to] = Math.min(dist[e.to], e.weight);
        }

        // 남은 노드에 대해 최대 n-1번 반복
        for (int i = 1; i < n; i++) {

            //아직 방문하지 않는 노드들 중 가장 가까운 마을 고르기
            int now = getSmallestNode();
            if (now == -1) {
                break;
            }
            visited[now] = true;

            // now를 거쳐 다른 노드로 가는 비용 갱신
            for (Edge e : graph.get(now)) {

                if (visited[e.to]) {
                    continue;
                }

                //now 노드까지의 거리와 e 노드까지의 거리를 더한다
                int newDist = dist[now] + e.weight;

                if (newDist < dist[e.to]) {
                    //newDist 가 먼저 계산해 놓은 e 노드까지의 거리보다 가깝다면 갱신
                    dist[e.to] = newDist;
                }
            }
        }

    }

    // 방문하지 않은 노드 중 dist가 가장 작은 노드 인덱스 반환
    private int getSmallestNode() {

        //거리가 가장 짧은 노드
        int node = -1;
        //가장 짧은 거리
        int best = INF;

        for (int v = 1; v < n; v++) {

            if (!visited[v] && dist[v] < best) {
                //방문한 적이 없고, v노드까지의 거리가 현재 구해놓은 best 보다 더 짧을 경우
                best = dist[v];
                node = v;
            }
        }
        return node;
    }

}

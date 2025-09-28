package kr.co.oreb.algorithm.chapter09;

public class FloydWarshall {

    private static final int INF = 100_000_000;

    public void execute() {

        int n = 4;
        int m = 7;

        //노드 갯수만금 2차원 그래프 생성
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    //자기자신으로 가는 cost 는 0
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = INF;
                }

            }
        }

//        간선정보
        int[][] edges = {
            {1, 2, 4},
            {1, 4, 6},
            {2, 1, 3},
            {2, 3, 7},
            {3, 1, 5},
            {3, 4, 4},
            {4, 3, 2}
        };

//        int[][] edges = {
//            {1, 2, 10}, // a->b 직접
//            {1, 3, 3},  // a->c
//            {3, 4, 2},  // c->d
//            {4, 2, 4}   // d->b
//        };

        //간선정보로 인접한 노드 cost 입력
        for (int i = 0; i < edges.length; i++) {

            int[] edge = edges[i];

            int fromNode = edge[0];
            int toNode = edge[1];
            int cost = edge[2];
            graph[fromNode][toNode] = cost;

        }

        for (int edgeNode = 1; edgeNode <= n; edgeNode++) {
            //특정한 노드 edgeNode 를 거쳐가는 경우를 확인한다.
            //from->to 보다 from->edgeNode->to 로 가는 거리가 더 짧다면 갱신

            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    int best = graph[from][to];
                    int newCost = graph[from][edgeNode] + graph[edgeNode][to];

                    graph[from][to] = Math.min(best, newCost);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }


}

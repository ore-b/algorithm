package kr.co.oreb.algorithm.chapter09;

public class FutureCity {

    public void execute() {

        int n = 5;
        int m = 7;
        int inf = 100_000_000;

        int goal1 = 5;
        int goal2 = 4;

        //edge 정보
        int[][] edges = {
            {1, 2},
            {2, 1},
            {1, 3},
            {3, 1},
            {1, 4},
            {4, 1},
            {2, 4},
            {4, 2},
            {3, 4},
            {4, 3},
            {3, 5},
            {5, 3},
            {4, 5},
            {5, 4},
        };

        int[][] graph = new int[n + 1][n + 1];

        //데이터 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if (i == j) {
                    //자기자신으로 가는 거리는 0
                    graph[i][j] = 0;
                } else {
                    //다른 노드로가는 거리는 무조건 1
                    graph[i][j] = inf;
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            graph[from][to] = 1;
        }

        for (int edgeNode = 1; edgeNode <= n; edgeNode++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {

                    int best = graph[from][to];
                    int newCost = graph[from][edgeNode] + graph[edgeNode][to];

                    //최단거리 갱신
                    graph[from][to] = Math.min(best, newCost);
                }
            }
        }

        int result = graph[1][goal1] + graph[goal1][goal2];

        if (result > inf) {
            result = -1;
        }

        System.out.println(result);

    }

}


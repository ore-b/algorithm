package kr.co.oreb.algorithm.chapter09;

import java.util.List;
import kr.co.oreb.algorithm.chapter09.Dijkstra.Edge;
import org.junit.jupiter.api.Test;

public class Chapter09Test {

    @Test
    void dijkstraTest() {
        Dijkstra dijkstra = new Dijkstra();

        List<List<Edge>> graph = List.of(
            List.of(),
            List.of(new Edge(2, 2), new Edge(3, 5), new Edge(4, 1)),//1번노드
            List.of(new Edge(2, 3), new Edge(4, 2)),//2번노드
            List.of(new Edge(2, 3), new Edge(6, 5)),//3번노드
            List.of(new Edge(3, 3), new Edge(5, 1)),//4번노드
            List.of(new Edge(3, 1), new Edge(6, 2)),//5번노드
            List.of()//6번노드
        );

        dijkstra.execute(graph, 1, 6);
    }

}

package kr.co.oreb.algorithm.chapter09;

import java.util.List;
import kr.co.oreb.algorithm.chapter09.dto.Edge;
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

    @Test
    void dijkstraTest2() {
        Dijkstra2 dijkstra = new Dijkstra2();

        List<List<Edge>> graph = List.of(
            List.of(),
            List.of(new Edge(2, 2), new Edge(3, 5), new Edge(4, 1)),//1번노드
            List.of(new Edge(2, 3), new Edge(4, 2)),//2번노드
            List.of(new Edge(2, 3), new Edge(6, 5)),//3번노드
            List.of(new Edge(3, 3), new Edge(5, 1)),//4번노드
            List.of(new Edge(3, 1), new Edge(6, 2)),//5번노드
            List.of()//6번노드
        );

        dijkstra.execute(graph, 1);
    }

    @Test
    void floydWarshallTest() {
        FloydWarshall fw = new FloydWarshall();
        fw.execute();
    }

    @Test
    void futureCity() {
        FutureCity f = new FutureCity();
        f.execute();
    }

    @Test
    void mail() {
        Mail mail = new Mail();
        mail.execute();
    }

}

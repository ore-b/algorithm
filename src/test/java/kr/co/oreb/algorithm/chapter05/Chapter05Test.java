package kr.co.oreb.algorithm.chapter05;

import java.util.HashSet;
import org.junit.jupiter.api.Test;

public class Chapter05Test {

    //인접 리스트
    private static final int[][] GRAPH =
        {
            {2, 3, 8},//1번 노드
            {1, 7},//2번노드
            {1, 4, 5},//3번노드
            {3, 5},//4번노드
            {3, 4},//5번노드
            {7},//6번노드
            {2, 6, 8},//7번노드
            {1, 7},//8번노드
        };

    @Test
    public void dfsTest() {

        DFS dfs = new DFS();

        dfs.dfs(GRAPH, 1, new HashSet<>());
    }

    @Test
    public void bfsTest() {
        BFS bfs = new BFS();
        bfs.bfs(GRAPH, 1, new HashSet<>());
    }

}

package kr.co.oreb.algorithm.chapter05;

import java.util.ArrayDeque;
import java.util.Queue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Maze {

    //상,하,좌,우 순서
    private static final int[] DIRECTION_ROW = {-1, 1, 0, 0};
    private static final int[] DIRECTION_COLUMN = {0, 0, -1, 1};

    private static final int MONSTER = 0;
    private static final int EMPTY = 1;

    public void execute(int[][] board, int n, int m) {

        Queue<Node> queue = new ArrayDeque<>();

        //최초 시작점을 Queue 에 넣기
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {

            //현재 위치의 node 꺼내기
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                //상하좌우 순회하기

                int nr = node.getRow() + DIRECTION_ROW[i];
                int nc = node.getColumn() + DIRECTION_COLUMN[i];

                if (!isIn(nr, nc, n, m)) {
                    //맵 밖인경우
                    continue;
                }

                if (board[nr][nc] == MONSTER) {
                    //몬스터인 경우
                    continue;
                }

                if (board[nr][nc] == EMPTY) {
                    //갈 수 있는 경우, 현재의 위치보다 +1 시켜서 저장
                    board[nr][nc] = board[node.row][node.column] + 1;
                    //방문 가능한 위치에서 탐색하도록 queue 에 넣기
                    queue.add(new Node(nr, nc));
                }
            }
        }

        int goal = board[n - 1][m - 1];

        System.out.println(goal);
    }

    private boolean isIn(int row, int column, int n, int m) {
        if (row < 0) {
            return false;
        }

        if (n <= row) {
            return false;
        }

        if (column < 0) {
            return false;
        }

        if (m <= column) {
            return false;
        }

        return true;
    }


    @Getter
    @RequiredArgsConstructor
    private static class Node {

        private final int row;

        private final int column;

    }

}

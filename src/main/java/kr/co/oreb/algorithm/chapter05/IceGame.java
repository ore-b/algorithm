package kr.co.oreb.algorithm.chapter05;

public class IceGame {

    public void execute(int[][] board, int n, int m) {

        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int colunm = 0; colunm < m; colunm++) {
                if (board[row][colunm] == 0) {
                    //음료수 넣을 공간을 찾았다, count 올리고 해당칸 모두 채우기
                    count++;
                    dfs(board, row, colunm, n, m);

                }
            }
        }

        System.out.println(count);
    }

    private void dfs(int[][] board, int row, int column, int n, int m) {

        if (!isIn(row, column, n, m)) {
            return;
        }

        if (board[row][column] == 1) {
            return;
        }

        board[row][column] = 1;//방문체크

        dfs(board, row - 1, column, n, m);
        dfs(board, row + 1, column, n, m);
        dfs(board, row, column - 1, n, m);
        dfs(board, row, column + 1, n, m);

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

}

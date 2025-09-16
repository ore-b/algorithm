package kr.co.oreb.algorithm.chapter04;

public class GameDev {

    private final static int LAND = 0;
    private final static int SEA = 1;

    private final static int[] DIRECTION_X = {-1, 0, 1, 0};
    private final static int[] DIRECTION_Y = {0, 1, 0, -1};

    public void execute(int n, int m, int x, int y, int direction, int[][] map) {

        boolean[][] visited = new boolean[n][m];
        //현재위치 방문체크
        visited[x][y] = true;
        int visitedCount = 1;

        int turnCount = 0;

        while (true) {

            //왼쪽으로 turn
            direction = turnLeft(direction);

            //이동 후 위치 get
            int nextX = x + DIRECTION_X[direction];
            int nextY = y + DIRECTION_Y[direction];

            if (isIn(nextX, nextY, n, m) && !visited[nextX][nextY] && map[nextX][nextY] == LAND) {
                //방문가능
                x = nextX;
                y = nextY;
                visited[x][y] = true;
                turnCount = 0;
                visitedCount++;
            } else {
                //방문할 곳이 없다면
                turnCount++;
            }

            if (turnCount == 4) {
                //더이상 방문할 곳이 없다면 뒤로 한칸
                //방향은 틀지 않고 뒤로만 이동 -
                int backX = x - DIRECTION_X[direction];
                int backY = y - DIRECTION_Y[direction];

                //바다만 아니면 가능(방문체크 x)
                if (isIn(backX, backY, n, m) && map[backX][backY] == LAND) {
                    //방문가능
                    x = backX;
                    y = backY;
                    visited[x][y] = true;
                    turnCount = 0;

                    //visitedCount++; 뒤로 이동한건 온길을 되돌아 가는거라 방문 ++ 안함
                } else {
                    break;
                }
            }

        }

        System.out.println(visitedCount);

    }

    private int turnLeft(int d) {
        return (d + 3) % 4;
    }

    private int turnBack(int d) {
        return (d + 2) % 4;
    }

    private boolean isIn(int x, int y, int n, int m) {

        if (x < 0) {
            return false;
        }

        if (n <= x) {
            return false;
        }

        if (y < 0) {
            return false;
        }

        if (m <= y) {
            return false;
        }

        return true;

    }

}

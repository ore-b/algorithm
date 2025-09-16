package kr.co.oreb.algorithm.chapter04;

public class NightMove {

    private final int[][] steps = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public void execute(String xy) {

        int x = xy.charAt(0) - 'a' + 1;
        int y = xy.charAt(1) - '1' + 1;

        int count = 0;

        for (int i = 0; i < steps.length; i++) {
            int tmpX = x + steps[i][0];
            int tmpY = y + steps[i][1];

            if (!isMoveable(tmpX, tmpY)) {
                continue;
            }
            count++;
        }

        System.out.println(count);

    }

    private boolean isMoveable(int x, int y) {

        if (x <= 0) {
            return false;
        }

        if (8 < x) {
            return false;
        }

        if (y <= 0) {
            return false;
        }

        if (8 < y) {
            return false;
        }

        return true;

    }

}

package kr.co.oreb.algorithm.chapter04;

import java.util.HashMap;
import java.util.Map;

public class MoveGame {

    private final Map<Character, int[]> moveCommandMap;

    public MoveGame() {
        moveCommandMap = new HashMap<>();
        moveCommandMap.put('L', new int[]{0, -1});
        moveCommandMap.put('R', new int[]{0, 1});
        moveCommandMap.put('U', new int[]{-1, 0});
        moveCommandMap.put('D', new int[]{1, 0});
    }

    public void execute(int n, char[] plan) {

        int x = 1;
        int y = 1;

        for (int i = 0; i < plan.length; i++) {

            int[] command = moveCommandMap.get(plan[i]);

            int tmpX = x + command[0];
            int tmpY = y + command[1];

            if (!isMoveable(tmpX, tmpY, n)) {
                continue;
            }

            x = tmpX;
            y = tmpY;

        }

        System.out.println(x + " " + y);

    }

    private boolean isMoveable(int x, int y, int n) {

        if (x < 1) {
            return false;
        }

        if (n < x) {
            return false;
        }

        if (y < 1) {
            return false;
        }

        if (n < y) {
            return false;
        }

        return true;
    }

}

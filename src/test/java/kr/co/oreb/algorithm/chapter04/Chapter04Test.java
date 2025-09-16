package kr.co.oreb.algorithm.chapter04;

import org.junit.jupiter.api.Test;

public class Chapter04Test {


    @Test
    public void moveTest() {
        MoveGame moveGame = new MoveGame();

        char[] plan = {'R', 'R', 'R', 'U', 'D', 'D'};

        moveGame.execute(5, plan);
    }


    @Test
    void timeCheckTest() {
        TimeCheck timeCheck = new TimeCheck();

        timeCheck.execute(5);
    }

    @Test
    void nightMoveTest() {
        NightMove nightMove = new NightMove();

        nightMove.execute("a1");
        nightMove.execute("c2");
        nightMove.execute("d4");
        nightMove.execute("h8");

    }

    @Test
    void gameDevTest() {
        GameDev gameDev = new GameDev();

        int[][] map =
            {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
            };

        gameDev.execute(4, 4, 1, 1, 0, map);
    }
}

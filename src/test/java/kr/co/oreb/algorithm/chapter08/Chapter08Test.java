package kr.co.oreb.algorithm.chapter08;

import org.junit.jupiter.api.Test;

public class Chapter08Test {

    @Test
    void fibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.execute(4);
    }

    @Test
    void fibonacciWithMemo() {
        FibonacciWithMemo fibonacci = new FibonacciWithMemo();
        fibonacci.execute(6);
    }


    @Test
    void toOne() {
        ToOne toOne = new ToOne();
        toOne.execute(10);
    }

    @Test
    void antTest() {
        Ant ant = new Ant();
        int[] foods = {1, 3, 1, 5};
        ant.execute(4, foods);
    }

    @Test
    void tileTest() {
        Tile tile = new Tile();

        tile.execute(5);
    }

    @Test
    void CoinTest() {
        Coin c = new Coin();
        int[] coins = {2, 3};
        c.execute(coins, 15);
    }

}


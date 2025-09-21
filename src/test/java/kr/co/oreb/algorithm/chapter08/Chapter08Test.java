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

}


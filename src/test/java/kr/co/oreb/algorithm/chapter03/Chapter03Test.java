package kr.co.oreb.algorithm.chapter03;

import org.junit.jupiter.api.Test;


public class Chapter03Test {

    @Test
    public void bigNumber() {

        BigNumber bigNumber = new BigNumber();

        int[] array = {3, 4, 3, 4};

        bigNumber.process(array, 5, 3);

    }

    @Test
    public void forOne() {

        ForOne forOne = new ForOne();

        forOne.execute(100, 3);

    }

    @Test
    public void forOne2() {

        ForOne forOne = new ForOne();

        forOne.execute2(100, 3);

    }


}

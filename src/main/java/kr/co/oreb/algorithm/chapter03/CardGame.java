package kr.co.oreb.algorithm.chapter03;

import java.util.Arrays;

public class CardGame {

    public void execute(int[][] nm) {

        int bigN = 0;

        int bigNumber = 0;

        for (int i = 0; i < nm.length; i++) {

            int[] n = nm[i];

            Arrays.sort(n);

            int smallNumber = n[0];

            if (bigNumber < smallNumber) {
                bigNumber = smallNumber;
                bigN = i;
            }

        }

        System.out.println("bigN = " + bigN);

    }

}

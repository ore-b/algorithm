package kr.co.oreb.algorithm.chapter07;

import kr.co.oreb.algorithm.Description;

@Description("순차 검색")
public class SequentialSearch {

    public void execute() {

        String target = "E";

        String[] array = {"A", "B", "C", "D", "E"};

        int targetIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                targetIndex = i;
                break;
            }
        }

        System.out.println(targetIndex);
    }

}

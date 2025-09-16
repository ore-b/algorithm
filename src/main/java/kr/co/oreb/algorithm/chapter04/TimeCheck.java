package kr.co.oreb.algorithm.chapter04;

public class TimeCheck {

    private static final char TARGET_NUMBER_CHAR = '3';

    public void execute(int targetHour) {

        int count = 0;

        for (int h = 0; h <= targetHour; h++) {//시간
            for (int m = 0; m < 60; m++) {//분
                for (int s = 0; s < 60; s++) {//초
                    String sTime = String.format("%02d%02d%02d", h, m, s);

                    if (0 <= sTime.indexOf(TARGET_NUMBER_CHAR)) {
                        count++;
                    }

                }
            }
        }

        System.out.println(count);

    }

}

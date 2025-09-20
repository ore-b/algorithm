package kr.co.oreb.algorithm.chapter06.problems;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class StudentSort {

    //점수가 낮은 학생이 먼저 출력 되도록
    public void execute(Student[] students) {

        //선택정렬
//        selectionSort(students);
        //삽입정렬
//        insertionSort(students);

        //계수정렬
//        countSort(students);

        //퀵정렬
        quickSort(students, 0, students.length - 1);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    //가장 작은 값을 '선택'한다
    private void selectionSort(Student[] students) {

        for (int i = 0; i < students.length; i++) {

            for (int j = i + 1; j < students.length; j++) {

                if (students[j].getScore() < students[i].getScore()) {
                    //점수 낮은 학생 발견, swap
                    Student temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }
        }
    }

    //index 1 부터 시작해서 왼쪽 값들과 비교해서 자신보다 크면 오른쪽으로 밀어버린다
    private void insertionSort(Student[] students) {

        for (int i = 1; i < students.length; i++) {

            Student target = students[i];

            int j;

            for (j = i - 1; j >= 0; j--) {

                if (target.getScore() < students[j].getScore()) {
                    //target의 점수보다 왼쪽 학생의 점수가 높다면 오른쪽으로 밀어버린다
                    students[j + 1] = students[j];
                } else {
                    //점수가 작다면 해당자리에 loop 종료
                    break;
                }
            }

            //본인자리 삽입
            students[j + 1] = target;

        }
    }

    private void countSort(Student[] students) {

        List<List<Student>> buckets = new ArrayList<>();

        for (int i = 0; i < 100 + 1; i++) {
            //버킷 생성
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < students.length; i++) {
            //점수에 맞는 list 학생 담기
            buckets.get(students[i].getScore()).add(students[i]);
        }

        int idx = 0;

        for (int score = 0; score < 100; score++) {

            List<Student> students1 = buckets.get(score);

            for (Student student : students1) {
                //0 부터 100 점까지 순서대로 학생 담기
                students[idx++] = student;
            }
        }
    }

    private void quickSort(Student[] students, int start, int end) {

        if (start >= end) {
            //교차했다면 return;
            return;
        }

        int midPointer = start + (end - start) / 2;

        Student pivot = students[midPointer];

        int lPointer = start;

        int rPointer = end;

        //포인터가 교차할때까지 반복
        while (lPointer <= rPointer) {

            //왼쪽에는 pivot 학생보다 점수가 높은 학생이 있으면 안된다. pivot 보다 큰 점수를 가진 학생을 찾을때까지 반복
            while (students[lPointer].getScore() < pivot.getScore()) {
                lPointer++;
            }

            //오른쪽에는 pivot 학생보다 점수가 낮은 학생이 있으면 안된다. pivot 보다 낮은 점수를 가진 학생을 찾을 때까지 반복
            while (pivot.getScore() < students[rPointer].getScore()) {
                rPointer--;
            }

            if (lPointer <= rPointer) {
                //왼쪽 오른쪽 각각 타겟을 찾았다면 swap
                Student tmp = students[lPointer];
                students[lPointer] = students[rPointer];
                students[rPointer] = tmp;
                //해당 pointer 정렬완료로 ++,--
                lPointer++;
                rPointer--;
            }

        }

        //파티션 나누기
        quickSort(students, start, rPointer);
        quickSort(students, lPointer, end);

    }

    @Getter
    @RequiredArgsConstructor
    public static class Student {

        private final String name;

        private final int score;

        public String toString() {
            return name + ", " + score;
        }
    }
}

package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class SelectionSort {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 단순 선택 정렬(배열과 배열의 크기를 인자로 받음)
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            // 배열의 크기만큼 반복하며,
            // i회차마다 i번째로 작은 요소를 min 에 대입
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
                // 현재 가리키는 요소인 i 와
                // min 값을 교체
                // (min 은 inner for문이 반복될 동안 불변일 수 있음)
                swap(a, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++){
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }


}

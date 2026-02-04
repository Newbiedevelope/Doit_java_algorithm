package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class BubbleSort {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬(배열과 배열의 크기를 인자로 받음)
    static void bubbleSort(int[] a, int n) {
        // 배열의 크기 - 1 만큼 반복
        for (int i=0; i<n-1; i++)
            // 배열의 마지막에서부터 2번째 요소로 시작하여
            // 배열의 첫 번째 요소까지 순환하며 크기 검증 및 위치 변경
            for (int j=n-1; j>i; j--)
                if (a[j-1] > a[j])
                    swap(a, j - 1, j);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전1)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++){
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }


}

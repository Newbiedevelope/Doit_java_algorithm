package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class CountingSort {

    // 도수 정렬 메서드(배열과 0이상 max 이하의 값을 입력)
    static void countingSort(int[] a, int n, int max) {
        int[] f = new int[max + 1]; // 누적 도수
        int[] b = new int[n];       // 작업용 배열

        for (int i = 0; i < n; i ++)    // 1단계 : 도수분포표 만들기
            f[a[i]]++;
        for (int i = 1; i <= max; i++)  // 2단계 : 누적도수분포표 만들기
            f[i] += f[i - 1];
        for (int i = n - 1; i >= 0; i--)    // 3단계 : 목표 배열 만들기
            b[--f[a[i]]] = a[i];
        for (int i = 0; i < n; i++)     // 4단계 : 배열 복사하기
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] > max)
                max = x[i];

        countingSort(x, nx, max);

        System.out.println("오름차순 정렬");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}

package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class ShellSort2 {
    // 쉘 정렬 버전 2(배열과 배열의 크기를 인자로 받음)
    static void shellSort(int[] a, int n) {
        int h;
        // 정수형 변수 h 의 값을 초기화 하는 반복문
        for (h = 1; h < n; h = h * 3 + 1)
            ;
        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("쉘 정렬(버전2)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++){
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        shellSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }


}

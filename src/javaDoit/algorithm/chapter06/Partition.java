package javaDoit.algorithm.chapter06;

import java.util.Scanner;

public class Partition {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    
    // 배열 나누기 - 배열과 배열의 크기 n을 인자로 입력받음
    // (퀵 정렬은 배열에서 기준값을 하나 정하고, 
    // 그 기준값으로 좌우 정렬을 수행하며 이 과정을 반복한다.
    // 그래서 기준값을 통해 배열을 나누는 메서드를 정의하여
    // 퀵 정렬의 원리를 이해한다.)
    static void partition(int[]a, int n){
        int pl = 0;
        int pr = n-1;
        int x = a[n / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        System.out.println("피벗값은 " + x + "입니다.");

        System.out.println("피벗 이하의 그룹");
        for (int i=0; i <= pl -1; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗과 같은 그룹");
            for (int i = pr + 1; i <= pl - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for (int i = pr + 1; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열을 나눕니다.");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }
        partition(x, nx);
    }
}

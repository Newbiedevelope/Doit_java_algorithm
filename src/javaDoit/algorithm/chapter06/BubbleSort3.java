package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class BubbleSort3 {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬(배열과 배열의 크기를 인자로 받음)
    static void bubbleSort(int[] a, int n) {
        int k = 0;
        // k(인덱스)가 n(배열의 크기)-1(배열의 마지막 인덱스)보다 1 작을 때까지
        while (k < n - 1) {
            // 교체가 일어난 마지막 인덱스를 저장할 변수 last
            int last = n - 1;
            // 마지막 요소부터 접근하여, 이전 반복회차에서 
            // 마지막으로 교체된 요소까지 반복
            for (int j = n-1; j > k; j--)
                if (a[j - 1] > a[j]){
                    swap(a, j - 1, j);
                    last = j;
                }
            k = last;
            // 마지막으로 교체된 요소의 인덱스를 저장하고
            // 한계값으로 설정함에 따라
            // 이미 정렬이 완료된 낮은 인덱스까지 검증을 할 필요가 없다.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전3)");
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

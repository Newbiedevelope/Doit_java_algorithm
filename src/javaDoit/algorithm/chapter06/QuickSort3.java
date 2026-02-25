package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class QuickSort3 {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // x[a], x[b], x[c] 를 정렬 및 가운데 값의 인덱스를 반환
    static int sort3elem(int[] x, int a, int b, int c){
        if (x[b] < x[a]) swap(x, b, a);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);
        return b;
    }
    
    // 퀵 정렬3
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        // 시작, 끝, 가운데 요소를 정렬
        int m = sort3elem(a, pl, (pl + pr) / 2, pr);
        // 정렬된 가운데 요소를 피벗으로 지정
        int x = a[m];

        // median-of-three pivot selection 과정을 끝마쳤으므로
        // pl, pr 은 이미 정렬된 상태이다.
        // 이 때 pl+1 ~ pr-1 까지의 재분할을 하기 위해
        // m 과 pr-1의 위치를 바꾼 후, pl 값과 pr 값을 조정한다.
        swap(a, m, right - 1);
        pl++;
        pr -= 2;

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl, right);

    }//close quickSort

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬3");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i=0; i<nx; i++){
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        quickSort(x, 0, nx-1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i=0; i<nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }


}

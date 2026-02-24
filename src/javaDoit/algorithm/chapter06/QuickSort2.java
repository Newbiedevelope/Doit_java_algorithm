package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class QuickSort2 {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬2(재귀호출 없앤 버전)
    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        // 재귀호출을 없애기 위한 메서드 내 반복문
        while (!lstack.isEmpty()){
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(pl + pr) / 2];

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                // 피벗 기준 왼쪽 그룹의 범위를 저장
                // (인덱스를 저장)
                lstack.push(left);
                rstack.push(pr);
            }
            
            if (pl < right) {
                // 피벗 기준 오른쪽 그룹의 범위를 저장
                // (인덱스를 저장)
                lstack.push(pl);
                rstack.push(right);
            }
            
        }//close while
    }//close quickSort

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬2(재귀호출 제거)");
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

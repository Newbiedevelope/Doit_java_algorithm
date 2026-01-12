package javaDoit.algorithm.chapter03;

import java.util.Scanner;

public class BinSearch {

    static int binSearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                return pc;
            else if (a[pc] > key)
                pl = pc + 1;
            else
                pr = pc -1;
        } while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        // 이진 탐색은 배열이 꼭 정렬되어있어야 하므로
        // 입력 방식을 지정해주고, 컨트롤 하기 위한 수식
        for (int i=1; i<num; i++){
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);

        if (idx == -1)
            System.out.println("해당값의 요소가 존재하지 않습니다.");
        else
            System.out.println("해당 값은 x[" + idx + "] 에 위치해있습니다.");
    }
}

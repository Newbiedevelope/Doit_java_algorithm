package javaDoit.algorithm.chapter03;

import java.util.Scanner;

public class SeqSearch {

    static int seqSearch(int[] a, int n, int key){
        int i = 0;

        // 무한 루프 구현
        while (true){
            // i 값이 증가해서 a 배열의 index 범위를 벗어나면
            if(i == n)
                return -1;  // -1을 반환
            // a배열의 i번째 인덱스에서 원하는 값을 찾으면
            if (a[i] == key)
                return i;   // 해당 인덱스를 반환
            i++;    // 루프를 한 번 돌 때 마다 i 값 증가
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i=0; i<num; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }

}

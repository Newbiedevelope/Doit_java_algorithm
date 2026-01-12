package javaDoit.algorithm.chapter03;

import java.util.Scanner;

public class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;

        // 아래 반복문을 빠져나오기 위해 배열 끝 인덱스에 값 삽입
        a[n] = key;

        // 배열을 순회하며 키와 대조(찾는 값이 존재하면 stop
        while (a[i] != key) {
            i++;
        }
        
        // 3항 연산자, 만약 i(인덱스)가 n(배열의 길이)과 같다면
        // 원본 배열에는 찾는 key 값의 요소가 존재하지 않으므로 -1 반환
        // i(인덱스)가 n(배열의 길이)를 넘지 않았다면
        // a 배열의 i 번째에 key 값이 존재하므로 i(인덱스)를 반환
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i=0; i<num; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky);

        if (idx == -1)
            System.out.println("찾는 값에 해당하는 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "] 에 있습니다.");
    }
}

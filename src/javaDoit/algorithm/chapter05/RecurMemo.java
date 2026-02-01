package javaDoit.algorithm.chapter05;

import java.util.Scanner;

class RecurMemo {

    static String[] memo;

    // 메모화를 통해 기존 재귀함수가 똑같은 연산을 반복하던 것을
    // 특정값에 대한 연산을 저장해둠으로써 반복 연산 방지
    static void recur(int n){
        // 만약 이미 실행한 적 있는 정수 N에 대한 연산이라면
        if (memo[n + 1] != null)
            System.out.print(memo[n + 1]);  // 해당 값으로 계산한 뒤 저장한 결과 출력
        else {
            if (n > 0) {
                recur(n - 1);


                System.out.println(n);
                recur(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n-1];
            } else {
                memo[n + 1] = "";
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        memo = new String[x + 2];
        recur(x);
    }

}

package javaDoit.algorithm.chapter05;

import java.util.Scanner;

class Hanoi {
    
    // no 는 원반 개수, x 는 시작 기둥, y 는 목표기둥
    static void move(int no, int x, int y){
        // 가장 작은 값부터 시작 기둥에서 이동
        if (no > 1)
            move(no-1, x, 6-x-y);

        System.out.printf("원반[%d]을(를) %d번 기둥에서 %d번 기둥으로 옮김\n"
            , no, x, y);

        // 특정 원반을 옮기고 난 후 자신보다 1 작은 원반을 재배치
        if (no > 1)
            move(no-1, 6-x-y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}

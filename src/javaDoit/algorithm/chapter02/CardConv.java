package javaDoit.algorithm.chapter02;

import java.util.Scanner;

public class CardConv {
    static int cardConv(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        // 이 for 문은 사실상 최대 한 번 도는 거네
        // 셔플 개념으로 앞 뒤 자리를 바꾸기 위해서
        for (int i=0; i<digits/2; i++){
            char t = d[i];
            d[i] = d[digits - i - 1];
            d[digits - i - 1] = t;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        int dno;
        int retry;
        char[] cno = new char[2];

        System.out.println("10진수를 기수변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환 (2~36) : ");
                cd = stdIn.nextInt();
            } while (cd < 2 || cd > 36);

            // dno 는 그냥 반복문을 돌리기 위한 부수적인 변수
            dno = cardConv(no, cd, cno);

            System.out.print(cd + "진수로");
            for (int i=0; i<dno; i++)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 (예 : 1 / 아니오 : 2) : ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}

package javaDoit.algorithm.chapter01;

import java.util.Scanner;

public class Spira {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삼각형의 층을 입력하세요: ");
        spira(sc.nextInt());
    }

    static void spira(int n){
        String star = "*";
        for (int i=1; i<=n; i++)
            System.out.println(" ".repeat(n - i)
                    + star.repeat(((i-1)*2)+1));
    }
}

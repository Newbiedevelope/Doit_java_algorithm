package javaDoit.algorithm.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class StringBinarySearch {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        String[] x = {
                "abstract", "assert", "boolean", "break"
                , "byte", "case", "catch", "char", "class"
                , "default", "for", "goto", "if", "long"
                , "native", "package", "return", "short"
                , "this", "void", "while"
        };

        System.out.print("원하는 키워드를 입력하세요 : ");
        String ky = stdIn.next();

        int idx = Arrays.binarySearch(x, ky);

        if (idx < 0)
            System.out.println("해당 키워드가 존재하지 않습니다.");
        else
            System.out.println("해당 키워드는 x[" + idx + "]에 있습니다.");
    }
}

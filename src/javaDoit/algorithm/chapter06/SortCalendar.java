package javaDoit.algorithm.chapter06;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SortCalendar {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2022, Calendar.NOVEMBER, 1)
                , new GregorianCalendar(1963, Calendar.OCTOBER, 18)
                , new GregorianCalendar(1985, Calendar.APRIL, 5)
        };

        // Arrays 클래스의 sort 메서드를 통해 
        // GregorianCalendar 배열을 정렬
        Arrays.sort(x);

        for (GregorianCalendar gc : x) {
            System.out.printf("%04d년 %02d월 %02d일\n"
                , gc.get(Calendar.YEAR)
                , gc.get(Calendar.MONTH) + 1
                , gc.get(Calendar.DATE));
        }
        // Calendar 를 표방하는 클래스들은 MONTH 속성을
        // 마치 인덱스처럼 0~11 로 관리한다.
        // 해서 Calendar 클래스에 MONTH 값을 대입할 때에는 (-1)
        // 값을 꺼내올 때는 (+1) 하여 사용해야 한다.
    }
}

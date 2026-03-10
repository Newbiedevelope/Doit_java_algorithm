package javaDoit.algorithm.chapter06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {

    // 신체검사 결과를 담아둘 데이터 클래스
    static class PhyscData{
        String name;
        int height;
        double vision;
        
        // 생성자(사용자 정의) -> 기본 생성자는 제공 X
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // 객체의 정보(신체검사 결과)를 출력하는 메서드
        public String toString() {
            return name + " " + height + " " + vision;
        }

        // 오름차순 정렬용 comparator
        static final Comparator<PhyscData> HEIGHT_ORDER
                = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return Integer.compare(d1.height, d2.height);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강감찬", 178, 1.5)
                , new PhyscData("이순신", 181, 1.8)
                , new PhyscData("이성계", 188, 1.0)
                , new PhyscData("이도", 177, 0.1)
                , new PhyscData("왕건", 175, 2.0)
                , new PhyscData("아서", 178, 1.3)
                , new PhyscData("쿠빌라이", 190, 4.0)
                , new PhyscData("잔다르크", 167, 1.2)
        };

        Arrays.sort(x, PhyscData.HEIGHT_ORDER);

        System.out.println("신체검사 리스트");
        System.out.printf("%-8s%3s%5s", "이름", "신장", "시력");
        for (PhyscData pd : x)
            System.out.printf("%-8s%3d%5.1f\n", pd.name, pd.height, pd.vision);
    }

}

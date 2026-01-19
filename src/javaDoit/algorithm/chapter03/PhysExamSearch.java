package javaDoit.algorithm.chapter03;

import javaDoit.algorithm.chapter02.PhysicalExamination;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {
    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString(){
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        public static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3)
                , new PhyscData("김찬우", 173, 0.7)
                , new PhyscData("박준서", 175, 2.0)
                , new PhyscData("유서범", 171, 1.5)
                , new PhyscData("이수연", 168, 0.4)
                , new PhyscData("장경오", 174, 1.2)
                , new PhyscData("황지안", 169, 0.8)
        };

        System.out.print("키가 몇 cm인 사람을 찾고 있습니까? : ");
        int height = stdIn.nextInt();
        int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);

        if (idx < 0)
            System.out.println("그 값의 요소가 없습니다.");
        else System.out.println("그 값은 x[" + idx + "]에 있습니다.\nx[" + idx + "] : " + x[idx]);
    }
}

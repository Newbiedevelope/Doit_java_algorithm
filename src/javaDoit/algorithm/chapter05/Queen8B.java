package javaDoit.algorithm.chapter05;

class Queen8B {

    static boolean[] flag = new boolean[8];
    static int[] pos = new int[8];

    static void print(){
        for (int i=0; i<8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸 배치하기
    static void set(int i){
        for (int j=0; j<8; j++){
            if (!flag[j])
                pos[i] = j;
            if (i==7)
                print();
            else {
                flag[j] = true;
                set(i + 1);
                flag[j] = false;
            }

        }
    }

}

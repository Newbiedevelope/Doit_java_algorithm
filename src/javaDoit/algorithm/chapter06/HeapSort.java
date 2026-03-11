package javaDoit.algorithm.chapter06;

import java.util.Scanner;

class HeapSort {
    //a 배열의 idx1번째 요소와 idx2번째 요소를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // a[left] ~ a[right] 를 힙으로 변환
    // 부모가 자식보다 작으면 아래로(물리적으로는 뒷 인덱스로)
    // 옮겨서 힙 구조를 만드는 메서드
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left]; // 루트
        // 힙을 만들며 자식들이 부모 위치로 올라오기 때문에 루트 값을 따로 저장
        int child;          // 큰 값을 갖는 자식
        int parent;         // 부모

        // 부모가 말단(leaf) 노드가 아닐 때 까지 반복
        // 한 번 실행 후에 temp(부모)를 내려가며(자식으로 재지정) 계속 탐색
        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;    // 왼쪽 자식
            int cr = cl + 1;            // 오른쪽 자식
            // 오른쪽 자식이 마지막 노드(인덱스) 이하이면서 동시에
            // 오른족 자식이 왼쪽 자식보다 크다면, child 는 cr, 아니면 cl
            // 이유는 자식이 부모보다 클 경우, 둘 중 더 큰 값이 부모가 되어야 하기 때문
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            // 부모가 자식보다 크다면 -> 이미 힙이다
            if (temp >= a[child])
                break;
            
            // 자식을 부모 노드로 올림
            a[parent] = a[child];
        }
        // 빈자리 발견 시 temp 삽입
        a[parent] = temp;
    }//close downHeap()

    // 힙 정렬
    static void heapSort(int[] a, int n) {
        // 우선적으로 힙을 만듦
        for (int i = (n - 1) / 2; i >= 0; i--)
            downHeap(a, i, n - 1);
        // heap 생성 시 모든 자식 노드들은 같은 계층 간 정렬이

        // 생성된 heap 을 통해 정렬
        // (뒤에서 부터 접근하며 항상 root 가 최대값인 heap 의 특성을 살려 오름차순 정렬)
        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            downHeap(a, 0, i - 1);
        }
    }//close heapSort()

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순 정렬");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }

}

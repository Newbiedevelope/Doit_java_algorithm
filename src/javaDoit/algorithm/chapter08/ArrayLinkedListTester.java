package javaDoit.algorithm.chapter08;

import java.util.Comparator;
import java.util.Scanner;

public class ArrayLinkedListTester {

    static Scanner sc = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + ") " + name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + " 할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = sc.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = sc.next();
            }
        }//close scanData()

        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.no.compareTo(o2.no);
            }
        }

        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.name.compareTo(o2.name);
            }
        }

        enum Menu {
            ADD_FIRST("머리에 노드를 삽입")
            , ADD_LAST("꼬리에 노드를 삽입")
            , RMV_FIRST("머리 노드를 삭제")
            , RMV_LAST("꼬리 노드를 삭제")
            , RMV_CRNT("선택 노드를 삭제")
            , CLEAR("모든 노드를 삭제")
            , SEARCH_NO("번호로 검색")
            , SEARCH_NAME("이름으로 검색")
            , NEXT("선택 노드를 하나 뒤쪽으로 진행")
            , PRINT_CRNT("선택 노드를 출력")
            , DUMP("모든 노드를 출력")
            , TERMINATE("종료");

            private final String message;

            static LinkedListTester.Menu MenuAt(int idx) {
                for (LinkedListTester.Menu m : LinkedListTester.Menu.values())
                    if (m.ordinal() == idx)
                        return m;
                return null;
            }

            Menu(String string) {
                message = string;
            }

            String getMessage() {
                return message;
            }
        }

        static LinkedListTester.Menu SelectMenu() {
            int key;
            do {
                for (LinkedListTester.Menu m : LinkedListTester.Menu.values()) {
                    System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                    if ((m.ordinal() % 3) == 2 && m.ordinal() != LinkedListTester.Menu.TERMINATE.ordinal())
                        System.out.println();
                }
                System.out.print(" : ");
                key = sc.nextInt();
            } while (key < LinkedListTester.Menu.ADD_FIRST.ordinal() || key > LinkedListTester.Menu.TERMINATE.ordinal());
            return LinkedListTester.Menu.MenuAt(key);
        }

        public static void main(String[] args) {
            LinkedListTester.Menu menu;
            LinkedListTester.Data data;
            LinkedListTester.Data ptr;
            LinkedListTester.Data temp = new LinkedListTester.Data();

            LinkedList<LinkedListTester.Data> linkedList = new LinkedList<LinkedListTester.Data>();

            do {
                switch (menu = SelectMenu()) {
                    case ADD_FIRST:
                        data = new LinkedListTester.Data();
                        data.scanData("머리에 삽입", LinkedListTester.Data.NO | LinkedListTester.Data.NAME);
                        linkedList.addFirst(data);
                        break;

                    case ADD_LAST:
                        data = new LinkedListTester.Data();
                        data.scanData("꼬리에 삽입", LinkedListTester.Data.NO | LinkedListTester.Data.NAME);
                        linkedList.addLast(data);
                        break;

                    case RMV_FIRST:
                        linkedList.removeFirst();
                        break;

                    case RMV_LAST:
                        linkedList.removeLast();
                        break;

                    case RMV_CRNT:
                        linkedList.removeCurrentNode();
                        break;

                    case SEARCH_NO:
                        temp.scanData("검색", LinkedListTester.Data.NO);
                        ptr = linkedList.search(temp, LinkedListTester.Data.NO_ORDER);
                        if (ptr == null)
                            System.out.println("그 번호의 데이터가 없습니다.");
                        else System.out.println("검색 성공 : " + ptr);
                        break;

                    case SEARCH_NAME:
                        temp.scanData("검색", LinkedListTester.Data.NAME);
                        ptr = linkedList.search(temp, LinkedListTester.Data.NAME_ORDER);
                        if (ptr == null)
                            System.out.println("그 이름의 데이터가 없습니다.");
                        else
                            System.out.println("검색 성공 : " + ptr);
                        break;

                    case NEXT:
                        linkedList.next();
                        break;

                    case PRINT_CRNT:
                        linkedList.printCurrentNode();
                        break;

                    case DUMP:
                        linkedList.dump();
                        break;

                    case CLEAR:
                        linkedList.clear();
                        break;
                }//close switch case
            } while (menu != LinkedListTester.Menu.TERMINATE);
        }
    }

    enum Menu {
        ADD_FIRST("머리에 노드를 삽입")
        , ADD_LAST("꼬리에 노드를 삽입")
        , RMV_FIRST("머리 노드를 삭제")
        , RMV_LAST("꼬리 노드를 삭제")
        , RMV_CRNT("선택 노드를 삭제")
        , CLEAR("모든 노드를 삭제")
        , SEARCH_NO("번호로 검색")
        , SEARCH_NAME("이름으로 검색")
        , NEXT("선택 노드를 하나 뒤쪽으로 진행")
        , PRINT_CRNT("선택 노드를 출력")
        , DUMP("모든 노드를 출력")
        , TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != LinkedListTester.Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = sc.nextInt();
        } while (key < LinkedListTester.Menu.ADD_FIRST.ordinal() || key > LinkedListTester.Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();

        ArrayLinkedList<Data> arrayLinkedList = new ArrayLinkedList<Data>(100);

        do {
            switch (menu = SelectMenu()) {
                case ADD_FIRST:
                    data = new Data();
                    data.scanData("머리에 삽입", Data.NO | Data.NAME);
                    arrayLinkedList.addFirst(data);
                    break;

                case ADD_LAST:
                    data = new Data();
                    data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                    arrayLinkedList.addLast(data);
                    break;

                case RMV_FIRST:
                    arrayLinkedList.removeFirst();
                    break;

                case RMV_LAST:
                    arrayLinkedList.removeLast();
                    break;

                case RMV_CRNT:
                    arrayLinkedList.removeCurrentNode();
                    break;

                case SEARCH_NO:
                    temp.scanData("검색", Data.NO);
                    ptr = arrayLinkedList.search(temp, Data.NO_ORDER);
                    if (ptr == null)
                        System.out.println("그 번호의 데이터가 없습니다.");
                    else System.out.println("검색 성공 : " + ptr);
                    break;

                case SEARCH_NAME:
                    temp.scanData("검색", Data.NAME);
                    ptr = arrayLinkedList.search(temp, Data.NAME_ORDER);
                    if (ptr == null)
                        System.out.println("그 이름의 데이터가 없습니다.");
                    else
                        System.out.println("검색 성공 : " + ptr);
                    break;

                case NEXT:
                    arrayLinkedList.next();
                    break;

                case PRINT_CRNT:
                    arrayLinkedList.printCurrentNode();
                    break;

                case DUMP:
                    arrayLinkedList.dump();
                    break;

                case CLEAR:
                    arrayLinkedList.clear();
                    break;
            }//close switch case
        } while (menu != Menu.TERMINATE);
    }

}

package javaDoit.algorithm.chapter04;

// 사용자 정의 스택 생성, 클래스명 : IntStack
public class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr;

    // 스택이 비어있을 때 참조 시 발생하는 예외
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() {}
    }
    
    // 스택이 찼을 때 삽입 시 발생하는 예외
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {}
    }

    // 사용자 정의 생성자, 스택의 크기를 매개변수로 받음
    public IntStack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        try{
            stk = new int[capacity];
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 스택의 마지막 자리에 요소를 저장하는 메소드(유사시 Overflow Exception 발생)
    public int push(int x) throws OverflowIntStackException{
        if (ptr >= capacity)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택의 마지막 요소를 제거(추출)하는 메소드(유사시 Empty Exception 발생)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 스택의 마지막 요소를 받기만(제거하지 않음) 하는 메소드(유사시 Empty Exception 발생)
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    // 스택을 초기화하는 메소드
    public void clear() {
        ptr = 0;
    }

    // 찾는 값을 스택에서 찾아주는 메소드, 존재 시 index 값 반환 부재 시 -1 반환
    public int indexOf(int x){
        for (int i=ptr-1; i>=0; i--)
            if (stk[i] == x)
                return i;
        return -1;
    }

    // 스택의 저장 가능 공간을 반환하는 메소드
    public int getCapacity(){
        return capacity;
    }

    // 호출 시점의 스택에 저장된 요소의 개수를 알려주는 메소드
    public int size(){
        return ptr;
    }

    // 스택이 비었는지 확인하는 메소드
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 찼는지 확인하는 메소드
    public boolean isFull() {
        return ptr >= capacity;
    }

    // 스택의 요소를 모두 출력하는 메소드
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 이미 비어있습니다.");
        else {
            for (int i=0; i<ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }
}

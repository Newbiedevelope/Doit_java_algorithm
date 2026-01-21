package javaDoit.algorithm.chapter04;

public class IntQueue {
    private int[] que;      // 자료구조 큐
    private int capacity;   // 큐의 크기
    private int front;      // 큐의 맨 앞 요소(커서)
    private int rear;       // 큐의 맨 뒤 요소(커서)
    private int num;        // 현재 데이터 개수

    // 큐가 비어있는 상황의 예외
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }

    // 큐가 가득 찬 상황의 예외
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    // 생성자
    public IntQueue(int maxlen){
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 큐에 데이터 삽입(인큐)
    public int enque(int x){
        if(num >= capacity)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if (rear == capacity)
            rear = 0;
        return x;
    }

    // 큐에서 데이터 추출(디큐)
    public int deque() throws EmptyIntQueueException{
        if (num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if (front == capacity)
            front = 0;
        return x;
    }

    // 큐의 맨 앞 요소 출력(추출 X)
    public int peek() throws EmptyIntQueueException{
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    // 큐 비우기
    public void clear() {
        num = front = rear = 0;
    }

    // 큐에서 값 x에 해당하는 인덱스를 찾는 메소드(못 찾을 시 -1 반환)
    public int indexOf(int x){
        for (int i=0; i<num; i++){
            int idx = (i + front) % capacity;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 큐의 크기 반환
    public int getCapacity(){
        return capacity;
    }

    // 큐의 현재 데이터 개수 반환
    public int size(){
        return num;
    }

    // 큐가 비어있는지 아닌지 반환
    public boolean isEmpty(){
        return num <= 0;
    }

    // 큐가 가득 찼는지 아닌지 반환
    public boolean isFull(){
        return num >= capacity;
    }

    // 큐의 모든 요소를 순서대로 출력(front → rear)
    public void dump(){
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i=0; i<num; i++)
                System.out.print(que[(i+front) % capacity] + " ");
            System.out.println();
        }
    }
}

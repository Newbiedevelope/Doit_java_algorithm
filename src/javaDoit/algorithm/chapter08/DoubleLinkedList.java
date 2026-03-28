package javaDoit.algorithm.chapter08;

import java.util.Comparator;

public class DoubleLinkedList<E> {

    class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E data, Node<E> prev, Node<E> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }//close Node{}

    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList() {
        head = crnt = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }//close search()

    public void printCurrentNode() {
        if (isEmpty())
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }//close printCurrentNode()

    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }//close dump()

    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }//close dumpReverse()

    public boolean next() {
        if (isEmpty() || crnt.next == head)
            return false;
        crnt = crnt.next;
        return true;
    }//close next()

    public boolean prev() {
        if (isEmpty() || crnt.prev == head)
            return false;
        crnt = crnt.prev;
        return true;
    }//close prev()

    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }//close add()

    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }//close addFirst()

    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }//close addLast()

    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head)
                crnt = head.next;
        }
    }//close removeCurrentNode()

    public void remove(Node p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }//close remove()

    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }//close removeFirst()

    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }//close removeLast()

    public void clear() {
        while (!isEmpty())
            removeFirst();
    }//close clear()
}

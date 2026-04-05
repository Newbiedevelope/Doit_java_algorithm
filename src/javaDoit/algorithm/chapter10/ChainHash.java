package javaDoit.algorithm.chapter10;

public class ChainHash<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getData() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }//close class Node()

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError error) {
            this.size = 0;
        }
    }//close construct

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {
            if (p.getKey().equals(key))
                return p.getData();
            p = p.next;
        }
        return null;
    }//close search()

    public int add(K key, V data) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {
            if (p.getKey().equals(key))
                return 1;
            p = p.next;
        }
        Node<K, V> temp = new Node<>(key, data, table[hash]);
        table[hash] = temp;
        return 0;
    }//close add()

    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];
        Node<K, V> pp = null;

        while (p != null) {
            if (p.getKey().equals(key)) {
                if (pp == null)
                    table[hash] = p.next;
                else
                    pp.next = p.next;
                return 0;
            }//close if
            pp = p;
            p = p.next;
        }//close while
        return 1;
    }//close remove()

    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d ", i);
            while (p != null) {
                System.out.printf("→ %s (%s) ", p.getKey(), p.getData());
                p = p.next;
            }
        }
        System.out.println();
    }
}

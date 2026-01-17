package javaDoit.algorithm.chapter03;

class A implements Comparable<A> {

    int testVar;

    public int compareTo(A c){
        return Integer.compare(this.testVar, c.testVar);
    }

    public boolean equals(Object c){
        return this.equals(c);
    }
}

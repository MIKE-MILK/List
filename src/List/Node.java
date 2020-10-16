package List;

import java.util.List;

//节点类
public class Node<T>{
    public T e;
    public Node next;
    public Node pre;

    public Node(Node next,Node pre,T e) {
        this.pre=pre;
        this.next=next;
        this.e=e;
    }

    public Node() {}
}

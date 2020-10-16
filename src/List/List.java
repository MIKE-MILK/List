package List;

import java.util.Iterator;

//🤚写的简易List
public class  List<E>implements Iterable<E>,Comparable<E>{
    //定义一个双链表
    private Node<E> Next;
    private Node<E> Pre;
    private int size=0;

    public List() {}
    //判断是否为空
    private Boolean isEmpty(){
        if (Next.next==null){
            return false;
        }else {
            return true;
        }
    }
    //某一节点
    public Node node(int index){
        //某一节点的判定是否超出范围,超出范围则报异常
        if (index<0||index>size){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        Node node=null;
        if (Pre!=null){
            node= Pre;
            for (int i=0;i<index;i++){
                node=node.next;
            }
        }
        return node;
    }
    //进行add的操作
    public void add(E e){
        Node n = new Node();
        if(Pre==null) {
            n.pre=null;
            n.e=e;
            n.next=null;
            Pre = n;
            Next = n;
        }else {
            //直接往节点后面增加一个新的节点
            n.pre=Next;
            n.e=e;
            n.next=null;
            Next.next=n;
            Next = n;
        }
        size++;
    }
    //确定add位置的add的操作，此方法可以确定添加的位置
    public void add(int index,E e){
        Node temp=node(index);
        Node node=new Node();
        node.e=e;
        //三种情况
        if (temp!=null&&temp!=Pre&&temp!=Next){
            Node up=new Node();
            up=temp.pre;
            up.next=node;
            node.pre=up;
            node.next=temp;
            temp.pre=node;
            size++;
        }
        if (temp!=null&&temp==Pre){
            node.next=temp;
            temp.pre=node;
            Pre=node;
            size++;
        }
        if (temp!=null&&temp==Next){
            node.pre=temp;
            temp.next=node;
            Next=temp;
            size++;
        }
    }
    //进行addAll的操作
//    public E addAll(){}
    //进行remove的操作
    public void remove(int index){
        Node temp = node(index);
        if(temp!=null) {
            Node up = temp.pre;
            Node down = temp.next;
            up.next = down;
            down.pre = up;
        }
        size--;
    }
    //进行clear的操作
    public void clear(){
        Pre = new Node(null, null, null);
        Next= new Node(null, Pre, null);
        Pre.next = Next;
        size++;
    }
    //进行replace的操作
    public void replace(int index,E e){
        Node temp=node(index);
        temp.e=e;
    }
    //进行sort的操作
    public void sort(){
        int length=size();
        //采用冒泡排序进行排序
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if (node(j+1)!=null){
                    int n=(int)node(j).e;
                    int z=(int)node(j+1).e;
                    if (n>z){
                        Node temp=node(j);
                        Node temp1=node(j+1);
                        Object o=temp.e;
                        Object x=temp1.e;
                        node(j).e=node(j+1).e;
                        node(j+1).e=o;
                    }
                }
            }
        }
    }
    //get操作
    public  Object get(int index){
        Node temp=node(index);
        if (temp!=null){
            return temp.e;
        }else {
            return null;
        }
    }

    public int size() {
        return size;
    }
    //迭代器

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<E>{

        E data;
        Node n = Pre.next;

        MyIterator(){
            data=Pre.e;
            System.out.println(data);
        }

        @Override
        public boolean hasNext() {
            return n!=null;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            data= (E) n.e;
            n=n.next;
            return data;
        }

        @Override
        public void remove() {
            System.out.println("未实现");
        }
    }

    @Override
    public int compareTo(E o) {
        Node b=(Node)o;
        return -1;
    }
}

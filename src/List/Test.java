package List;


import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        List<Integer>list=new List();
        list.add(2);
        list.add(1);
        list.clear();
        Iterator<Integer>it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        list.add(1,2);
//        list.replace(0,3);
//        Collections.sort(list);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
    }
}

package List;


public class Collections {
    public static <T> void sort(List<T>list){
        int length=list.size();
        System.out.println(length);
        for(int j=0;j<list.size();j++){
            for(int i=list.size();i>j;i--){
                Object o=list.get(j);
                System.out.println(o);
//                Comparable a=(Comparable)list.node(i).e;
//                System.out.println(a);
//                Comparable b=(Comparable)list.node(i-1).e;
//                if(a.compareTo(b)<0){
//                    Object temp=list.node(i).e;
//                    list.node(i).e=list.node(i-1).e;
//                    list.node(i-1).e=temp;
//                }
            }
        }
    }
}

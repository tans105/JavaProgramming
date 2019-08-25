package miniApplications.myCustomList;

public class Runner {
    public static void main(String[] args) {
        MyCustomList list = new MyCustomList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.size());
    }
}

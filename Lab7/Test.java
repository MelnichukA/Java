public class Test {
 
    public static void main(String[] args) {
        DynamicList list = new DynamicList();
        list.add("0");
        list.add("1");
        System.out.println(list.get());
        System.out.println(list.get(0));
        list.add("2");
        list.add("3");
        System.out.println(list);
 
        System.out.println(list.remove(2));
        System.out.println(list.remove());
        System.out.println(list.remove());
        System.out.println(list.remove());
 
    }
}
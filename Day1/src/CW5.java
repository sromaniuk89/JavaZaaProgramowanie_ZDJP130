public class CW5 {
    public static void main(String[] args) {
        SDAHashSet_5<Integer> sdaHashSet_5 = new SDAHashSet_5<>();

        System.out.println(sdaHashSet_5.add(2));
        System.out.println(sdaHashSet_5.add(2));
        System.out.println(sdaHashSet_5.add(3));
        System.out.println(sdaHashSet_5.add(4));
        System.out.println(sdaHashSet_5.add(5));
        System.out.println("remove():");
        System.out.println(sdaHashSet_5.remove(5));
        System.out.println(sdaHashSet_5.remove(5));
        System.out.println("size():");
        System.out.println(sdaHashSet_5.size());
        System.out.println("contains():");
        System.out.println(sdaHashSet_5.contains(4));
        System.out.println(sdaHashSet_5.contains(5));
        System.out.println(sdaHashSet_5.contains("ABC"));

    }
}

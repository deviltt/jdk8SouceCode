package test.java.util;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
//        reverseComparator();
        nCopies();
    }

    private void testSetFromMap() {
        Map<String, Boolean> map = new HashMap<>();
        Set<String> setFromMap = Collections.newSetFromMap(map);

        map.put("1", false);
        map.put("2", true);

        setFromMap.add("3");

//        setFromMap.
    }

    private static void reverseComparator() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(4);
            add(0);
            add(8);
        }};

//        Collections.sort(list);

        System.out.println(list);

//        Collections.reverseOrder();

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list);

//        Collections.reverse(list);
//
//        System.out.println(list);
    }

    private static void nCopies(){
        List<String> nCopies = Collections.nCopies(3, "tt");
        System.out.println(nCopies);
    }

    private static void singletonMapTest(){
        Map<String, Integer> tt = Collections.singletonMap("tt", 30);

        tt.put("tt",23);
        System.out.println(tt);
    }
}

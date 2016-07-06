package libraries.utility;

import java.util.*;

public class Utilities {
    /**
     * Sorting List
     */
    public static List sortListAscending(List list) {
        Collections.sort(list);
        return list;
    }

    public static List sortListDescending(List list) {
        sortListAscending(list);
        Collections.reverse(list);
        return list;
    }

    public static String minList(List list) {
        return Collections.min(list).toString();
    }

    public static String maxList(List list) {
        return Collections.max(list).toString();
    }

    /**
     * Sorting Map
     */
    public static Map<String, Integer> sortMap(Map<String, Integer> map) {

        // Map -> List -> Sorting list -> toMap
        List<Map.Entry<String, Integer>> tmpList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(tmpList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> o : tmpList) {
            sortedMap.put(o.getKey(), o.getValue());
        }
        return sortedMap;
    }
}

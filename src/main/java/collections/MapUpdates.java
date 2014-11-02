package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapUpdates {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Francesco");
        map.put(2, "Mark");
        map.put(3, "John");
        map.put(4, "Ciccio");

        /**
         * COMPUTE
         * This function takes an Integer and String as input and returns a String
         * It is used to perform computation on key K and value V;
         * If the value is null it concatenates Abbate:K otherwise it returns "Missing" AND INSERT THE NEW Entry 5:Missing in the map
         */
        BiFunction<Integer, String, String> compute = (k, v) -> v == null ? "Missing" : v.concat(" Abbate:" + k);
        String modifiedString = map.compute(5, compute);
        System.out.println(modifiedString);
        System.out.println(map);

        /**
         * COMPUTE IF ABSENT
         * Store and return the new inserted value
         */
        String newValue = map.computeIfAbsent(6, k -> "New Value");
        System.out.println(newValue);
        System.out.println(map);

        /**
         * Store and returns the remapped value
         */
        String remappedValue = map.computeIfPresent(4, (k, v) -> "CiccioBello");
        System.out.println(remappedValue);
        System.out.println(map);

        /**
         * GET OR DEFAULT
         */
        String defaultValue = map.getOrDefault(10, "DefaultValue");
        System.out.println(defaultValue);
        assert defaultValue.equals("DefaultValue");


        /**
         * MERGE
         * Applies the given action on the given key value and then store and return it
         */

        System.out.println("MERGE:");
        String merged = map.merge(2, "Mark", (k, v) -> v.concat("Zuck"));
        System.out.println(merged);
        assert map.get(2).equals("MarkZuck");
        System.out.println(map);

        /**
         * REMOVE
         * remove the element only if it has the given value
         */

        boolean isRemoved = map.remove(1, "Francesco");
        assert isRemoved;
        System.out.println(map);

        boolean isRemoved2 = map.remove(2, "NonExistingValue");
        assert !isRemoved2;
        System.out.println(map);

        /**
         * REPLACE ALL, applying the BiFunction passed as argument
         */
        map.replaceAll((k,v) -> v.concat(":" + k));
        //At this point all the values should have the key concatenated
        System.out.println(map);
    }
}

package test.colletion;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer,String> map = new TreeMap<Integer,String>();
        map.put(5, "5");
        map.put(3, "3");
        map.put(20, "20");
        map.put(10, "10");
        map.put(8, "8");
        map.put(15, "15");
        map.put(30, "30");
        
        map.remove(20);
    }

}

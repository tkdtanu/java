package com.tkd.ds.map;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap {
    public static void main(String[] args) {

           Test t1 = new Test();
           //Test t2 = new Test();
           Map<Test, Integer> m = new HashMap<Test, Integer>();
           m.put(t1, 100);
           m.put(t1, 200);
           m.put(t1, 300);
           Test t2 = new Test();
           m.put(t2, 300);
           m.put(t2, 300);
           
           System.out.println("size" + m.size());
           System.out.println(m.get(t1));

    }
}

class Test {
    @Override
    public int hashCode() {
           System.out.println("hashCode");
           return 1;

    }

    @Override
    public boolean equals(Object arg0) {
           System.out.println("equals");
           return false;

    }
}



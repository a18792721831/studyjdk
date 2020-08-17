package com.study.studymap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiayq
 * @Date 2020-05-23
 */
public class MyMap {

    public static void main(String[] args) {
        HashMap<People,Integer> map = new HashMap<>();
        map.put(new People(), 1);
        map.put(new People(), 1);
        map.put(new People(), 1);
        System.out.println(map.values());
        map.put(null, null);
    }

    static class People{
        @Override
        public int hashCode() {
            return 0;
        }
    }

}

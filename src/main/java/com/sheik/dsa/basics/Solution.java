package com.sheik.dsa.basics;

import java.util.*;

public class Solution{
    private int jk = 0;
    String sh = "";
    public int solve(int A, int B){
        int totalSlices = (A * 3) + B;
        sh = "dsdfa";
        int jk=10;
        return totalSlices / 2;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.solve(5, 0));

        String g = "guna seelan guna seelan";
        String sub = "an";
        int count = 0;
        int index = g.indexOf(sub, 0);
        while(index > 0) {
            count ++;
            index = g.indexOf(sub, index+1);
        }

        System.out.println(count);














//        System.out.println(counterList);


    }


//    List<Integer> i = new ArrayList<>();
//    Set<Integer> s = new TreeSet<>();
//    Map<String, String> m = new TreeMap<>();
//    Comparator<Integer> c;
}
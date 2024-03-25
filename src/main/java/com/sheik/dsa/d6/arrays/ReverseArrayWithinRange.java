package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 24 Mar 2024
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Reverse an array between [s and e]
 * Approach 1: Big (O) = N
 */
public class ReverseArrayWithinRange {

    /**
     * swap the element from index (s and e), then (s+1 and e-1), then (s+2 and e-2) upto middle of s and e
     * Big (O) = N
     */
    public void approach1(int[] a, int left, int right){
        printArray(a);
        while (left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
        printArray(a);
    }



    private void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ReverseArrayWithinRange reverseArrayWithinRange = new ReverseArrayWithinRange();

        int input[] = {6,3,3,6,7,8,7,3,7};
        int s = 3;
        int e = 8;
//        reverseArrayWithinRange.approach1(input, s, e);



        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(5);
        li.add(10);

        li.add(0, 100);
        li.add(li.size()-1, 200);
        System.out.println(li);
    }
}

package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

import java.util.ArrayList;

/**
 * You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.
 * Approach 1: TC Big(O) : N
 */
public class SecondLargestElement {

    /**
     *
     * Iterate the entire array and check max and second max
     * TC Big(O) : N
     */
    public void approach1(ArrayList<Integer> A){
       int large = A.get(0);
       int secondLarge = -1;
       for(int i=0; i<A.size(); i++) {
           if(A.get(i) > large){
               large = A.get(i);
           } else if(A.get(i) < large) {
               if(large == secondLarge || secondLarge < A.get(i)){
                   secondLarge = A.get(i);
               }
           }
       }
        System.out.println(secondLarge);
    }

    public static void main(String[] args) {
        SecondLargestElement array = new SecondLargestElement();

        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(2);

        array.approach1(A);
    }
}

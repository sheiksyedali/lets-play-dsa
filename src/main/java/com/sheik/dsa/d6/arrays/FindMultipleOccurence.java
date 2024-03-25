package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

/**
 * Given an array A and an integer B, find the number of occurrences of B in A.
 * Approach 1: Big (0): N
 */
public class FindMultipleOccurence {

    /**
     * Iterate an entire array and check the element matched with given input
     * TC Big (O): N
     */
    public void approach1(int[] A, int B){
        int occurrence = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == B){
                occurrence++;
            }
        }

        System.out.println("Approach 1: Occurrence: "+occurrence);
    }

    public static void main(String[] args) {
        FindMultipleOccurence array = new FindMultipleOccurence();

        int[] a = {1, 2, 2};
        int b = 2;
        array.approach1(a, b);
    }

}

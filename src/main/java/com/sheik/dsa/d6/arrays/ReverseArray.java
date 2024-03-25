package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 24 Mar 2024
 */

/**
 * Given an n size array, reverse it
 * Approach 1: Big (O): N
 */
public class ReverseArray {

    /**
     * Swap the (0th and n-1) index, then (1 and n-2) index, until it reached the middle
     * Big (O): N
     */
    public void approach1(int[] a){
        printArray(a);
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        while (leftIndex < rightIndex) {
            int temp = a[leftIndex];
            a[leftIndex] = a[rightIndex];
            a[rightIndex] = temp;
            leftIndex = leftIndex + 1;
            rightIndex = rightIndex -1;
        }
        printArray(a);
    }

    public void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();

        int input[] = {0, 1, 3, 4, -1, 0, 7, 6};
        reverseArray.approach1(input);

    }
}

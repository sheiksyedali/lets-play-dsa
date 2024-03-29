package com.sheik.dsa.d7.prefix_sum;

/**
 * Author: Sheik Syed Ali
 * Date: 28 Mar 2024
 */

/**
 * Print the prefix array of given array
 * Eg: [1,5, 6, 8, 3]
 * pf : [1, 6, 12, 20, 23]
 *
 * (Approach 1) TC Big (O): N
 */
public class PrintPrefixArray {

    /**
     * 1. Create an new array with same element size
     * 2. Start an loop and iterate it entire array
     * 3. in looping, pf[i] = p[i -1] + a[i]
     * Note: i should be greater than 0. i>0 otherwise it throws index out of bounds exception
     *
     * TC Big (O): N
     */
    public void approach1(int[] a) {
        printArray(a);
        int b[] = new int[a.length];
        b[0] = a[0];
        for(int i = 1; i<a.length; i++){
            b[i] = a[i] + b[i-1];
        }
        printArray(b);
    }

    private void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintPrefixArray pfArray = new PrintPrefixArray();
        int input[] = {1, 2, 5, 9, 10, 3};
        pfArray.approach1(input);
    }
}

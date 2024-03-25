package com.sheik.dsa.d6.arrays;

/**
 * Author: Sheik Syed Ali
 * Date: 25 Mar 2024
 */

/**
 * Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
 * Approach1 TC: Big (O) = N
 */
public class SumMixMaxInArray {

    /**
     * Iterate entire array and figure out max and min element at the same time
     * TC: Big (O) = N
     */
    public void approach1(int[] a){
        int min = a[0];
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] > max){
                max = a[i];
            }

            if(a[i] < min){
                min = a[i];
            }
        }
        int sum = min+max;
        System.out.println("Approach1 Sum: "+sum);
    }

    public static void main(String[] args) {
        SumMixMaxInArray array = new SumMixMaxInArray();

        int input[] = {-2, 1, -4, 5, 3};
        array.approach1(input);
    }
}

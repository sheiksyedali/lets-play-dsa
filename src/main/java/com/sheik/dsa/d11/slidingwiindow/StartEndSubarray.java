package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 12 Apr 2024
 */

/**
 * Given an array and size k, print the start and end of all subarrays
 *
 * Constraints:
 *  1 <=k <= N
 */
public class StartEndSubarray {

    /**
     * Subarray qualities:
     *      last sub array ends with N-1
     *      first array start 0 end k-1
     *      loop it until reach end reach last element
     * TC O(N); SC O(1)
     */
    public void approach1(int[] input, int k){
        int s=0;
        int e=k-1;
        int N = input.length;
        while (e < N){
            System.out.println("["+s+", "+e+"]");
            s++;
            e++;
        }
    }

    public static void main(String[] args) {
        StartEndSubarray startEndSubarray = new StartEndSubarray();
        int[] input = {3,6,5,4,7,8,9,50,34};
        int k=4;

        startEndSubarray.approach1(input, k);
    }
}

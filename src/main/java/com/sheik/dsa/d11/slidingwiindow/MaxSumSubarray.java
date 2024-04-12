package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 12 Apr 2024
 */

import com.sheik.dsa.util.Utils;

/**
 * Find the max sum subarray for all subarray size k
 */
public class MaxSumSubarray {

    /**
     * Technique:
     *      Brute force -> calculate sum for start and end index
     *
     *  TC O(N pow 2); SC O(1)
     */
    public void approach1(int[] input, int k){
        int maxSum = Integer.MIN_VALUE;
        int s=0;
        int e=k-1;
        while (e < input.length){
            int sum = 0;
            for(int i=s; i<=e; i++){
                sum += input[i];
            }

            if(sum > maxSum){
                maxSum = sum;
            }

            s++;
            e++;
        }

        System.out.println("(Brute force) Max sum:"+maxSum);
    }


    /**
     * Technique:
     *      Prefix sum array
     *
     * TC O(N); SC O(N)
     */
    public void approach2(int[] input, int k){
        int s=0;
        int e=k-1;
        int[] pf=new int[input.length];

        //Generate prefix sum array
        pf[0] = input[0];
        for(int i=1; i<input.length; i++){
            pf[i] = input[i]+pf[i-1];
        }

        int maxSum = Integer.MIN_VALUE;
        while (e < input.length){
            int sum = 0;
            if(s == 0) {
                sum = pf[e];
            } else {
                sum = pf[e] - pf[s-1];
            }

            if(sum > maxSum){
                maxSum = sum;
            }

            s++;
            e++;
        }

        System.out.println("(Prefix sum) Max sum:"+maxSum);

    }

    /**
     * Technique:
     *      Sliding window
     *
     * TC O(N); SC O(1)
     */
    public void approach3(int[] input, int k){
        int s=0;
        int e=k-1;
        int sum = 0;

        //Calculate first sum
        for(int i=s; i<=e; i++){
            sum +=input[i];
        }
        int maxSum = sum;

        
        s++;
        e++;
        while (e < input.length){
            sum = sum + input[e] - input[s-1];

            if(sum > maxSum){
                maxSum = sum;
            }

            s++;
            e++;
        }

        System.out.println("(Sliding window) Max sum: "+maxSum);

    }


    public static void main(String[] args) {
        MaxSumSubarray maxSumSubarray = new MaxSumSubarray();
        int[] input = {1,2,3,4,5,6,7};
        int k=3;

        maxSumSubarray.approach1(input, k);
        maxSumSubarray.approach2(input, k);
        maxSumSubarray.approach3(input, k);

    }

}

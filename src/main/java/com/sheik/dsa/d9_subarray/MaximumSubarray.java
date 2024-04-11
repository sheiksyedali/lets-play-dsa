package com.sheik.dsa.d9_subarray;

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */

/**
 * You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
 * But the sum must not exceed B.
 *
 * Problem Constraints
 * 1 <= A <= 103
 * 1 <= B <= 109
 * 1 <= C[i] <= 106
 *
 * Example Input
 * Input 1:
 * A = 5
 * B = 12
 * C = [2, 1, 3, 4, 5]
 * Input 2:
 *
 * A = 3
 * B = 1
 * C = [2, 2, 2]
 *
 *
 * Example Output
 * Output 1:
 * 12
 * Output 2:
 *
 * 0
 *
 * Example Explanation
 * Explanation 1:
 * We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
 * Explanation 2:
 *
 * All elements are greater than B, which means we cannot select any subarray.
 * Hence, the answer is 0.
 *
 * approach1:
 *      TC = O( N pow 3) SC = O(1)
 *
 * approach2:
 *      TC = O(N pow 2); SC = O(N)
 *
 */
public class MaximumSubarray {

    /**
     * Iterate all subarray and find the sum. check the sum value can not greater than B
     * TC = O( N (pow 3)) SC = O(1)
     */
    public int approach1(int A, int B, ArrayList<Integer> C) {
        int maxSum = 0;
        for(int i=0; i<A; i++){
            for(int j=i; j<A; j++){

                int subSum = 0;
                for(int k=i; k<=j; k++){
                    subSum += C.get(k) ;
                }

                if(subSum > maxSum && subSum <= B){
                    maxSum = subSum;
                }
            }
        }

        System.out.println("Maximum sum: "+maxSum);
        return maxSum;
    }


    /**
     * Generate the prefix sum array before iterating array
     * TC = O(N pow 2); SC = O(N)
     */
    public int approach2(int A, int B, ArrayList<Integer> C) {
        int maxSum = 0;
        int[] pf = new int[A];

        //Prepare prefix sum array
        pf[0] = C.get(0);
        for(int i=1; i<A; i++){
            pf[i] = C.get(i) + pf[i -1];
        }

        System.out.println(C);
        Utils.printIntArray(pf);
        //find the max sum value
        for(int i=0; i<A; i++){
            for(int j=i; j<A; j++){
                int sum = 0;
                if(i == 0){
                    sum = pf[j];
                } else {
                    sum = pf[j] - pf[i -1];
                }

                if(sum > maxSum && sum <= B){
                    maxSum = sum;
                }

            }
        }

        System.out.println("Max sum: "+ maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

//        int A = 5;
//        int B = 12;
//        int[] input = {2, 1, 3, 4, 5};

//        int A = 3;
//        int B = 1;
//        int[] input = {2, 2, 2};

//        int A = 9;
//        int B = 14;
//        int[] input = {1,2,4,4,5,5,5,7,5};

        int A = 9;
        int B = 78;
        int[] input = {7,1,8,5,8,5,3,3,5};
        maximumSubarray.approach2(A, B, Utils.toList(input));

    }

}

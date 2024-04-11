package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Given an array A of size N, find the subarray of size B with the least average.
 *
 * Problem Constraints
 * 1 <= B <= N <= 105
 * -105 <= A[i] <= 105
 *
 * Input 1:
 * A = [3, 7, 90, 20, 10, 50, 40]
 * B = 3
 *
 * Input 2:
 * A = [3, 7, 5, 20, -10, 0, 12]
 * B = 2
 *
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 4
 *
 *
 * Example Explanation
 * Explanation 1:
 * Subarray between indexes 3 and 5
 * The subarray {20, 10, 50} has the least average
 * among all subarrays of size 3.
 * Explanation 2:
 *
 *  Subarray between [4, 5] has minimum average
 */
public class SubArrayWithLeastAverage {

    /**
     *  Observation:
     *      For least average, if sum value low then average value also low.
     *      So, find out least sum
     * Technique: Sliding window
     * TC O(N); SC O(1)
     */
    public int approach1(ArrayList<Integer> A, int B) {
        int s = 0;
        int e = B-1;
        int sum = 0;
        for(int i=s; i<=e; i++){
            sum += A.get(i);
        }
        int leastSum = sum;
        int leastAvgIndex = s;
//        int leastAverage = sum/B;
//        System.out.println("sum: "+sum+"; avg="+leastAverage);
        s++;
        e++;
        while (e < A.size()){
            sum = sum + A.get(e) - A.get(s-1);

            if(leastSum > sum){
                leastSum = sum;
                leastAvgIndex = s;
            }
//            int avg = sum/B;
//            System.out.println("sum: "+sum+"; avg="+avg);
//            if(leastAverage > avg){
//                leastAverage = avg;
//                leastAvgIndex = s;
//            } else if (leastAverage == avg) {
//
//            }

            s++;
            e++;
        }

//        System.out.println("Least average: "+leastAverage+"; s="+leastAvgIndex);
        System.out.println(leastAvgIndex);

        return leastAvgIndex;
    }

    public static void main(String[] args) {
        SubArrayWithLeastAverage subArrayWithLeastAverage = new SubArrayWithLeastAverage();
//        int[] input = {3, 7, 90, 20, 10, 50, 40};
//        int B = 3;
//        int[] input = {18,11,16,19,11,9,8,15,3,10,9,20,1,19};
//        int B = 1;
//        int[] input = {20,3,13,5,10,14,8,5,11,9,1,11};
//        int B = 9;
        int[] input = {15,7,11,7,9,8,18,1,16,18,6,1,1,4,18};
        int B = 6;

        subArrayWithLeastAverage.approach1(Utils.toList(input), B);
    }

}

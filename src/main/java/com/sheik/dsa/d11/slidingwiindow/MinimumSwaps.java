package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 *
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 *
 * Input 1:
 *
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  B = 8
 * Input 2:
 *  A = [5, 17, 100, 11]
 *  B = 20
 *
 *
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  1
 *
 * Example Explanation
 * Explanation 1:
 *  A = [1, 12, 10, 3, 14, 10, 5]
 *  After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 *  After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 *  Now, all elements less than or equal to 8 are together.
 *
 * Explanation 2:
 *  A = [5, 17, 100, 11]
 *  After swapping 100 and 11, A => [5, 17, 11, 100].
 *  Now, all elements less than or equal to 20 are together.
 *
 *
 */
public class MinimumSwaps {

    /**
     * Observation:
     *      less than value B elements can be arranged in an array either left to right or right to left
     *      There is no order mentioned in issue description like asc/desc
     *
     * Technique:
     *      Carry forward
     * Traverse an array form left to right first and arrange the elements less than B and count the swap
     * Traverse an array form right to left then arrange the elements less than B and count the swap
     * Find the target index for swap, if element value > B that element index will be the target index
     * Find first less than B element then swap with target index
     *
     *  TC O(N); SC O(N)
     */
    public int approach1(ArrayList<Integer> A, int B) {
        int minSwapCountLtR = 0;
        int minSwapCountRtL = 0;

        //Create this array for right to left approach because we swap the original array
        ArrayList<Integer> AA = new ArrayList<>();
        A.stream().forEach( a -> AA.add(a));

        //Iterate an array from left to right and arrange the elements
        int targetIndex = -1;
        for(int i=0; i<A.size(); i++){
            if(A.get(i) <= B){

                if(targetIndex == -1 || (i == targetIndex)){ //First detection of value less or equal to B, So no swap
                    targetIndex = i+1;
                } else {
                    int temp = A.get(targetIndex);
                    A.set(targetIndex, A.get(i));
                    A.set(i, temp);
                    targetIndex++;

                    minSwapCountLtR++;
                }

            }
        }

//        Iterate an array from right to left and arrange the elements
        targetIndex = -1;
        for(int i=AA.size()-1; i>=0; i--){

            if(AA.get(i) <= B){
                if(targetIndex == -1 || (i == targetIndex)){ //First detection of value less or equal to B, So no swap
                    targetIndex = i - 1;
                } else {
                    int temp = AA.get(targetIndex);
                    AA.set(targetIndex, AA.get(i));
                    AA.set(i, temp);
                    targetIndex--;

                    minSwapCountRtL++;
                }
            }

        }

        //Check the min swap count
        int minSwapCount = (minSwapCountLtR < minSwapCountRtL) ? minSwapCountLtR : minSwapCountRtL;
        System.out.println(minSwapCount);
        return minSwapCount;
    }


    public static void main(String[] args) {
        MinimumSwaps minimumSwaps = new MinimumSwaps();
//        int[] input = {1, 12, 10, 3, 14, 10, 5};
//        int B = 8;

        int[] input = {52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70};
        int B = 19;
        minimumSwaps.approach1(Utils.toList(input), B);
    }
}

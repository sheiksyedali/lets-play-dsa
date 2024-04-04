package com.sheik.dsa.d8.carry_forward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Sheik Syed Ali
 * Date: 05 Apr 2024
 */

/**
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 * and at least one occurrence of the minimum value of the array.
 *
 * Problem Constraints
 * 1 <= |A| <= 2000
 *
 * Example Input
 * Input 1:
 * A = [1, 3, 2]
 * Input 2:
 * A = [2, 6, 1, 6, 9]
 *
 * Example Output
 * Output 1:
 *  2
 * Output 2:
 *  3
 *
 *  Approach 1:
 *      TC Big (O) = N; SC Big (O) = 1
 *
 */
public class ClosestMinMax {

    /**
     * Find a min and max value from the array
     * Check each and every element if min or max value find then store the indexes and count the element, store it if element size < detected array len
     *
     * TC Big (O) = N; SC Big (O) = 1
     */
    public int approach1(ArrayList<Integer> A) {
        int subArrLen = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if(min == max){
            return 1;
        }

        for(int i=0; i<A.size(); i++){
            if(A.get(i) > max) {
                max = A.get(i);
            }

            if(A.get(i) < min){
                min = A.get(i);
            }
        }

        for(int i=0; i<A.size(); i++){
            if(A.get(i) == max) {
                maxIndex = i;
                //Min index value must less than max index
                if (minIndex > -1) {
                    int size = maxIndex - minIndex + 1;
                    if (size < subArrLen) {
                        subArrLen = size;
                    }
                }
            }

            if(A.get(i) == min){
                minIndex = i;
                // Max index value less than min index
                if(maxIndex > -1){
                    int size = minIndex - maxIndex + 1;
                    if(size < subArrLen){
                        subArrLen = size;
                    }
                }
            }
        }

        System.out.println("Min Len of max and min value sub array: "+subArrLen);
        return subArrLen;
    }

    public static void main(String[] args) {
        ClosestMinMax closestMinMax = new ClosestMinMax();
        int[] in = {2, 6, 1, 6, 9};
//        int[] in = {1, 3, 2};
        ArrayList input = new ArrayList();
        for(int i =0; i<in.length; i++){
            input.add(in[i]);
        }
        closestMinMax.approach1(input);
    }
}

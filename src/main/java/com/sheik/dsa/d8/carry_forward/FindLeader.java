package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 05 Apr 2024
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
 * NOTE: The rightmost element is always a leader.
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 108
 *
 * Example Input
 * Input 1:
 *  A = [16, 17, 4, 3, 5, 2]
 * Input 2:
 *  A = [5, 4]
 *
 *
 * Example Output
 * Output 1:
 * [17, 2, 5]
 * Output 2:
 * [5, 4]
 *
 * Approach 1:
 *      Technique: Right to left approach
 *      TC Big (O) = N; SC Big (0) = 1
 *
 */
public class FindLeader {

    /**
     * Technique: Right to left approach
     * Find max value from right to left, because all elements on right side should be < max
     * TC Big (O) = N; SC Big (0) = 1
     *
     */
    public int[] approach1(int[] input){
       List<Integer> output = new ArrayList<>();
       int len = input.length;
       int max = input[len - 1];
       output.add(input[len -1]);
       //Started form length -2 because last one always leader
       for(int i = len-2; i >= 0; i--){
           if(input[i] > max){
               max = input[i];
               output.add(max);
           }
       }

       System.out.println(output);
       return  output.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        FindLeader findLeader = new FindLeader();
//        int[] input = {16, 17, 4, 3, 5, 2};
        int[] input = {93,57,83,41,100,10,79,27,94,22,4,96,48,18,89,37,21,5,46,81,15,30,47,23,34,65,55,9,36,20,54,17,7,56,78,84,87,97,16,69,28,11,44,49,8,25,98,75,53,62,19,24,80,68,50,91,1,86,77,14,72,66,42,63,73,45,31,61,85,64,35,32,92,71,74,3,99,52,90,43,6,40,38,2,12,59,29,82,76,60,67,13,70,58,39,33,95,88,51,26};
        findLeader.approach1(input);
    }

}

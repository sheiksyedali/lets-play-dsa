package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 05 Apr 2024
 */

import java.util.ArrayList;

/**
 * You are given an integer array A of size N.
 * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
 * Find and return the maximum possible sum of the B elements that were removed after the B operations.
 *
 * NOTE: Suppose B = 3, and array A contains 10 elements, then you can:
 * Remove 3 elements from front and 0 elements from the back, OR
 * Remove 2 elements from front and 1 element from the back, OR
 * Remove 1 element from front and 2 elements from the back, OR
 * Remove 0 elements from front and 3 elements from the back.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= B <= N
 * -103 <= A[i] <= 103
 *
 * Example Input
 * Input 1:
 *
 *  A = [5, -2, 3 , 1, 2]
 *  B = 3
 * Input 2:
 *
 *  A = [ 2, 3, -1, 4, 2, 1 ]
 *  B = 4
 *
 * Example Output
 * Output 1:
 *  8
 * Output 2:
 *  9
 *
 *  Explanation 1:
 *  Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
 *  Explanation 2:
 *  Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
 *
 */
public class PicBothSide {


    /**
     * Observation:
     *      Partitioned array and merge
     *      Create 2*B size array
     *      p1 -> 0 - B-1 (index wise)
     *      p2 -> ( (A.size() - 1) - (B - 1)
     *      p2 will be the first of partitioned array
     *      p1 will be second partitioned of the array
     *      Calculate the prefix sum of the partitioned array
     *      find the sum of B elements. iteration start from 0 and (r=B-1) ends with length of the partitioned array
     *      find the max
     */
    public int approach(ArrayList<Integer> A, int B) {
        int[] partitionedArray = new int[2*B];
        int p1StartIndex = (A.size() - 1) - (B -1);
        int p2StartIndex = 0;

        //Prepare partitioned array
        for(int i=0; i<partitionedArray.length; i++){
            if(i < B){
                partitionedArray[i] = A.get(p1StartIndex);
                p1StartIndex++;
            } else {
                partitionedArray[i] = A.get(p2StartIndex);
                p2StartIndex++;
            }
        }

        //Prepare prefix sum array
        for(int i=1; i<partitionedArray.length; i++){
            partitionedArray[i] = partitionedArray[i] + partitionedArray[i-1];
        }

        //Find max sum
        int maxSum = 0;
        int l = 0;
        int r = B -1;
        while (r < partitionedArray.length) {
            if(l == 0) {
                maxSum = partitionedArray[r];
            } else {
                int sum = partitionedArray[r] - partitionedArray[l - 1];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
            l++;
            r++;
        }

        System.out.println("Max sum: "+maxSum);


        return maxSum;
    }

    private void printArray(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        PicBothSide picBothSide = new PicBothSide();

//        int[] in = {5, -2, 3, 1, 2};
//        int b = 3;

        int[] in = {448,200,458,-382,-420,796,-202,281,589,-202,-991,157,-528,622,-462,-708,-962,-821,-810,657,958,-809,815};
        int b = 4;


        ArrayList input = new ArrayList();
        for(int i =0; i<in.length; i++){
            input.add(in[i]);
        }

        picBothSide.approach(input, b);
    }

}

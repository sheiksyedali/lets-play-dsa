package com.sheik.dsa.d9_subarray;

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */

/**
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 *
 * Note : The order of the subarrays in the resulting 2D array does not matter.
 *
 * Problem Constraints
 * 1 <= N <= 100
 * 1 <= A[i] <= 105
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 1, 4]
 *
 *
 * Example Output
 * Output 1:
 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
 * Output 2:
 * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
 *
 */
public class GenerateAllSubArrays {

    /**
     * TC = O(N pow 3); SC = O(1)
     */
    public ArrayList<ArrayList<Integer>> approach1(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        int N = A.size();
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                ArrayList<Integer> array = new ArrayList<>();

                for(int k=i; k<=j; k++){
                    array.add(A.get(k));
                }

                subArrays.add(array);
            }
        }

        System.out.println("Subarrays: "+ subArrays);
        return subArrays;
    }

    public static void main(String[] args) {
        GenerateAllSubArrays generateAllSubArrays = new GenerateAllSubArrays();
        int[] input = {5, 2, 1, 4};
        generateAllSubArrays.approach1(Utils.toList(input));
    }
}

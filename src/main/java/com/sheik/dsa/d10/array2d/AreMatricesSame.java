package com.sheik.dsa.d10.array2d;

import java.util.ArrayList;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

/**
 *You are given two matrices A and B of equal dimensions and you have to check whether two matrices are equal or not.
 *
 * Problem Constraints
 * 1 <= A.size(), B.size() <= 1000
 * 1 <= A[i].size(), B[i].size() <= 1000
 * 1 <= A[i][j], B[i][j] <= 1000
 * A.size() == B.size()
 * A[i].size() == B[i].size()
 *
 * Input 1:
 *
 * A = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * B = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 *
 * Input 2:
 * A = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * B = [[1, 2, 3],
 *      [7, 8, 9],
 *      [4, 5, 6]]
 *
 * Example Output
 * Output 1:
 * 1
 *
 * Output 2:
 * 0
 */
public class AreMatricesSame {

    /**
     * TC: O(N pow 2); SC: O(1)
     */
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int rows = A.size();
        int cols = A.get(0).size();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int lVal = A.get(i).get(j);
                int rVal = B.get(i).get(j);
                if(lVal != rVal){
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}

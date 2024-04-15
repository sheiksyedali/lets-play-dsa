package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

import java.util.ArrayList;

/**
 * You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
 *
 * Problem Constraints
 * 1 <= A.size() <= 103
 * 1 <= A[i].size() <= 103
 * 0 <= A[i][j] <= 103
 *
 * Input 1:
 * [1,2,3,4]
 * [5,6,7,0]
 * [9,2,0,4]
 *
 * Output 1:
 * [1,2,0,0]
 * [0,0,0,0]
 * [0,0,0,0]
 *
 * Example Explanation
 * Explanation 1:
 *
 * A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
 *
 */
public class RowToColumnZero {

    /**
     *
     * Approach:
     *  1. Find out all row indices which contains 0
     *  2. Find out all column indices which contains 0
     *  3. Iterate and set to 0 to the specific rows and cols
     * TC: O(); SC: O()
     */
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> zeroRows = new ArrayList<>();
        ArrayList<Integer> zeroCols = new ArrayList<>();

        int rows = A.size();
        int cols = A.get(0).size();

        //Find out all rows and cols indices which contains 0
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(A.get(i).get(j) == 0){
                    if(!zeroRows.contains(i))
                        zeroRows.add(i);
                    if(!zeroCols.contains(j))
                        zeroCols.add(j);
                }
            }
        }

        //set 0 to rows
        for(int i=0; i<zeroRows.size(); i++){
            int idx=zeroRows.get(i);
            for(int j=0; j<rows; j++){
                A.get(idx).set(j, 0);
            }
        }

        //set 0 to cols
        for(int i=0; i<zeroCols.size(); i++){
            int idx = zeroCols.get(i);
            for(int j=0; j<rows; j++){
                A.get(j).set(idx, 0);
            }
        }
        return A;
    }
}

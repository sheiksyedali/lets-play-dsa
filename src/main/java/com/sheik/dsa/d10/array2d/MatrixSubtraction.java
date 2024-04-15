package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

import java.util.ArrayList;

/**
 * You are given two integer matrices A and B having same size(Both having same number of rows (N) and columns (M). You have to subtract matrix B from A and return the resultant matrix. (i.e. return the matrix A - B).
 * If A and B are two matrices of the same order (same dimensions). Then A - B is a matrix of the same order as A and B and its elements are obtained by doing an element wise subtraction of A from B.
 *
 * Problem Constraints
 * 1 <= N, M <= 103
 * -109 <= A[i][j], B[i][j] <= 109
 *
 * Input 1:
 *
 * A =  [[1, 2, 3],
 *       [4, 5, 6],
 *       [7, 8, 9]]
 *
 * B =  [[9, 8, 7],
 *       [6, 5, 4],
 *       [3, 2, 1]]
 *
 * Input 2:
 * A = [[1, 1]]
 * B = [[2, 3]]
 *
 * Example Output
 * Output 1:
 *  [[-8, -6, -4],
 *   [-2, 0, 2],
 *   [4, 6, 8]]
 *
 * Output 2:
 *  [[-1, -2]]
 */
public class MatrixSubtraction {

    /**
     *
     * TC: O(N pow 2); SC: O(N)
     */
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> subtractMatrix = new ArrayList<>();
        int rows = A.size();
        int cols = A.get(0).size();
        for(int i=0; i<rows; i++){
            ArrayList<Integer> subtract = new ArrayList<>();
            for(int j=0; j<cols; j++){
                int m1Val = A.get(i).get(j);
                int m2Val = B.get(i).get(j);
                subtract.add(m2Val-m1Val);
            }
            subtractMatrix.add(subtract);
        }
        return subtractMatrix;
    }
}

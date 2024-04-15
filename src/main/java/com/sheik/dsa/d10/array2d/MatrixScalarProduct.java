package com.sheik.dsa.d10.array2d;

import java.util.ArrayList;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

/**
 * You are given a matrix A and and an integer B, you have to perform scalar multiplication of matrix A with an integer B.
 *
 * Problem Constraints
 * 1 <= A.size() <= 1000
 * 1 <= A[i].size() <= 1000
 * 1 <= A[i][j] <= 1000
 * 1 <= B <= 1000
 *
 * Input 1:
 * A = [[1, 2, 3],
 *      [4, 5, 6],
 *      [7, 8, 9]]
 * B = 2
 *
 * Input 2:
 * A = [[1]]
 * B = 5
 *
 * Example Output
 * Output 1:
 * [[2, 4, 6],
 * [8, 10, 12],
 * [14, 16, 18]]
 *
 *  Output 2:
 * [[5]]
 */
public class MatrixScalarProduct {
    /**
     * TC: O(N pow 2); SC: O(1)
     */
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {

        int rows = A.size();
        int cols = A.get(0).size();
        for(int i=0; i<rows; i++){
            ArrayList<Integer> row = A.get(i);
            for(int j=0; j<cols; j++){
                int val = row.get(j);
                row.set(j, val*B);
            }
            A.set(i, row);
        }

        return A;
    }

    public static void main(String[] args) {
        MatrixScalarProduct matrixScalarProduct = new MatrixScalarProduct();

        ArrayList<Integer> r1= new ArrayList<>();
        r1.add(1);
        r1.add(2);
        r1.add(3);
        ArrayList<Integer> r2= new ArrayList<>();
        r2.add(4);
        r2.add(5);
        r2.add(6);
        ArrayList<Integer> r3= new ArrayList<>();
        r3.add(7);
        r3.add(8);
        r3.add(9);

        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();
        diagonals.add(r1);
        diagonals.add(r2);
        diagonals.add(r3);

        matrixScalarProduct.solve(diagonals, 2);
    }
}

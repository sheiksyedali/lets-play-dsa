package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
 * Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
 *
 * Problem Constraints
 * 1 <= N <= 103
 * -1000 <= A[i][j] <= 1000
 *
 * Input 1:
 *  A = [[1, -2, -3],
 *       [-4, 5, -6],
 *       [-7, -8, 9]]
 *
 * Input 2:
 *  A = [[3, 2],
 *       [2, 3]]
 *
 * Output 1:
 *  -5
 *
 * Output 2:
 *  4
 *  Explanation 1:
 *  A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
 *
 * Explanation 2:
 *  A[1][2] + A[2][1] = 2 + 2 = 4
 */
public class MinorDiagonalSum {

    /**
     * TC: O(N)
     */
    public int approach1(final List<ArrayList<Integer>> A){
        int sum = 0;
        int N = A.size();
        int r=0;
        int c=N-1;

        while (r<N && c>=0){
            sum+=A.get(r).get(c);
            r++;
            c--;
        }

        return sum;
    }
    public static void main(String[] args) {

    }
}

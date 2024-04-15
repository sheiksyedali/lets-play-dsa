package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */

import java.util.ArrayList;

/**
 * Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
 *
 * Problem Constraints
 * 1<= N <= 1000
 * 1<= A[i][j] <= 1e9
 *
 * Input 1:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * Input 2:
 * 1 2
 * 3 4
 *
 * Example Output
 * Output 1:
 * 1 0 0
 * 2 4 0
 * 3 5 7
 * 6 8 0
 * 9 0 0
 *
 * Output 2:
 * 1 0
 * 2 3
 * 4 0
 */
public class AntiDiagonals {

    /**
     * TC: O(N pow 2); SC: O(1)
     */
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        ArrayList<ArrayList<Integer>> diagonals = new ArrayList<>();

        for(int i=0; i<N; i++){
            int r=0;
            int c=i;
            ArrayList<Integer> diagonal = new ArrayList<>();
            for(int j=0; j<N; j++){
                if(r<N && c>=0) {
                    diagonal.add(A.get(r).get(c));
                    r++;
                    c--;
                } else {
                    diagonal.add(0);
                }
            }
            diagonals.add(diagonal);
        }

        for(int i=1; i<N; i++){
            int r=i;
            int c=N-1;
            ArrayList<Integer> diagonal = new ArrayList<>();
            for(int j=0; j<N; j++){

                if(r<N && c>=0){
                    diagonal.add(A.get(r).get(c));
                    r++;
                    c--;
                } else {
                    diagonal.add(0);
                }

            }
            diagonals.add(diagonal);
        }

        return diagonals;
    }
    public static void main(String[] args) {
        AntiDiagonals antiDiagonals = new AntiDiagonals();

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

        antiDiagonals.diagonal(diagonals);
    }
}

package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

/**
 * Given MxN matrix, print column wise sum
 */
public class SumColumnWise {

    /**
     * TC: O(N pow 2); SC: O(1)
     */
    public void approach1(int[][] matrix, int N, int M){
        for(int j=0; j<M; j++){
            int sum=0;
            for(int i=0; i<N; i++){
                sum += matrix[i][j];
            }
            System.out.println("sum: "+sum);
        }
    }
    public static void main(String[] args) {
        SumColumnWise sumColumnWise = new SumColumnWise();
        int[][] matrix = {
                {1,2,3,4},
                {7,4,7,9},
                {0,9,7,6}
        };
        int N=3;
        int M=4;

        sumColumnWise.approach1(matrix, N, M);
    }
}

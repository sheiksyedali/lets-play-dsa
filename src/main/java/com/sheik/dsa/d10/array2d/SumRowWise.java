package com.sheik.dsa.d10.array2d;

/**
 * Author: Sheik Syed Ali
 * Date: 13 Apr 2024
 */

/**
 * Given MxN matrix, print row wise sum
 */
public class SumRowWise {

    /**
     * TC: O(N pow 2); SC: O(1)
     */
    public void approach1(int[][] matrix, int M, int N){
        for(int i=0; i<M; i++){
            int sum = 0;
            for(int j=0; j<N; j++){
                sum += matrix[i][j];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        SumRowWise sumRowWise = new SumRowWise();

        int[][] input = {
                {1,2,3,4},
                {1,2,4,6},
                {3,3,3,3}
        };
        int M=3;
        int N=4;

        sumRowWise.approach1(input, M, N);
    }
}

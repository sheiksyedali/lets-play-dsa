package com.sheik.dsa.d10.array2d;

import java.util.ArrayList;

/**
 * Author: Sheik Syed Ali
 * Date: 14 Apr 2024
 */
public class AddMatrices {

    /**
     *
     * TC: O(N pow 2); SC: O(N)
     */
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> sumMatrix = new ArrayList<>();
        int rows = A.size();
        int cols = A.get(0).size();
        for(int i=0; i<rows; i++){
            ArrayList<Integer> sum = new ArrayList<>();
            for(int j=0; j<cols; j++){
                int m1 = A.get(i).get(j);
                int m2 = B.get(i).get(j);
                sum.add(m1+m2);
            }
            sumMatrix.add(sum);
        }
        return sumMatrix;
    }

}

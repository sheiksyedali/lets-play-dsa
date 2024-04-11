package com.sheik.dsa.d11.slidingwiindow;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Apr 2024
 */

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Given an array A of length N. Also given are integers B and C.
 * Return 1 if there exists a subarray with length B having sum C and 0 otherwise
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 104
 * 1 <= B <= N
 * 1 <= C <= 109
 *
 * Input 1:
 * A = [4, 3, 2, 6, 1]
 * B = 3
 * C = 11
 *
 * Input 2:
 * A = [4, 2, 2, 5, 1]
 * B = 4
 * C = 6
 *
 * Example Output
 * Output 1:
 * 1
 *
 * Output 2:
 * 0
 */
public class SubArrayWithSumAndLen {

    /**
     *  Iterate upto N-1
     *  Start index = 0 and end index = B -1
     *  increment by 1 for both index at end
     *  Find the sum match -> Iterating all element between start and end index (brute force)
     *
     *  TC O(N pow 2); SC O(1)
     */
    public int approach1(ArrayList<Integer> A, int B, int C){

        int N = A.size();

        int l = 0;
        int r = B - 1;
        while (r < N){

            int sum = 0;
            for(int i=l; i<=r; i++){
                sum += A.get(i);
            }

            System.out.println("Sum: "+sum);//Checking the match

            if(sum == C){
                return 1;
            }

            l++;
            r++;

        }
        return 0;
    }

    /**
     * Technique: Prefix sum
     * Generate the prefix sum array
     * Start index = 0 and end index =  B -1
     * Iterate an input array upto N-1 each set with B elements
     * Find the sum using pf array
     *
     * TC O(N); SC O(1)
     */
    public int approach2(ArrayList<Integer> A, int B, int C){
        int N = A.size();

        //Generate prefix sum
        for(int i=1; i<N; i++){
            int pfSum = A.get(i-1) + A.get(i);
            A.set(i, pfSum);
        }

        //Check the sum match
        int l=0;
        int r=B-1;
        while (r < N){
            int sum = 0; // Constraints of A[i] is greater than or equal to 1
            if(l == 0){
                sum = A.get(r);
            } else {
                sum = A.get(r) - A.get(l-1);
            }

            System.out.println("sum: "+sum);

            if(sum == C){
                return 1;
            }

            l++;
            r++;
        }

        return 0;
    }

    /**
     * Technique: Sliding window
     * TC O(N); SC O(1)
     */
    public int approach3(ArrayList<Integer> A, int B, int C){
        int N = A.size();
        int s = 0;
        int e = B - 1;
        int sum = 0;

        //Calculate the sum for first B (0 - B-1) elements
        for(int i=s; i<=e; i++){
            sum += A.get(i);
        }

        //Check the first sum matched with C
        if(sum == C){
            return 1;
        }

        s = 1;
        e++;
        //Find the sum using sliding window technique
        while (e < N){
            sum = sum + A.get(e) - A.get(s - 1);

            System.out.println("sum: "+sum);

            if(sum == C){
                return 1;
            }
            s++;
            e++;
        }

        return 0;
    }

    public int solve(ArrayList<Integer> A, int B, int C) {
        int N = A.size();
        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A.get(i);
        }
        if (sum == C) return 1;
        else {
//            System.out.println("B="+B);
            for (int i = B; i < N; i++) {
//                System.out.println(i+"; "+(i-B));
                sum = sum - A.get(i - B) + A.get(i);
                if (sum == C) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SubArrayWithSumAndLen subArrayWithSumAndLen = new SubArrayWithSumAndLen();

        int[] input = {4, 3, 2, 6, 1};
        int B = 3;
        int C = 11;

//        subArrayWithSumAndLen.approach3(Utils.toList(input), B, C);
        subArrayWithSumAndLen.solve(Utils.toList(input), B, C);
    }
}

package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 05 Apr 2024
 */

/***
 * You have given a string A having Uppercase English letters.
 * You have to find how many times subsequence "AG" is there in the given string.
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 *
 * Problem Constraints
 * 1 <= length(A) <= 105
 *
 * Example Input
 * Input 1:
 *  A = "ABCGAG"
 *
 * Input 2:
 *  A = "GAB"
 *
 *  Example Output
 * Output 1:
 *  3
 *
 * Output 2:
 *  0
 *
 *  (Approach1) TC Big (O) = N; SC Big (O) = 1
 */
public class SubsequenceAG {

    /**
     * We need to find AG pair in a given string
     * Observation:
     * A must come first
     * G must come second
     * So, we need to approach from right to left
     * Count the G, if we found A then pair count + G count
     *
     * Technique: Right to left approach
     * TC Big (O) = N
     * SC Big (O) = 1
     *
     */
    public int approach1(String input){
        int pairCount = 0;
        int gCount = 0;
        for(int i=input.length()-1; i>=0; i--){
            if(input.charAt(i) == 'G'){
                gCount++;
            }

            if(input.charAt(i) == 'A'){
                pairCount = pairCount + gCount;
            }
        }

        System.out.println("AG Pair Count: "+pairCount);
        return pairCount;
    }

    public static void main(String[] args) {
        SubsequenceAG subsequenceAG = new SubsequenceAG();
        String input = "AXYGAGGYNAG";
        subsequenceAG.approach1(input);
    }
}

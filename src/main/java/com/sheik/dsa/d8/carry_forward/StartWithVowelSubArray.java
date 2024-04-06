package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 05 Apr 2024
 */

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 *
 * Input
 *     ABEC
 *
 * Output
 *     6
 *
 * Explanation
 *     Amazing substrings of given string are :
 *     1. A
 *     2. AB
 *     3. ABE
 *     4. ABEC
 *     5. E
 *     6. EC
 *     here number of substrings are 6 and 6 % 10003 = 6.
 *
 *  approach1:
 *      TC Big(O) = N; SC Big(O) = 1
 *
 */
public class StartWithVowelSubArray {

    /**
     *
     * Observation:
     *      Element start with sub array count will be, length of the array - position of the element
     *      eg:-
     *      ABEC (sub array count for start with A)
     *          ABEC
     *          ABE
     *          AB
     *          A
     *      Total: 4
     *
     *  approach1:
     *      TC Big(O) = N; SC Big(O) = 1
     */
    public int approach1(String A){
        int count = 0;
        A = A.toLowerCase();
        int len = A.length()-1;
        for(int i=0; i<=len; i++){
            char letter = A.charAt(i);
            if( letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
                count = count + (len - i + 1);
            }
        }
        System.out.println("Starting with vowel sub array count: "+  count);
        return count;
    }
}

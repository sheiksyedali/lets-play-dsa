package com.sheik.dsa.d8.carry_forward;

/**
 * Author: Sheik Syed Ali
 * Date: 06 Apr 2024
 */

import com.sheik.dsa.util.Utils;

import java.util.ArrayList;

/**
 * Problem Description
 * A wire connects N light bulbs.
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 *
 * Problem Constraints
 * 0 <= N <= 5×105
 * 0 <= A[i] <= 1
 *
 * Example Input
 * Input 1:
 *
 *  A = [0, 1, 0, 1]
 * Input 2:
 *
 *  A = [1, 1, 1, 1]
 *
 *
 * Example Output
 * Output 1:
 *  4
 * Output 2:
 *  0
 *
 * Example Explanation
 * Explanation 1:
 *
 *  press switch 0 : [1 0 1 0]
 *  press switch 1 : [1 1 0 1]
 *  press switch 2 : [1 1 1 0]
 *  press switch 3 : [1 1 1 1]
 * Explanation 2:
 *
 *  There is no need to turn any switches as all the bulbs are already on.
 */
public class Bulbs {

    /**
     *
     * Observation:
     *      if n times switch changed the state then
     *          n%2 = 0 -> The final state is the original state (Starting state 1, 4 times state changed then final state is 1)
     *          n%2 = 1 -> The final state is the changed state (Starting state 1, 3 times state changed then final state is 0)
     *  Add the global counter to track the state changes
     *  Check the global counter when approaching the switch
     *  Global counter is even then switch is in original state
     *  Global counter is odd then switch is the changed state
     *
     */
    public int approach1(ArrayList<Integer> A){
        int stateChangeCounter = 0;

        for(int i=0; i<A.size(); i++){
            int switchChangeState = stateChangeCounter % 2;
            int state = A.get(i);
            if(switchChangeState != 0){
                state = (state == 0) ? 1 : 0;
            }

            if(state == 0){
                A.set(i, 1);
                stateChangeCounter++;
            }

        }

        System.out.println("Total switches to ON the all the bulbs: "+ stateChangeCounter);

        return stateChangeCounter;
    }

    public static void main(String[] args) {
        Bulbs bulbs = new Bulbs();

        int[] input = {1, 1, 1, 1};
//        int[] input = {0, 1, 0, 1};


        bulbs.approach1(Utils.toList(input));
    }

}

package com.sheik.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Author: Sheik Syed Ali
 * Date: 09 Mar 2024
 */
public class CountWord {
    String sub = "an";
    Function<String, Integer> count1 = s -> {
        int index = s.indexOf(sub, 0);
        int count = 0;
        while (index > 0){
            count ++;
            index = s.indexOf(sub, index+1);
        }
        return count;
    };

    Function<String, Integer> count2 = s -> {
        int strLen = s.length();
        s = s.replaceAll(sub, "");
        int repLen = s.length();
        int diff = strLen - repLen;
        return diff/sub.length();
    };

    public int count1(String input){
        return count1.apply(input);
    }

    public int count2(String input){
        return count2.apply(input);
    }

    public static void main(String[] args) {
        String input = "guna seelan guna seelan guna seelan sal1";
        String input1 = "sheik syed sheik syed sheik syed aslkd";

        CountWord countWord = new CountWord();
        System.out.println(countWord.count1(input));
        System.out.println(countWord.count2(input));

        List<String> list = new ArrayList<>();


    }

}

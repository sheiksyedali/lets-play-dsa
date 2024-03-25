package com.sheik.misc;

/**
 * Author: Sheik Syed Ali
 * Date: 11 Mar 2024
 */
public class TestMe {
    public static void main(String[] args) {
        //Given an Array of N integers find the number of Zero's in the array
        //                input = {9,6,0,0,5,0,-1,0}
        
       String sh = "tikXtok";
       boolean iterate = true;
       String output = "";
       int startIndex = -1;
       int endIndex = 3;

       while (iterate){
           startIndex = startIndex + 1;
           endIndex = startIndex + 3;
           if(endIndex >= sh.length()){
               endIndex = sh.length();
           }
           String sub = sh.substring(startIndex, endIndex);
           char startChar = sub.charAt(0);
           char endChar = sub.charAt(2);
           if(startChar == 't' && endChar == 'k'){
               output = output + "tk";
           }
           System.out.println(sub);
           if(endIndex == sh.length()){
               break;
           }
       }

        System.out.println(output);

    }
}

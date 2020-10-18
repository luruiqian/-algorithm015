package com.leetode.application;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    //    public List<String> generateParenthesis(int n) {
//        List<String> result = new ArrayList<>();
//        generateParenthesisHelper(result, 0, n, "");
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//            Log.i("11111111---------", result.get(i));
//        }
//        return result;
//    }
//
//    private void generateParenthesisHelper(List<String> result, int index, int n, String s) {
//        //terminate
//        if(index > n) return;
//        if (index == n) {
//            //this level
//            StringBuilder builder = new StringBuilder();
//            builder.append(s);
//            result.add(builder.toString());
//        }
//        //drill down
//        generateParenthesisHelper(result, index + 1, n, s + "(");
//        generateParenthesisHelper(result, index + 1, n, s + ")");
//        //reverse
//    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, 0, 0, n, "");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
            Log.i("11111111---------", result.get(i));
        }
        return result;
    }

    private void generateParenthesisHelper(List<String> result, int left, int right, int n, String s) {
        //terminate
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        //drill down
        if (left < n) {
            generateParenthesisHelper(result, left + 1, right, n, s + "(");
        }
        if (left > right) {
            generateParenthesisHelper(result, left, right + 1, n, s + ")");
        }
        //revert
    }

}

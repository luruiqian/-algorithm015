package com.leetode.application;

import java.util.ArrayList;
import java.util.List;

class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(result,new ArrayList<Integer>(),1,n,k);
        return result;
    }

    private void combineHelper(List<List<Integer>> result, ArrayList<Integer> list, int start, int n, int k) {
        //terminate
        if(k == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        //process
        //next level
        for(int i = start;i <= n;i++){
            list.add(i);
            combineHelper(result,list,i + 1,n,k - 1);
            list.remove(list.size() - 1);
        }
        //revert

    }
}

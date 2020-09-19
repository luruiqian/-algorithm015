package com.leetode.application;

import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gSize = g.length;
        int sSize = s.length;
        int gPoint = 0;
        int sPoint = 0;
        while (gPoint < gSize && sPoint < sSize) {
            if (s[sPoint] >= g[gPoint]) {
                count += 1;
                gPoint += 1;
                sPoint += 1;
            } else {
                sPoint += 1;
            }
        }
        return count;
    }
}
